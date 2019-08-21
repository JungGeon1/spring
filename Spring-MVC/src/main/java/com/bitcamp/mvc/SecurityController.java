package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SecurityController {
	@Autowired
	private AES256Util asUtil;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@ResponseBody
	@RequestMapping("/encodepassword")
	public String brypt() {
		
		String str="password";
		
		String encodingstr=encoder.encode(str);
		
		boolean result = encoder.matches(str, encodingstr);
		
		return str+":"+ encodingstr+"<br>"
				+"str==>"+result;
	}
	@RequestMapping("/encodedPw02")
	   @ResponseBody
	   public String bcript02() {
	      //최초 회원가입시 사용자 입력 비번 
	      String randomPw = "password123";
	      
	      //DB 에 저장된 비번 
	      String encodedPw = Sha256.encrypt(randomPw); 
	      
	      //사용자가 새로 입력한 비번 
	      String pw = "256";
	      
	      //boolean result = encodedPw.equals(Sha256.encrypt(pw));
	      boolean result = encodedPw.equals(Sha256.encrypt(randomPw));
	      
	      return "Original Password:  "+randomPw + " /// Encoded Password using Sha256: "+encodedPw
	            + "   /// Are they equal?  "+ result;
	      
	   }
	   @RequestMapping("/encodedPw03")
	   @ResponseBody
	   public String bcript03() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
	      //최초 회원가입시 사용자 입력 비번 
	      String str= "password123";
	      
	      String encodedStr =asUtil.encrypt(str);
	      String decodeStr = asUtil.decrypt(encodedStr);
	      
	      
	      return str+":"+encodedStr+":"+decodeStr;
	          
	      
	   }
}
