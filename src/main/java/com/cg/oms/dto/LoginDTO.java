package com.cg.oms.dto;

public class LoginDTO {
	private String emailId;
	private String password;
	public LoginDTO(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	public LoginDTO() {
		super();
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
