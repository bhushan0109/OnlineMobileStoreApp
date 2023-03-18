package com.moboleStore.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.repositiory.UsersRepository;


/***********************************************************************************
 *
 * @author Gunnampalli Likhitha
 * Description It is a service class that provides the services for adding a new book, 
 * to category, updating the book, viewing the book, getting all the books,
 * and deleting a book.
 * Version 1.0
 * Created Date 09-FEB-2023

 ************************************************************************************/
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UsersRepository userRepository;
	
	
    
	
	/************************************************************************************

	 * Method:-Add new user to database
	 * Description: -To add a new user to database
	 * @param user -User to be added to added
	 * @returns Users -User is returned after adding to database
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 

	 ************************************************************************************/
    @Override
    public Users addUser(Users user) throws UsersException {
        if(userRepository.findByEmailId(user.getEmailId())!= null) {
        	throw new UsersException("EmailId already exists, try to login");
        }
        return userRepository.save(user);
    }
    
    
    
    /************************************************************************************
     * 
	 * Method:-updateUsers
	 * Description: -To update a user in database
	 * @param UserId -Id of the user to be updated
	 * @returns Users -User is returned after updating to database
	 * @throws UserNotFoundException -raised if the userId does not exist in database
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 

	 ************************************************************************************/
    

    
    
    @Override
    public Users removeUser(Integer UserId) throws UsersException {
        Optional<Users> optUsers = this.userRepository.findById(UserId);
        if (optUsers.isEmpty())
            throw new UsersException("User id does not exists to delete !");
        Users user = optUsers.get();
        this.userRepository.delete(user);
        return user;
    }
    
    
    /************************************************************************************
	 
	 * Method:-showAllUsers
	 * Description: -To get all the users in database
	 * @returns List<Users> -List of all the users present in the database is returned
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 

	 ************************************************************************************/
    @Override
    public List<Users> showAllUsers() {
        
        return userRepository.findAll();
    }

    
    /************************************************************************************
	 
	 * Method:-getUserById
	 * Description: -To get user from database
	 * @param UserId -Id of the user to be returned
	 * @returns users -User is returned 
	 * @throws UserNotFoundException -raised if the userId does not exist in database
	 * Created By -Gunnampalli Likhitha
	 * Created Date -10-FEB-2023 

	 ************************************************************************************/
	@Override
	public Users getUserByUserId(Integer userId) throws UsersException {
		Optional<Users> optUsers = this.userRepository.findById(userId);
        if (optUsers.isEmpty())
            throw new UsersException("User id does not exists");
		
		return optUsers.get();	
		}


	@Override
	public Users getUserByemailId(String emailId) throws UsersException {
		Users user = userRepository.findByEmailId(emailId);
		if(user == null) {
			throw new UsersException("user not found");
		}
		return user;
		}



	@Override
	public Users updateUser(Users user) throws UsersException {
		Optional<Users> optUsers = this.userRepository.findById(user.getUserId());
        if (optUsers.isEmpty())
            throw new UsersException("User id does not exists");
		return userRepository.save(user);
	}



	@Override
	public Users userLogin(String emailId, String password) throws UsersException{
		Users user = userRepository.findByEmailId(emailId);
		
		if(user == null) {
			throw new UsersException("email Id doesnt exist");
		}
		else if(user.getPassword()==null || !user.getPassword().equals(password)) {
			throw new UsersException("password is incorrect");
		}
		return user;
	}



	@Override
	public Users changePassword(Integer id, String changedPassword) {
		if(userRepository.existsById(id)) {
			Users user = userRepository.findById(id).get();
			user.setPassword(changedPassword);
			return user;
		}
		else {
		return null;
	}



	
	
	}
}



	
	
	


