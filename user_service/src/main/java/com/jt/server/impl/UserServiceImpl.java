package com.jt.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jt.entity.User;
import com.jt.server.UserServer;
import com.jt.util.JsonUtil;

@Service
public class UserServiceImpl implements UserServer{

	@Value("${sp.user-service.users}")
	private String userJson;
	
	@Override
	public User getUser(Integer id) {
		List<User> list = JsonUtil.from(userJson, new TypeReference<List<User>>() {});
		for (User u : list) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		
		return new User(id, "name-"+id, "pwd-"+id);

	}


	

}
