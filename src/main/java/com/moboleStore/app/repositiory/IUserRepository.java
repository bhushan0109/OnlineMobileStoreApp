package com.moboleStore.app.repositiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moboleStore.app.entity.Users;
@Repository
public interface IUserRepository  extends JpaRepository<Users, Integer> {
	
	Optional<Users> findByUsername(String username);
	
//	Users findByEmailId(String emailId);;
//	public Users addUser(Users User);
//	public Users updateUser(Users User) throws UserNotFoundException;
//	public Users removeUser(int userId) throws UserNotFoundException;
//	public List<Users> showAllUsers();
//	public boolean validateUser(int userid,String userName);
}
