package com.moboleStore.app.service;

import java.util.List;

import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.UsersException;

public interface UserService {
	public Users addUser(Users user) throws UsersException ;

	public Users updateUser(Users user) throws UsersException;

	public Users removeUser(Integer UserId) throws UsersException;

	public List<Users> showAllUsers();

	public Users getUserByUserId(Integer userId) throws UsersException;
	
	public Users getUserByemailId(String emailId) throws UsersException;
	
	public Users userLogin(String emailId, String password)throws UsersException;
	
	public Users changePassword(Integer id, String changedPassword) ;
	

}
