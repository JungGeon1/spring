package com.bitcamp.guest.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.guest.service.DeleteMessageSrvice;
import com.bitcamp.guest.service.InvalidMessagePasswordException;
import com.bitcamp.guest.service.MessageNotFoundException;



@Controller
@RequestMapping("/guest/delete")
public class GuestDeleteController {
	@Autowired
	private DeleteMessageSrvice messageService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String deleteForm(@RequestParam(value = "messageId")String mId,Model model) {
		
		model.addAttribute("messageId", mId);
		return"guest/deleteForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String delete(@RequestParam(value = "messageId")int messageId,
						@RequestParam(value = "password")String password,
						Model model
			) {
						
		
			boolean chk = false;
			int resultCnt = 0;
			String msg = "";
			
			try {
				resultCnt = messageService.deleteMessage(messageId, password);
				chk = true;	
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					msg = e.getMessage();
				
					
				} catch (MessageNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					msg = e.getMessage();
				
				} catch (InvalidMessagePasswordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					msg = e.getMessage();
				
				}
		
				model.addAttribute("chk", chk);
				model.addAttribute("resultCnt", resultCnt);
				model.addAttribute("msg", msg);
				
				return "guest/delete";
	}
}
