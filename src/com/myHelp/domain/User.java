package com.myHelp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class User {
	
	private int id = 0;
	
	@NotNull(message = "Username is required.")
	private String username;
	
	@NotNull(message = "Password is required.")
	private String password;
	
	private boolean accountLocked;
	
	private String role;
	
	private Employee employee;
	
	public User() {
		
	}
	
	public User(String username, String password,
			boolean accountLocked, String role) {
		super();
		this.username = username;
		this.password = password;
		this.accountLocked = accountLocked;
		this.role = role;
	}

	@Id
	@GeneratedValue(generator = "generator")
    @GenericGenerator(strategy = "foreign", name="generator",
            parameters = @Parameter(name = "property", value="employee"))
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	@Column
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
