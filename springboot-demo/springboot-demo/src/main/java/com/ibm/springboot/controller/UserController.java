package com.ibm.springboot.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.ibm.springboot.bean.User;
import com.ibm.springboot.service.UserService;
import com.ibm.springboot.utils.VerifyCodeUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 增加用户
	 * 
	 * @param user
	 * @return
	 */
//	@PostMapping("/insert")
//	public String insertUser(@RequestBody User user) {
//		userService.insertUser(user);
//		return "插入成功! id="+user.getId();
//	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@PutMapping("/update")
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
//	@GetMapping("/query/{id}")
//	public User getuser(@PathVariable("id") Integer id) {
//		return userService.getUserById(id);
//	}

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteuser(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
		return "delete success!";

	}

	/**
	 * 登录
	 */
	@PutMapping("/login")
	public Map<String, Object> login(@RequestBody User user) {
		Map<String, Object> map = new HashMap<>();

		try {
			User userDB = userService.login(user);
			map.put("state", true);
			map.put("msg", "100");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", false);
			map.put("msg", "提示:" + e.getMessage());
		}
		return map;

	}

	/**
	 * 注册
	 */
	@PostMapping("/register")
	public Map<String, Object> register(@RequestBody User user, String code, HttpServletRequest request) {
//	 log.info("用户信息:[{}]", user.toString());
//		 log.info("用户输入验证码信息：【{}】，code");
		Map<String, Object> map = new HashMap<>();
		try {
//			String key =(String) request.getServletContext().getAttribute("code");
//			if (key.equalsIgnoreCase(code)) {
			userService.register(user);
			map.put("state", true);
			map.put("msg", "注册成功！");

//			} else {
//                throw new RuntimeException("验证码错误");
//			}

		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", false);
			map.put("msg", "提示:" + e.getMessage());
		}
		return map;
	}

	/**
	 * 生成验证码图片
	 */
	@GetMapping("/getImage")
	public String getImageCode(HttpServletRequest request) throws IOException {
		// 1.使用工具类生成验证码
		String code = VerifyCodeUtils.generateVerifyCode(4);
		// 2.将验证码放入servletContext作用域
		request.getServletContext().setAttribute("code", code);
		// 3.将图片转为base64
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		VerifyCodeUtils.outputImage(120, 30, byteArrayOutputStream, code);
		return "data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
	}

	@GetMapping(value = "/userlist")
	public List<User> queryList(Model m, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "2") int size) throws Exception {
		PageHelper.startPage(start, size);
//	         List<User> cs=UserMapper.queryList();
//         PageInfo<User> page = new PageInfo<>(cs);
//         m.addAttribute("page", page);       
//	    	        PageHelper.startPage(1, 2);

		return userService.queryList();

	}
}
