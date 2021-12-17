package com.spring.study.service.auth;

import com.spring.study.web.dto.SignupReqDto;
import com.spring.study.web.dto.SignupRespDto;

public interface AuthService {
	
	public SignupRespDto usernameCheck(SignupReqDto signupReqDto);
	public boolean signup(SignupReqDto signupReqDto);
	
}
