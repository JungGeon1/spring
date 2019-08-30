package com.bitcamp.abandonedDog.controller;

import java.net.URL;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.cglib.core.internal.CustomizerRegistry;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.bitcamp.abandonedDog.domain.DogListDto;
import com.bitcamp.abandonedDog.domain.DogResponse;

import com.bitcamp.abandonedDog.domain.Item;
import com.sun.org.apache.xml.internal.utils.URI;
import com.sun.org.apache.xml.internal.utils.URI.MalformedURIException;


@Controller
public class DogController {
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping("/dogList")
	public List<Item> dogList() {

		String url= "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20140301&endde=20140430&pageNo=1&numOfRows=10&upkind=417000&ServiceKey="+"w6tghMtfkPZl5OXy9wZ9CkT5WTgS0LAnwimWMdM2Bdqma5ru5Zf6vRLWPxELbS6A%2FZEU4mr333w4PAaHsdixGQ%3D%3D";
		
		RestTemplate restTemplate = new RestTemplate();
		//URI uri = new URI("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20140301&endde=20140430&pageNo=1&numOfRows=10&upkind=417000&ServiceKey=w6tghMtfkPZl5OXy9wZ9CkT5WTgS0LAnwimWMdM2Bdqma5ru5Zf6vRLWPxELbS6A%2FZEU4mr333w4PAaHsdixGQ%3D%3D");
		DogResponse response = restTemplate.getForObject(url, DogResponse.class);

		System.out.println(response.getBody());
		
		
		
//		for(Item d : response.getBody().getDogItem()) {
//			
//			System.out.println(d);
//			
//		}
		
		List<Item> item=response.getBody().getDogItem();

		

		return null;
	}
}
