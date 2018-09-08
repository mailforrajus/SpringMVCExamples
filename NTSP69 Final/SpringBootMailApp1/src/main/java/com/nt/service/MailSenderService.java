package com.nt.service;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailSenderService {
	@Autowired
	private JavaMailSender sender;
	
	public void sendEmailMessage() throws Exception{
		MimeMessage  message=null;
		MimeMessageHelper helper=null;
		message=sender.createMimeMessage();
		helper=new MimeMessageHelper(message);
		helper.setTo("nataraz@gmail.com");
		helper.setSentDate(new Date());
		helper.setSubject("Open it to feel it");
		helper.setText("The mail to All the Students of Ntsp69 Batch, U have"
				+ "Great students So far, I love u all ,All the best my dear wrost fellows" );
		sender.send(message);
	}

}
