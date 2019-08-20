package com.bitcamp.mm.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailSenderService")
public class MailSenderService {
	@Autowired
	private JavaMailSender sender;
	
	public int send(String email) {
		
		MimeMessage message=sender.createMimeMessage();
		
		try {
			message.setSubject("[회원가입을 축하합니다]", "UTF-8");
			String htmlMsg="<h1>회원가입을 축하합니다</h1>";
			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("a20190820252@gmail.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email,"이장님","UTF-8"));
			
			sender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;
	}
	
}
