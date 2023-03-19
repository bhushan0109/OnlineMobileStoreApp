package com.moboleStore.app.service;

import java.util.ArrayList;
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
	public AddUserDto updateUser(AddUserDto addUserDto) throws UserNotFoundException, UsersException {
		if (!(addUserDto.getRole().equals("User") || addUserDto.getRole().equals("Admin"))) {

			throw new UsersException("ROLE should be User or Admin");
		}
		
		Optional<Users> optUsers = this.iUserRepository.findById(addUserDto.getUserId());
		if (optUsers.isEmpty())
			throw new UsersException("User id does not exists to update !");

		Users user = optUsers.get();
		BeanUtils.copyProperties(addUserDto, user);
		if (addUserDto.getPassword() != null) {
			user.setPassword(bcryptEncoder.encode(addUserDto.getPassword().trim()));
		}
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
		return addUserDto;
	}

	@Override
	public Users removeUser(int userId) throws UserNotFoundException, UsersException {
		Optional<Users> optUsers = this.iUserRepository.findById(userId);
		if (optUsers.isEmpty())
			throw new UsersException("User id does not exists to delete !");
		Users user = optUsers.get();
		this.iUserRepository.delete(user);
		return null;
	}

	@Override
	public List<Users> showAllUsers() {
		return iUserRepository.findAll();
	}

	@Override
	public AddUserDto getUserByUserId(Integer userId) throws UsersException {
		AddUserDto AddUserDto = new AddUserDto();
		Optional<Users> optUsers = this.iUserRepository.findById(userId);
		if (optUsers.isEmpty())
			throw new UsersException("User id does not exists to delete !");
		Users user = optUsers.get();

		if (user.getRole().equalsIgnoreCase("Admin")) {

			AddUserDto.setAddress(null);
			AddUserDto.setEmailId(null);
			AddUserDto.setMobileNumber(null);
			AddUserDto.setPassword(user.getPassword());
			AddUserDto.setRole(user.getRole());
			AddUserDto.setUserId(user.getUserId());
			AddUserDto.setUsername(user.getUsername());
			AddUserDto.setName(user.getUsername());

		} else {

			Optional<Customer> optCustomer = iCustomerRepository.findById(userId);
			if (optCustomer.isEmpty()) {
				throw new UsersException("CustomerId not found:" + userId);
			}
			Customer customer = optCustomer.get();
			AddUserDto.setAddress(customer.getAddress());
			AddUserDto.setEmailId(customer.getEmailId());
			AddUserDto.setMobileNumber(customer.getMobileNumber());
			AddUserDto.setPassword(user.getPassword());
			AddUserDto.setRole(user.getRole());
			AddUserDto.setUserId(user.getUserId());
			AddUserDto.setUsername(user.getUsername());
			AddUserDto.setName(user.getUsername());

		}

		return AddUserDto;
	}

	@Override
	public List<AddUserDto> showAllCustomer() throws UsersException {

		List<Users> alluser = iUserRepository.findAll();
		List<AddUserDto> alldto = new ArrayList<AddUserDto>();
		for (Users users : alluser) {

			AddUserDto AddUserDto = new AddUserDto();
			Optional<Users> optUsers = this.iUserRepository.findById(users.getUserId());
			if (optUsers.isEmpty())
				throw new UsersException("User id does not exists to delete !");
			Users user = optUsers.get();

			if (user.getRole().equalsIgnoreCase("Admin")) {

				AddUserDto.setAddress(null);
				AddUserDto.setEmailId(null);
				AddUserDto.setMobileNumber(null);
				AddUserDto.setPassword(user.getPassword());
				AddUserDto.setRole(user.getRole());
				AddUserDto.setUserId(user.getUserId());
				AddUserDto.setUsername(user.getUsername());
				AddUserDto.setName(user.getUsername());

			} else {

				Optional<Customer> optCustomer = iCustomerRepository.findById(users.getUserId());
				if (optCustomer.isEmpty()) {
					throw new UsersException("CustomerId not found:" + users.getUserId());
				}
				Customer customer = optCustomer.get();
				AddUserDto.setAddress(customer.getAddress());
				AddUserDto.setEmailId(customer.getEmailId());
				AddUserDto.setMobileNumber(customer.getMobileNumber());
				AddUserDto.setPassword(user.getPassword());
				AddUserDto.setRole(user.getRole());
				AddUserDto.setUserId(user.getUserId());
				AddUserDto.setUsername(user.getUsername());
				AddUserDto.setName(user.getUsername());

			}
			alldto.add(AddUserDto);
		}
		return alldto;
	}

}
