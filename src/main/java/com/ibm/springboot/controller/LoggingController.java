package com.ibm.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

	private Logger logger = LoggerFactory.getLogger(LoggingController.class);
	
	@GetMapping("/logging/test")
	public String loggingTest() {
		// 日志的级别；
		// 由低到高 trace<debug<info<warn<error
		// 可以调整输出的日志级别；日志就只会在这个级别和以后的高级别生效
		logger.trace("这是trace日志...");
		logger.debug("这是debug日志...");
		// SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别：root级别
		logger.info("这是info日志...");
		logger.warn("这是warn日志...");
		logger.error("这是error日志...");
		return "success";
	}

}
