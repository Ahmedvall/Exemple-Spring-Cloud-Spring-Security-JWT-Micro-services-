package com.auth.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> lesRoles = new ArrayList<AppRole>();

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(String username, String password, Collection<AppRole> lesRoles) {
		super();
		this.username = username;
		this.password = password;
		this.lesRoles = lesRoles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<AppRole> getLesRoles() {
		return lesRoles;
	}

	public void setLesRoles(Collection<AppRole> lesRoles) {
		this.lesRoles = lesRoles;
	}
	
}
