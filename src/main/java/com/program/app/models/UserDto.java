package com.program.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
	private String username;
	private String email;
	
	@Override
	public String toString() {
		return "username: " + username + ", email: " + email;
	}
}
