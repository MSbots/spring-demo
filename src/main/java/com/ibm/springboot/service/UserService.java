package com.ibm.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.bean.User;
import com.ibm.springboot.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	public void deleteUserById(Integer id) {
		userMapper.deleteUserById(id);
	}


}
