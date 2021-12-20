package com.spring.study.web.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.study.service.auth.AuthService;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Model model, SignupReqDto signupReqDto) {
		if(signupReqDto.getSubmitFlag() == 1) {
			// 아이디 중복확인.(select)
			SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);
			
			model.addAttribute("signupRespDto", signupRespDto);
			return "auth/signup";
			
		}else {
			// 회원가입 진행(insert)
			boolean signupSuccessFlag = authService.signup(signupReqDto);
			if(signupSuccessFlag == true) {
				return "redirect:/signin";
			}else {
				return "auth/signup";
			}
		}
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(Model model, SigninReqDto signinReqDto) {
		SigninRespDto<Map<Integer, String>> signinRespDto = authService.signin(signinReqDto);
		Set keySet = signinRespDto.getData().keySet();
		Iterator<Integer> iterator = keySet.iterator();
		
		String view = null;
		
		while(iterator.hasNext()) {
			int key = iterator.next();
			if(key == 0 || key == 1) {
				//오류 페이지
				model.addAttribute("signinRespDto", signinRespDto);
				view = "auth/signin";
			}else {
				//성공 페이지
				view = "redirect:/index";
			}
		}
		
		return view;
	}
	
}






