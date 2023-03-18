package com.moboleStore.app.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moboleStore.app.entity.Users;
import com.moboleStore.app.repositiory.IUserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserRepository iUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
        Users user = iUserRepository.findByUsername(username)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );

        return UserPrinciple.build(user);
    }
}