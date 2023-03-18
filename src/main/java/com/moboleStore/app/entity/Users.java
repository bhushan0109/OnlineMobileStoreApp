package com.moboleStore.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Pattern(regexp = "[a-zA-Z]{3,30}", message = "username should only contain characters and should be atleast a length of 3")
	private String username;

	@Pattern(regexp = "[a-zA-Z]{3,30}", message = "role should only contain characters and should be atleast a length of 3")
	private String role;

	@NotBlank
	@Email(message = "Give a proper emailId")
	private String emailId;

	@Pattern(regexp = "[a-zA-Z$%&!@]{6,}", message = "Password must be 6 characters, and no special characters allowed")
	private String password;

	public Users() {
		super();
	}

	@OneToOne
	private Cart cart;

	public Integer getUserId() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", role=" + role + ", emailId=" + emailId
				+ ", password=" + password + ", cart=" + cart + "]";
	}

	public Users(Integer userId,
			@Pattern(regexp = "[a-zA-Z]{3,30}", message = "username should only contain characters and should be atleast a length of 3") String username,
			@Pattern(regexp = "[a-zA-Z]{3,30}", message = "role should only contain characters and should be atleast a length of 3") String role,
			@NotBlank @Email(message = "Give a proper emailId") String emailId,
			@Pattern(regexp = "[a-zA-Z$%&!@]{6,}", message = "Password must be 6 characters, and no special characters allowed") String password,
			Cart cart) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.emailId = emailId;
		this.password = password;
		this.cart = cart;
	}

}
