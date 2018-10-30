package com.fatec.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.repository.Criptografia;
import com.fatec.spring.boot.view.View;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr_usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    @JsonView({View.UsuarioFull.class, View.imagemFull.class})
    private long id;

    @Column(name = "usr_nome", length = 50, nullable = false)
    @JsonView({View.UsuarioSimples.class, View.imagemFull.class})
    private String nome;

    @Column(name = "usr_senha", length = 250, nullable = false)
    private String senha;

    @Column(name = "usr_usuario", unique = true, nullable = false, length = 25)
    @JsonView({View.UsuarioSimples.class, View.imagemFull.class})
    private String usuario;

    @Column(name = "usr_email", unique = true, nullable = false, length = 50)
    @JsonView({View.UsuarioSimples.class, View.imagemFull.class})
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
        senha = Criptografia.criptografar(senha);
        //System.out.println(Criptografia.criptografar("123"));
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
        return String.format("Objeto Usuario - ID: %d / Nome: %s / Email: %s / usr: %s", id, nome, email,
                usuario);
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Papel> autorization = new LinkedList<>();
        autorization.add(this.papel);
        return autorization;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return senha;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return nome;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }


}
