package com.moboleStore.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.moboleStore.app.entity.Admin;
import com.moboleStore.app.entity.LoginDTO;
import com.moboleStore.app.exception.AdminException;
import com.moboleStore.app.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("admin/login")
	public Admin adminLogin(@RequestBody LoginDTO loginDto) throws AdminException {
		return this.adminService.login(loginDto.getEmailId(), loginDto.getPassword());
	}
	
	@PostMapping("admin")
	public Admin addAdmin(@RequestBody  Admin admin) throws AdminException{
		return this.adminService.addAdmin(admin);
	}
	
	@PutMapping("admin/{id}")
	public Admin changePassword(@PathVariable("id") Integer id, @RequestBody String password ) {
		return this.adminService.changePassword(id, password);
	}


}
