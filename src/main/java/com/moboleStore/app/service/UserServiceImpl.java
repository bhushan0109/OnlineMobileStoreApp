package com.moboleStore.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.moboleStore.app.dto.AddUserDto;
import com.moboleStore.app.entity.Admin;
import com.moboleStore.app.entity.Customer;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.UserNotFoundException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.repositiory.AdminRespository;
import com.moboleStore.app.repositiory.ICustomerRepository;
import com.moboleStore.app.repositiory.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private ICustomerRepository iCustomerRepository;

	@Autowired
	private IUserRepository iUserRepository;

	@Autowired
	private AdminRespository adminRespository;
	

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public Users addUser(AddUserDto addUserDto) throws UsersException {

		if (!(addUserDto.getRole().equals("User") || addUserDto.getRole().equals("Admin"))) {

			throw new UsersException("ROLE should be User or Admin");
		}
		Optional<Users> findByUsername = iUserRepository.findByUsername(addUserDto.getUsername());
		if (findByUsername.isPresent()) {
			throw new UsersException("Username already exists, try to login");
		}

		Users user = new Users();
		BeanUtils.copyProperties(addUserDto, user);
		user.setPassword(bcryptEncoder.encode(addUserDto.getPassword()));
		Users saveuser = iUserRepository.save(user);

		if (addUserDto.getRole().equalsIgnoreCase("ADMIN")) {
			Admin admin = new Admin();
			admin.setId(saveuser.getUserId());
			admin.setAdminame(addUserDto.getName());
			adminRespository.save(admin);
		} else {
			Customer c = new Customer();
			BeanUtils.copyProperties(addUserDto, c);
			c.setCustomerName(addUserDto.getName());
			c.setCustomerId(saveuser.getUserId());
			iCustomerRepository.save(c);
		}

		return saveuser;
	}

	@Override
	public Users updateUser(Users User) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users removeUser(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> showAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateUser(int userid, String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users getUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Users removeUser(Integer UserId) throws UsersException {
//		Optional<Users> optUsers = this.userRepository.findById(UserId);
//		if (optUsers.isEmpty())
//			throw new UsersException("User id does not exists to delete !");
//		Users user = optUsers.get();
//		this.userRepository.delete(user);
//		return user;
//	}
//
//	@Override
//	public List<Users> showAllUsers() {
//
//		return userRepository.findAll();
//	}
//
//	@Override
//	public Users getUserByUserId(Integer userId) throws UsersException {
//		Optional<Users> optUsers = this.userRepository.findById(userId);
//		if (optUsers.isEmpty())
//			throw new UsersException("User id does not exists");
//
//		return optUsers.get();
//	}
//
//	@Override
//	public Users getUserByemailId(String emailId) throws UsersException {
//		Users user = userRepository.findByEmailId(emailId);
//		if (user == null) {
//			throw new UsersException("user not found");
//		}
//		return user;
//	}
//
//	@Override
//	public Users updateUser(Users user) throws UsersException {
//		Optional<Users> optUsers = this.userRepository.findById(user.getUserId());
//		if (optUsers.isEmpty())
//			throw new UsersException("User id does not exists");
//		return userRepository.save(user);
//	}
//
//	@Override
//	public Users userLogin(String emailId, String password) throws UsersException {
//		Users user = userRepository.findByEmailId(emailId);
//
//		if (user == null) {
//			throw new UsersException("email Id doesnt exist");
//		} else if (user.getPassword() == null || !user.getPassword().equals(password)) {
//			throw new UsersException("password is incorrect");
//		}
//		return user;
//	}
//
//	@Override
//	public Users changePassword(Integer id, String changedPassword) {
//		if (userRepository.existsById(id)) {
//			Users user = userRepository.findById(id).get();
//			user.setPassword(changedPassword);
//			return user;
//		} else {
//			return null;
//		}
//
//	}
}
