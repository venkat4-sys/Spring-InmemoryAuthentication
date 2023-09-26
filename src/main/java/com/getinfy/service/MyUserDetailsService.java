package com.getinfy.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	
	//if you want to load the userdetails 
	//from the database or somewhere we need to go for this mehtod

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//logic to get user data
		System.out.println("loadUserByUsername() method called.. ");
		
		//here we are manual writing the user name and password
		return new User("venkat", "venkat@123",Collections.emptyList());
	}

}
