package com.spring.study.domain.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<User> getUsers() {
		return null;
	}
}
