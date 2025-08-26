package com.datapro.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "java121smvcr")
public class Login {
	
	@Id
	private long phone;
	
	@Column(length=20)
	private String name;
	
	@Column(name="email_id",length=20)
	private String emailId;
	
	@Column(length=20)
	private String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(long phone,String name, String emailId, String password) {
		super();
		this.phone=phone;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
