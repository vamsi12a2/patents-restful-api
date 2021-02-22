package com.springpro.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springpro.rest.dao.User;
import com.springpro.rest.dao.UserRepository;
import com.springpro.rest.models.PatentUserDetailsModel;

public class PatentUserDetailsService implements UserDetailsService {
	
	@Autowired 
	UserRepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userrepository.findByUsername(username);
		userOptional.orElseThrow(() ->  new UsernameNotFoundException("User with username "+username+" not found"));
		return new PatentUserDetailsModel(userOptional.get());
	}

}
