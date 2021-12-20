package com.spring.study.web.dto.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SigninRespDto<T> {
	private String username;
	private String password;
	
	private T data;
}
