package com.moboleStore.app.service;

import java.util.List;

import javax.validation.Valid;

import com.moboleStore.app.dto.AddUserDto;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.UserNotFoundException;
import com.moboleStore.app.exception.UsersException;


public interface IUserService {
	public Users addUser(@Valid AddUserDto addUserDto) throws UsersException;
	public AddUserDto updateUser(@Valid AddUserDto addUserDto) throws UserNotFoundException, UsersException;
	public Users removeUser(int userId) throws UserNotFoundException, UsersException;
	public List<Users> showAllUsers();
	public AddUserDto getUserByUserId(Integer userId) throws UsersException;
	public List<AddUserDto> showAllCustomer() throws UsersException;
}
