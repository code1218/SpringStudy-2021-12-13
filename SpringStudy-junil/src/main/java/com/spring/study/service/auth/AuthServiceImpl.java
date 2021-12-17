package com.spring.study.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.domain.user.User;
import com.spring.study.domain.user.UserRepository;
import com.spring.study.web.dto.SignupReqDto;
import com.spring.study.web.dto.SignupRespDto;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public SignupRespDto usernameCheck(SignupReqDto signupReqDto) {
		int idCheckCount = userRepository.idCheck(signupReqDto.getUsername());
		if(idCheckCount == 0) {
			//회원가입 가능한 아이디
			return signupReqDto.toResponseDto(true);
		}else {
			//이미 존재하는 아이디
			return signupReqDto.toResponseDto(false);
		}
	}

	@Override
	public boolean signup(SignupReqDto signupReqDto) {
		User userEntity = signupReqDto.toEntity(); 
		int insertCount = userRepository.insertUser(userEntity);
		if(0 < insertCount) {
			System.out.println("insert 성공");
			return true;
		}else {
			System.out.println("insert 실패");
			return false;
		}
	}
	
}
