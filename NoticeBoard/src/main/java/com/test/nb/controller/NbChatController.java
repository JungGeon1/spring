package com.test.nb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "chat")
public class NbChatController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String chatForm() {
		
		
		return "/nBoard/chat/chatForm";
	}
}
