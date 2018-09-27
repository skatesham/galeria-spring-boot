package com.fatec.spring.boot.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.view.View;

@Entity
@Table(name = "usr_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	@JsonView({View.UsuarioSimples.class, View.UsuarioFull.class})
	private long id;

	@Column(name = "usr_nome", length = 50, nullable = false)
	@JsonView({View.UsuarioSimples.class, View.UsuarioFull.class})
	private String nome;

	@Column(name = "usr_senha", length = 250, nullable = false)
	@JsonView({View.UsuarioSimples.class, View.UsuarioFull.class})
	private String senha;

	@Column(name = "usr_usuario", unique = true, nullable = false, length = 25)
	@JsonView({View.UsuarioSimples.class, View.UsuarioFull.class})
	private String usuario;

	@Column(name = "usr_email", unique = true, nullable = false, length = 50)
	@JsonView({View.UsuarioSimples.class, View.UsuarioFull.class})
	private String email;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id_papel")
	@JsonView({View.UsuarioFull.class})
	private Papel papel;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	@JsonView({View.UsuarioFull.class})
	private Set<Imagem> imagens;

	public Usuario() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	@Override
	public String toString() {
		String str = String.format("Objeto Usuario - ID: %d / Nome: %s / Email: %s / usr: %s", id, nome, email, usuario);
		return str;
	}
	
	

}
