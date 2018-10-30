package com.fatec.spring.boot.security;

import com.fatec.spring.boot.repository.Criptografia;

public class Login {

    private String username;
    private String password;

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Criptografia.criptografar(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
