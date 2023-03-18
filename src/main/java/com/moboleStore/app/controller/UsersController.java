package com.moboleStore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moboleStore.app.dto.AddUserDto;
import com.moboleStore.app.entity.LoginDTO;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.UserNotFoundException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.repositiory.IUserRepository;
import com.moboleStore.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class UsersController {
    @Autowired
    private IUserService iUserService;
    
    @Autowired
	private IUserRepository iUserRepository;

	@Autowired(required = false)
	AuthenticationManager authenticationManager;

    
    
    @PostMapping("/register")
    public Users userRegister(@Valid @RequestBody AddUserDto addUserDto) throws UsersException{
        return iUserService.addUser(addUserDto);
        
    }
    @PutMapping("/user")
    public Users UserServiceUpdate(@Valid @RequestBody Users user) throws UsersException, UserNotFoundException  {
        return iUserService.updateUser(user);
    }
    @DeleteMapping("/user/{userId}")
    public Users iUserServiceRemove(@PathVariable("userId") Integer usersId) throws UsersException, UserNotFoundException {
        return iUserService.removeUser(usersId);
    }
    
    @GetMapping("/allUsers")
    public List<Users> getUsers() {
        return iUserService.showAllUsers();
    }
    
    @GetMapping("/User/{id}")
    public Users getUserById(@PathVariable("id") Integer userId) throws UsersException{
        return iUserService.getUserByUserId(userId);
    }
    
//    @PostMapping("user/login")
//	public Users userLogin(@RequestBody LoginDTO loginDto) throws UsersException {
//		return this.iUserService.userLogin(loginDto.getEmailId(), loginDto.getPassword());
//	}

}