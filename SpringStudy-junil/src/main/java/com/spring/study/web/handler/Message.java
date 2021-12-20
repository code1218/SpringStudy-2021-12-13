package com.spring.study.web.handler;

import com.spring.study.domain.user.User;

import lombok.Data;

@Data
public class Message<T> {
	private int code;
	private T data;
}
