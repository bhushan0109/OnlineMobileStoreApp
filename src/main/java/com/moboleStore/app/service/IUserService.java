package com.moboleStore.app.service;

import java.util.List;

import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.UserNotFoundException;


public interface IUserService {
	public Users addUser(Users User);
	public Users updateUser(Users User) throws UserNotFoundException;
	public Users removeUser(int userId) throws UserNotFoundException;
	public List<Users> showAllUsers();
	public boolean validateUser(int userid,String userName);
}
