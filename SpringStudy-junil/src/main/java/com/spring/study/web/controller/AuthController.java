package com.spring.study.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.domain.user.User;
import com.spring.study.service.auth.AuthService;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto;
import com.spring.study.web.dto.authAjax.SignupReqAjaxDto;
import com.spring.study.web.handler.Message;

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
	public String signin(Model model, HttpServletRequest request, SigninReqDto signinReqDto) {
		
		SigninRespDto signinRespDto = authService.signin(signinReqDto);
		
		if(signinRespDto.getSigninFlag() == 2) {
			// 로그인 성공.
			HttpSession session = request.getSession();
			User loginUser = authService.getUserByUsername(signinRespDto.getUsername());
			session.setAttribute("principal", loginUser);
			return "redirect:/index";
		}
		
		model.addAttribute("signinRespDto", signinRespDto);
		
		return "auth/signin";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signup/username-check", method = RequestMethod.GET)
	public String signupAjax(SignupReqAjaxDto signupReqAjaxDto) {
		System.out.println(signupReqAjaxDto);
		return "요청옴.";
	}
	
}






