package com.cg.oms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDetailsDto {
	
	
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

	@NotNull
	@Size(min = 4, message = "password  must have at least 4 characters")
	private String password;

	@NotNull
	@Size(min = 4, message = "address  must have at least 4 characters")
	private String address;
	
	

}
