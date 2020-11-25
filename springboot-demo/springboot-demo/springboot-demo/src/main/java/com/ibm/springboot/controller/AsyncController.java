package com.ibm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.service.AsyncService;

@RestController
public class AsyncController {

	@Autowired
	private AsyncService asyncService;

	@GetMapping("/async/hello")
	public String hello() {
		asyncService.hello();
		return "success";
	}
}
