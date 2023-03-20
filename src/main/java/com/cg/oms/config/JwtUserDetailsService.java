package com.cg.oms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.oms.entity.Users;
import com.cg.oms.repositiory.IUserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		Optional<Users> user = userDao.findByUsername(username);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		roles = Arrays.asList(new SimpleGrantedAuthority(user.get().getRole()));
		System.out.println("Roles : "+roles);
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(),
				roles);
		//return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
			//	new ArrayList<>());
	}
	

}