package com.cg.oms.controller;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTestController {
	
	@GetMapping("/")
	public String home() {
		return "<h1> Home Page</h1>";
	}
	@GetMapping("/user")
	public String user() {
		return "<h1> User Page</h1>";
	}
	@GetMapping("/admin")
	public String admin() {
		return "<h1> Admin Page</h1>";
	}
	
	@GetMapping("/update")
	@PreAuthorize("hasAuthority('Admin')")
	public String update(Principal p) {
		return "<h1> Update Page "+p.getName()+"</h1>";
	}
	@GetMapping("/user1")
	@PreAuthorize("hasAuthority('User')")
	public String user1(Principal p) {
		return "<h1> User Page  "+p.getName()+"</h1>";
	}
	
}
