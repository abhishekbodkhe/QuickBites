package com.app.project.main.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResp {
	private String message;
	private String jwtToken;

	public AuthResp(String message, String jwtToken) {
		this.message = message;
		this.jwtToken = jwtToken;
	}

	// Getters and Setters
}
