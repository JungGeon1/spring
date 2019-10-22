package com.test.nb.service;

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

//	public int send(String email) {
//		
//		MimeMessage message=sender.createMimeMessage();
//		
//		try {
//			message.setSubject("[회원가입을 축하합니다]", "UTF-8");
//			String htmlMsg="<h1>회원가입을 축하합니다</h1>";
//			message.setText(htmlMsg, "UTF-8", "html");
//			message.setFrom(new InternetAddress("a20190820252@gmail.com"));
//			message.addRecipient(RecipientType.TO, new InternetAddress(email,"이장님","UTF-8"));
//			
//			sender.send(message);
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return 1;
//	}

	// 인증 메일 전송
	public void send(String getuId, String code) {

		MimeMessage message = sender.createMimeMessage();
		try {
			message.setSubject("[회원가입을 축하합니다]", "UTF-8");
			String htmlMsg = "<h1>회원가입을 축하합니다</h1>";

			htmlMsg += "<h3>인증을 위해 아래 링크를 클랙해주세요.</h3>";
			htmlMsg += "<h3><a href=\"http://localhost:8080/nb/verify?id=" + getuId + "&code=" + code + "\" >인증하기("
					+ getuId + ")</a></h3>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("a20190820252@gmail.com", "M_click_dummy", "UTF-8"));
			message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "고객님", "UTF-8"));

			sender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 인증메일 재전송
	public void reSend(String getuId, String code) {

		MimeMessage message = sender.createMimeMessage();

		try {

			message.setSubject("[재인증안내] 이메일 인증을 해주세요.", "UTF-8");
			String htmlMsg = "<h1>이메일 인증을 해주세요.</h1>";

			htmlMsg += "<h3>인증을 위해 아래 링크를 클랙해주세요.</h3>";
			htmlMsg += "<h3><a href=\"http://localhost:8080/nb/verify?id=" + getuId + "&code=" + code + "\" >재인증하기("
					+ getuId + ")</a></h3>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("a20190820252@gmail.com", "M_click_dummy", "UTF-8"));
			message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "고객님", "UTF-8"));

			sender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//인증 메일 전송
	public void findPwChksend(String getuId, String code) {

		MimeMessage message = sender.createMimeMessage();
		try {
			message.setSubject("[임시 비밀번호 발급]", "UTF-8");
			String htmlMsg = "<h1>임시 비밀번호 발급 서비스 입니다.</h1>";

			htmlMsg += "<h3>임시 비밀번호가 발급되었습니다.</h3>";
			htmlMsg += "<h3>임시비밀번호:" + code + "</h3>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("a20190820252@gmail.com", "M_click_dummy", "UTF-8"));
			message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "고객님", "UTF-8"));

			sender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findAdminPwChksend(String admin_email, String tempPassword) {
		MimeMessage message = sender.createMimeMessage();
		try {
			message.setSubject("[관리자 임시 비밀번호 발급]", "UTF-8");
			String htmlMsg="<h1>임시 비밀번호 발급 서비스 입니다.</h1>";

			htmlMsg += "<h3>임시 비밀번호가 발급되었습니다.</h3>";
			htmlMsg += "<h3>임시비밀번호:"+tempPassword+"</h3>";
			
			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("a20190820252@gmail.com","M_click_dummy","UTF-8"));
			message.addRecipient(RecipientType.TO, new InternetAddress(admin_email,"관리자님","UTF-8"));
			
			sender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
