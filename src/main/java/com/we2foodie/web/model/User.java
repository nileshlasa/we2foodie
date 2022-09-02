package com.we2foodie.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id=0;
	public String name;
	public String mobile;
	public String email;
	public String password;
	public char role='2';
	public String address;
	

}
