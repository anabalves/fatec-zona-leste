package com.fatec.bibliotecanos.entities;

import com.fatec.bibliotecanos.entities.enums.ERole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole autorizacao;

    public Role(ERole autorizacao) {
        this.autorizacao = autorizacao;
    }

    public Role() {
    }

    public Role(Long id, ERole autorizacao) {
        this.id = id;
        this.autorizacao = autorizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(ERole autorizacao) {
        this.autorizacao = autorizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
