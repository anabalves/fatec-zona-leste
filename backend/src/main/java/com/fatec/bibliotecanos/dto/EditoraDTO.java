package com.fatec.bibliotecanos.dto;

import com.fatec.bibliotecanos.entities.Editora;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class EditoraDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    public EditoraDTO() {}

    public EditoraDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EditoraDTO(Editora entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EditoraDTO)) return false;
        EditoraDTO that = (EditoraDTO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
