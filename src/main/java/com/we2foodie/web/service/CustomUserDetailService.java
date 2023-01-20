package com.we2foodie.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.we2foodie.web.model.User;
import com.we2foodie.web.repository.UserDataRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserDataRepository userDataRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= this.userDataRepository.findByEmail(username);
		if(user==null) throw new UsernameNotFoundException("No User");
		return new CustomUserDetail(user);
	}

}
