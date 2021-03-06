package com.ibm.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.ibm.springboot.bean.User;
import com.ibm.springboot.mapper.UserMapper;
@Transactional
@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	
	public void register(User user) {
		User userDB = userMapper.findByUserName(user.getUserName());
		if (userDB==null) {
			userMapper.insertUser(user);
		} else {
            throw new RuntimeException("用户名已存在");
		}
		
	}


   public User login(User user) {
	   User userDB = userMapper.findByUserName(user.getUserName());
	   if(!ObjectUtils.isEmpty(userDB)) {
		   if(userDB.getPassword().equals(user.getPassword())) {
			    return userDB;
		   }else {
			throw new RuntimeException("密码不正确");
			}
		}else {
			throw new RuntimeException("用户名不正确");
		}		   	   
   }  

}
