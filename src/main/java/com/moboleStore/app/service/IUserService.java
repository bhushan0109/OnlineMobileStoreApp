package com.moboleStore.app.service;

import java.util.List;

import javax.validation.Valid;

import com.moboleStore.app.dto.AddUserDto;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.UserNotFoundException;
import com.moboleStore.app.exception.UsersException;


public interface IUserService {
	public Users addUser(@Valid AddUserDto addUserDto) throws UsersException;
	public Users updateUser(Users User) throws UserNotFoundException;
	public Users removeUser(int userId) throws UserNotFoundException;
	public List<Users> showAllUsers();
	public boolean validateUser(int userid,String userName);
	public Users getUserByUserId(Integer userId);
}
