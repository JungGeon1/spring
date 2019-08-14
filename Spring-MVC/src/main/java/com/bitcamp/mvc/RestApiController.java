package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mvc.domain.Login;

@RestController
public class RestApiController {

	// @GetMapping(value = "/restapi/hello")->메소드방식이 겟으로 정의되어 있음
	@RequestMapping(name = "/restapi/hello", method = RequestMethod.GET)
	public String hello() {

		return "hello";
	}

	@RequestMapping("/restapi/loginList")
	public List<Login> loginList() {

		List<Login> list = new ArrayList<Login>();

		Login login = new Login();
		login.setuId("cool");
		login.setuPw("123456");

		list.add(login);

		login = new Login();
		login.setuId("HOT");
		login.setuPw("Password");

		list.add(login);

		return list;
	}

	@RequestMapping("/restapi/loginMap")
	public Map<String, Login> loginMap() {

		Map<String, Login> maps = new HashMap<String, Login>();

		Login login = new Login();
		login.setuId("cool");
		login.setuPw("123456");

		maps.put("1", login);

		login = new Login();
		login.setuId("HOT");
		login.setuPw("Password");

		maps.put("2", login);

		return maps;
	}

}