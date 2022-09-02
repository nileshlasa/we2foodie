package com.we2foodie.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.we2foodie.web.model.User;
import com.we2foodie.web.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao userdao;

	public User addUser(User user) {
	return 	userdao.addUser(user);
	 
	}

}
