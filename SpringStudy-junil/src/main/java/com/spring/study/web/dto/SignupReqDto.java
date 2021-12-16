package com.spring.study.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

@Getter
@Setter
public class SignupReqDto {
	private String username;
	private String password;
	private String name;
	private String email;
}
