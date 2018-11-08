package com.fatec.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.view.View;

public class Token{

	@JsonView({View.Token.class})
	private String token;

	@JsonView({View.Token.class})
	private long expirate;

	public Token(String token, long expirate){
		this.token = token;
		this.expirate = expirate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}