package com.fatec.bibliotecanos.dto;

import com.fatec.bibliotecanos.entities.Role;

import java.io.Serializable;
import java.util.Objects;

public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String autorizacao;

    public RoleDTO() {}

    public RoleDTO(Long id, String autorizacao) {
        this.id = id;
        this.autorizacao = autorizacao;
    }

    public RoleDTO(Role role) {
        super();
        id = role.getId();
        autorizacao = role.getAutorizacao().name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(String autorizacao) {
        this.autorizacao = autorizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDTO)) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return Objects.equals(getId(), roleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
