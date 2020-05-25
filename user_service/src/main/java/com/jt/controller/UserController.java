package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.entity.User;
import com.jt.server.UserServer;
import com.jt.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@RestController

@Slf4j
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserServer userService;
	//http://localhost:8101/7
	@GetMapping("/hello")
	public JsonResult<User> getUser(Integer userId) throws Exception {
		 userId = 7;
		log.info("get user, userId="+userId);
		User u = userService.getUser(userId);
		return JsonResult.ok(u);
	}

}
