package com.sistemaescolar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sistemaescolar.exceptions.UserNotFoundException;
import com.sistemaescolar.models.Users;
import com.sistemaescolar.repositories.UsersRepository;

public class UserDetailServiceImpl implements UserDetailsService {

	
	
	@Autowired
	private UsersRepository repository; 
	
	 @Override
	    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
	        Users user = repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
	        return new UserDetailsImpl(user);
	    }
	
	
}
