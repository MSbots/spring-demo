package com.ibm.springboot;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;


//@EnableAsync //开启异步注解功能
//@EnableScheduling //开启基于注解的定时任务
@MapperScan(value = "com.ibm.springboot.mapper")
@SpringBootApplication
@Configuration
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
