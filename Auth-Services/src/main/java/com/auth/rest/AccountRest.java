package com.auth.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entities.AppRole;
import com.auth.entities.AppUser;
import com.auth.services.AccountService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AccountRest {

	private AccountService accountService;
	
	public AccountRest(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	@GetMapping(path = "/users")
	@PostAuthorize("hasAuthority('USER')")
	public List<AppUser> appUsers() {
		return accountService.getUsers();
	}
	
	@GetMapping(path = "/users/{username}")
	public AppUser getUserByUserName(@PathVariable String username) {
		return accountService.getUserByUserName(username);
	}
	
	
	@PostMapping(path = "/users")
	@PostAuthorize("hasAuthority('ADMIN')")
	public AppUser saveAppUser(@RequestBody AppUser appUser) {
		return accountService.addNewUSer(appUser);
	}
	
	
	
	@PostMapping(path = "/roles")
	public AppRole appRoles(@RequestBody AppRole appRole) {
		return accountService.addNewRole(appRole);
	}
	
	
	@PostMapping(path = "/addRoleToUser/{username}/{roleName}")
	public void addRoleToUser(@PathVariable String username, 
			@PathVariable String roleName) {
		accountService.addRoleToUser(username, roleName);
	}
	
	
	@GetMapping("/refreshToken")
	public void refreshToken(HttpServletResponse response,HttpServletRequest request ) throws Exception {
	
		String authorizationToken = request.getHeader("Authorization");
		if(authorizationToken != null && authorizationToken.startsWith("Bearer ")) {
			
			
			try {
				
				String jwt = authorizationToken.substring(7);
				Algorithm algorithm = Algorithm.HMAC256("mysecret2021");
				JWTVerifier jwtVerifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
				String username = decodedJWT.getSubject();
				
				AppUser user = accountService.getUserByUserName(username);
				
				
				Algorithm algo = Algorithm.HMAC256("mysecret2021");
				String jwtAccessToken = JWT.create()
						.withSubject(user.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis()+1*60*1000))
						.withIssuer(request.getRequestURI().toString())
						.withClaim("roles", user.getLesRoles().stream().map(r->r.getRoleName()).collect(Collectors.toList()))
						.sign(algo);
				
				
				
				String jwtRefreshToken = JWT.create()
						.withSubject(user.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis()+15*60*1000))
						.withIssuer(request.getRequestURI().toString())
						.sign(algo);
				
				Map<String, String> idToken = new HashMap<>();
				idToken.put("access-token", jwtAccessToken);
				idToken.put("refresh-token", jwtRefreshToken);
				
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), idToken);
				
				
			} catch (Exception e) {
				
				throw e;
				
			}
			
			
		}else {
			throw new RuntimeException("Refresh Token required !!!");
		}
		
		
		
		
	}
	

}
