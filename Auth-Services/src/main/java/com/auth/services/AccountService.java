package com.auth.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.auth.entities.AppRole;
import com.auth.entities.AppUser;

@Service
public interface AccountService {
	
	AppUser addNewUSer(AppUser appUser);
	AppRole addNewRole(AppRole appRole);
	void addRoleToUser(String username, String roleName);
	AppUser getUserByUserName(String username);
	List<AppUser> getUsers();

}
