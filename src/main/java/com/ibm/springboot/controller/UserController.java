package com.ibm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.bean.User;
import com.ibm.springboot.service.UserService;
@RestController

public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 增加用户
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/user/insert")
	public String insertUser(@RequestBody User user) {
		userService.insertUser(user);
		return "插入成功! id="+user.getId();
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@PutMapping("/user/update")
	public String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return "update success!";
	}

	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/user/query/{id}")
	public User getuser(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/user/delete/{id}")
	public String deleteuser(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
		return "delete success!";
	}
	
	

}
