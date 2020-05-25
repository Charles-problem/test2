package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jt.entity.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@RequestMapping("/hello")
	public User getUser() throws Exception {
		User user = null;
		User forObject = restTemplate.getForObject("http://localhost:8080/user/hello", User.class);
		System.out.println(forObject);
		return forObject;
	
	}
	

}
