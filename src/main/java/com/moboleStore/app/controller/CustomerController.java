package com.moboleStore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moboleStore.app.dto.AddUserDto;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.UserNotFoundException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private IUserService iUserService;

    @PutMapping("/edit/user")
    public AddUserDto UserServiceUpdate(@Valid @RequestBody AddUserDto addUserDto) throws UsersException, UserNotFoundException  {
        return iUserService.updateUser(addUserDto);
    }
    @DeleteMapping("/delete/{userId}")
    public Users iUserServiceRemove(@PathVariable("userId") Integer userId) throws UsersException, UserNotFoundException {
        return iUserService.removeUser(userId);
    }
    
    @GetMapping("/allUsers")
    public List<Users> getUsers() {
        return iUserService.showAllUsers();
    }
    
    @GetMapping("/get/{userId}")
    public AddUserDto getUserById(@PathVariable("userId") Integer userId) throws UsersException{
        return iUserService.getUserByUserId(userId);
    }
    

}
