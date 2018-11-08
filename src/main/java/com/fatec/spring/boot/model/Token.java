package com.fatec.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.view.View;

public class Token{

	@JsonView({View.Token.class})
	private String token;

	@JsonView({View.Token.class})
	private long expirate;

	@JsonView({View.Token.class})
	private Usuario usuario;

	public Token(Usuario usuario, String token, long expirate){
		this.usuario = usuario;
		this.token = token;
		this.expirate = expirate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpirate() {
		return expirate;
	}

	public void setExpirate(long expirate) {
		this.expirate = expirate;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}