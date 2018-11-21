package com.fatec.spring.boot.model;

public enum EnumPapel {

    ROLE_VISITANTE("ROLE_VISITANTE"), ROLE_USUARIO_COMUM("ROLE_USUARIO_COMUM"), ROLE_ADMINISTRADOR("ROLE_ADMIN"), TESTE("teste");

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
