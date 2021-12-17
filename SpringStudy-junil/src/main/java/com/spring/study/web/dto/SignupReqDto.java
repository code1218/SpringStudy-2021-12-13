package com.spring.study.web.dto;

import lombok.Data;

@Data
public class SignupReqDto {
	private String username;
	private String password;
	private String name;
	private String email;
	
	private int submitFlag;
	
	public SignupRespDto toResponseDto(boolean idCheckFlag) {
		return SignupRespDto.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.idCheckFlag(idCheckFlag)
				.build();
				
	}
}
