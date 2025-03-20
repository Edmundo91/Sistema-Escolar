package com.sistemaescolar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.sistemaescolar.exceptions.UserNotFoundException;
import com.sistemaescolar.models.Users;
import com.sistemaescolar.repositories.UsersRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	
	
	@Autowired
	private UsersRepository repository; 
	
	 @Override
	    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
	        Users user = repository.findByEmail(email);
	        return new UserDetailsImpl(user);
	    }
	
	
}
