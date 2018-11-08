package com.fatec.spring.boot.model;

public enum EnumPapel {

    VISITANTE("Visitante"), USUARIO_COMUM("Usuario Comum"), ADMINISTRADOR("Administrador"), TESTE("teste");

    private String descricao;

    EnumPapel(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
