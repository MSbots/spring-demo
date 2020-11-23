package com.ibm.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("hello")
	public String helloWord() {
		return "hello world";
	}
}
