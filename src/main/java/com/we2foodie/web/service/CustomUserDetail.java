package com.we2foodie.web.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.we2foodie.web.model.User;

@Service
public class CustomUserDetail implements UserDetails  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	

	
	public CustomUserDetail() {
		
	}

	public CustomUserDetail(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		HashSet<SimpleGrantedAuthority> set=new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.user.getRole()));
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		 return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
