package com.spring.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.study.web.dto.SignupReqDto;

@Controller
public class AuthController {
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(SignupReqDto signupReqDto) {
		System.out.println("요청됨?");
		System.out.println(signupReqDto);
		signupReqDto.getUsername();
		return "auth/signin";
	}
	
	@RequestMapping(value = "/signup2", method = RequestMethod.GET)
	public String signup2(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("요청됨?");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		return null;
	}
}
