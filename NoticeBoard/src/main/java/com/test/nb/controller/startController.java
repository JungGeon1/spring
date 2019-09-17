package com.test.nb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class startController {

	@RequestMapping("start")
	public String start() {
		
		return "nBoard/start";
	}
}
