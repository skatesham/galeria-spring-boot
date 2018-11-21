package com.fatec.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.view.View;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "pap_papel")
public class Papel implements GrantedAuthority {

    private static final long serialVersionUID = 3078636239920155012L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pap_id")
    @JsonView({View.UsuarioFull.class, View.Token.class})
    private long id;

    @Column(name = "pap_descricao", unique = true, length = 50, nullable = false)
    @JsonView({View.UsuarioFull.class, View.Token.class})
    private String descricao;

    public Papel() {
    }

    public Papel(EnumPapel descricao) {
        this.descricao = descricao.getDescricao();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        String str = String.format("Objeto Papel - ID: %d / Desc: %s", id, descricao);
        return str;
    }

    @Override
    public String getAuthority() {
        return this.descricao;
    }

    public void setAuthority(String authority) {
        this.descricao = authority;
    }


}
