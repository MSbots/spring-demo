package com.ibm.springboot.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	private String mailUserName;
	
	/**
	 * 简单邮件发送
	 * @return
	 */
	@GetMapping("/simple/mail/send")
	public String simpleMailSend() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		//邮件设置
		mailMessage.setSubject("通知-今晚开会");
		mailMessage.setText("今晚7:30开会");
		mailMessage.setTo(mailUserName);
		mailMessage.setFrom(mailUserName);
		mailSender.send(mailMessage);
		return "send success";
	}
	
	/**
	 * 复杂邮件发送
	 * @return
	 * @throws MessagingException 
	 */
	@GetMapping("/complex/mail/send")
	public String complexMailSend() throws MessagingException {
		//创建一个复杂的消息邮件
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		//邮件设置
		helper.setSubject("通知-今晚开会");
		helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);
		helper.setTo(mailUserName);
		helper.setFrom(mailUserName);
		//上传文件
		helper.addAttachment("1.jpg",new File("src/main/resources/uploadFile/1.jpg"));
		helper.addAttachment("2.jpg",new File("src/main/resources/uploadFile/2.jpg"));
		mailSender.send(mimeMessage);
		return "send success";
	}
}