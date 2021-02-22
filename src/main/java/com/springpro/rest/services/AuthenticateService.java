package com.springpro.rest.services;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.springpro.rest.models.AuthenticationBodyModel;

@Service
public class AuthenticateService {
	
	@Autowired
	AuthenticationManager authManager;
	
	public boolean authenticate(AuthenticationBodyModel authBody) {
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(authBody.getusername(),authBody.getPassword()));
		SecurityContext sc = SecurityContextHolder.getContext();
	    sc.setAuthentication(auth);
	    return true;
	}
}
