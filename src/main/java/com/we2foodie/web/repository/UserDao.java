package com.we2foodie.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.we2foodie.web.model.User;

@Repository
public class UserDao {
	
	@Autowired
	UserDataRepository jparepository;

	public User addUser(User user) 
	{
	return	 jparepository.save(user);
	 
}
}
 