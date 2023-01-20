package com.we2foodie.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.we2foodie.web.model.User;

public interface UserDataRepository extends JpaRepository<User, Integer> {

	public User findByName(String username);

	public User findByEmail(String username);

}
