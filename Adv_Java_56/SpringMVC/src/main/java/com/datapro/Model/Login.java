package com.datapro.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "java56smvcr")
public class Login {
	
	@Id
	private long id;
	
	@Column(length = 20)
	private String name;
	
	
	@Column(length = 25)
	private String email;
	
	@Column(length = 25)
	private String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
