package com.moboleStore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moboleStore.app.entity.LoginDTO;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsersController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/user")
    public Users addUser(@Valid @RequestBody Users user) throws UsersException{
        return userService.addUser(user);
        
    }
    @PutMapping("/user")
    public Users UserServiceUpdate(@Valid @RequestBody Users user) throws UsersException  {
        return userService.updateUser(user);
    }
    @DeleteMapping("/user/{userId}")
    public Users userServiceRemove(@PathVariable("userId") Integer usersId) throws UsersException {
        return userService.removeUser(usersId);
    }
    
    @GetMapping("/allUsers")
    public List<Users> getUsers() {
        return userService.showAllUsers();
    }
    
    @GetMapping("/User/{id}")
    public Users getUserById(@PathVariable("id") Integer userId) throws UsersException{
        return userService.getUserByUserId(userId);
    }
    
    @PostMapping("user/login")
	public Users userLogin(@RequestBody LoginDTO loginDto) throws UsersException {
		return this.userService.userLogin(loginDto.getEmailId(), loginDto.getPassword());
	}
    
    
    @PutMapping("user/{id}")
    public Users changePassword(@PathVariable ("id") Integer id, @RequestBody String password) {
    	return this.userService.changePassword(id, password);
    }


}
