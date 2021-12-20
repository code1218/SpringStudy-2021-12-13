package com.spring.study.service.auth;

import java.util.Map;

import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto;

public interface AuthService {
	//signup
	public SignupRespDto usernameCheck(SignupReqDto signupReqDto);
	public boolean signup(SignupReqDto signupReqDto);
	
	//signin
	public SigninRespDto<Map<Integer, String>> signin(SigninReqDto signinReqDto);
}
