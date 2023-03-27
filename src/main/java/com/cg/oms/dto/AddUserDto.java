package com.cg.oms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddUserDto {

	private int userId;

	@Pattern(regexp = "[a-zA-Z]{3,30}", message = "username should only contain characters and should be atleast a length of 3")
	private String username;
	
	@Pattern(regexp = "[a-zA-Z]{3,30}", message = "username should only contain characters and should be atleast a length of 3")
	private String name;

	@Pattern(regexp = "[a-zA-Z]{3,30}", message = "role should only contain characters and should be atleast a length of 3")
	private String role;

	@NotBlank
	@Email(message = "Give a proper emailId")
	private String emailId;

	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number is invalid")
	private String mobileNumber;

//	@NotNull
//	@Size(min = 4, message = "password  must have at least 4 characters")
	private String password;

	@NotNull
	@Size(min = 4, message = "address  must have at least 4 characters")
	private String address;

	public int getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddUserDto(int userId,
			@Pattern(regexp = "[a-zA-Z]{3,30}", message = "username should only contain characters and should be atleast a length of 3") String username,
			@Pattern(regexp = "[a-zA-Z]{3,30}", message = "username should only contain characters and should be atleast a length of 3") String name,
			@Pattern(regexp = "[a-zA-Z]{3,30}", message = "role should only contain characters and should be atleast a length of 3") String role,
			@NotBlank @Email(message = "Give a proper emailId") String emailId,
			@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number is invalid") String mobileNumber,
			String password,
			@NotNull @Size(min = 4, message = "address  must have at least 4 characters") String address) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.role = role;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.address = address;
	}

	@Override
	public String toString() {
		return "AddUserDto [userId=" + userId + ", username=" + username + ", name=" + name + ", role=" + role
				+ ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", password=" + password + ", address="
				+ address + "]";
	}

}
