package com.spring.study.service.auth;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.study.domain.user.UserRepository;

public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean usernameCheck(String username) {
		
	}
	
}