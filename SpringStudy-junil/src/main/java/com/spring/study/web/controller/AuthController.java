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
		if(signupReqDto.getSubmitFlag() == 1) {
			// 아이디 중복확인.(select)
			
		}else {
			// 회원가입 진행(insert)
			
		}
		return "auth/signin";
	}
	
}
