package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.mail.handlers.message_rfc822;

@Controller
public class MailSendController {

	@Autowired
	MailSender sender;
	@Autowired
	JavaMailSender javaMailSender;

	@RequestMapping("/mail/send")
	public String sendMail() {
		// 메일 내용설정

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("gun2656@naver.com");
		message.setSubject("헤");
		message.setText("푸헤헤헤헿헤헤ㅔ헿헤헤내용푸해헤헤헤");
		message.setFrom("a20190820252@gmail.com");

		//SimpleMailMessage m = new SimpleMailMessage(message);

		sender.send(message);
		return "send OK";
	}

	@RequestMapping("/mail/send1")
	@ResponseBody
	public String sendJavaMailSender() {

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			// 제목
			message.setSubject("안녕하세다시만나요", "UTF-8");
			// html내용
			String htmlstr = "<h1 style=\"color:red\">힘들었던 하루~</h1><br><h1>그런데 왜 안가지는걸까요</h1>"
					+ "<a href = \"https://www.naver.com/ \">naver</a>";
			// 내용설정
			message.setText(htmlstr, "UTF-8", "html");
			// to설정
			message.addRecipient(RecipientType.TO, new InternetAddress("gun2656@naver.com", "이장님", "UTF-8"));

			javaMailSender.send(message);
		} catch (MessagingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "send ok";
	}

	@ResponseBody
	@RequestMapping("/mail/send2")
	public String sendFileAttach() {

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			// 제목
			messageHelper.setSubject("[안내]--->파일첨부");
			// 내용 html
			String htmlstr = "<h1 style=\"color:red\">파일첨부</h1>" + "<p>이 편지는 영구에서 부터 시작되어 당신의 쪼로록</p>";
			// 내용 설정
			messageHelper.setText(htmlstr, true);
			// To설정
			messageHelper.setTo(new InternetAddress("gun2656@naver.com", "이장님", "UTF-8"));
			// 첨부할 파일 객체 성
			DataSource dataSource = new FileDataSource("C:\\Users\\JungGeon\\Documents\\01_HTML5_20180817.pdf");
			// MimemessageHelper 파일 객체 추가
			messageHelper.addAttachment(MimeUtility.encodeText("01_HTML5_20180817.pdf", "UTF-8", "B"), dataSource);

			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "send ok";
	}
	@RequestMapping("/mail/send3")
	@ResponseBody
	public String mailTest() {
		
		MimeMessage messgae =  javaMailSender.createMimeMessage();  
		 
		try {
			messgae.setSubject("이것은 테스트 입니다", "utf-8");
			String htmlstr = "<h1 style=\"color:red\">힘들었던 하루~</h1><br><h1>그런데 왜 안가지는걸까요</h1>";
			messgae.setText(htmlstr, "utf-8", "html");
			

			messgae.addRecipient(RecipientType.TO, new InternetAddress("gun2656@naver.com","이장님","UTf-8"));
			
			javaMailSender.send(messgae);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "성공";
		
	}
}
