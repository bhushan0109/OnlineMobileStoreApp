package com.cg.oms.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.config.JwtTokenUtil;
import com.cg.oms.config.JwtUserDetailsService;
import com.cg.oms.dto.AddUserDto;
import com.cg.oms.dto.JwtRequest;
import com.cg.oms.dto.JwtResponse;
import com.cg.oms.entity.Users;
import com.cg.oms.repositiory.IUserRepository;
import com.cg.oms.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("authentication")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private IUserRepository userDao;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IUserService iUserService;
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		Optional<Users> user = userDao.findByUsername(authenticationRequest.getUsername());
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + authenticationRequest.getUsername());
		}
		final String token = jwtTokenUtil.generateToken(userDetails);
         System.out.println("Get Authorities :"+userDetails.getAuthorities());
		return ResponseEntity.ok(new JwtResponse("Bearer "+token,userDetails.getAuthorities().toString(),user.get().getUserId()));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody AddUserDto addUserDto) throws Exception {
		return ResponseEntity.ok(iUserService.addUser(addUserDto));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
