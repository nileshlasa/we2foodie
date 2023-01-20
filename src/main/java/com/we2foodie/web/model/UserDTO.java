package com.we2foodie.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	public int id;
	public String name;
	public String mobile;
	public String email;
	public String password;
	public String role="ROLE_NORMAL";
	public String address;

}
