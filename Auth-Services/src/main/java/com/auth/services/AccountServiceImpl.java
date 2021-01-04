package com.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entities.AppRole;
import com.auth.entities.AppUser;
import com.auth.repository.AppRoleRepository;
import com.auth.repository.AppUserRepository;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired private AppUserRepository appUserRepository;
	@Autowired private AppRoleRepository appRoleRepository;
	@Autowired private PasswordEncoder encoderPwd;
	
	
	@Override
	public AppUser addNewUSer(AppUser appUser) {
		appUser.setPassword(encoderPwd.encode(appUser.getPassword()));
		return appUserRepository.save(appUser);
	}

	@Override
	public AppRole addNewRole(AppRole appRole) {
		return appRoleRepository.save(appRole);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Optional<AppUser> user = appUserRepository.findByUsername(username);
		Optional<AppRole> role = appRoleRepository.findByRoleName(roleName);
		
		if(user.isPresent() && role.isPresent()) {
			
			user.get().getLesRoles().add(role.get());
			appUserRepository.save(user.get());
		}
	}

	@Override
	public AppUser getUserByUserName(String username) {
		return appUserRepository.findByUsername(username).get();
	}

	@Override
	public List<AppUser> getUsers() {
		return appUserRepository.findAll();
	}

}
