package com.cg.oms.service;

import java.util.List;

import javax.validation.Valid;

import com.cg.oms.dto.AddUserDto;
import com.cg.oms.entity.Users;
import com.cg.oms.exception.UserNotFoundException;
import com.cg.oms.exception.UsersException;


public interface IUserService {
	public Users addUser(@Valid AddUserDto addUserDto) throws UsersException;
	public AddUserDto updateUser(@Valid AddUserDto addUserDto) throws UserNotFoundException, UsersException;
	public Users removeUser(int userId) throws UserNotFoundException, UsersException;
	public List<Users> showAllUsers();
	public AddUserDto getUserByUserId(int userId) throws UsersException;
	public List<AddUserDto> showAllCustomer() throws UsersException;
}
