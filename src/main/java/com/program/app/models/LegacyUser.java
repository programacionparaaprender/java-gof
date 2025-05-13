package com.program.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LegacyUser {
	private String username;
	private String email;
}
