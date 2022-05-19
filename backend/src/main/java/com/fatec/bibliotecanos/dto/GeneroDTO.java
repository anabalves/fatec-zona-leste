package com.fatec.bibliotecanos.dto;

import com.fatec.bibliotecanos.entities.Genero;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class GeneroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    public GeneroDTO() {}

    public GeneroDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public GeneroDTO(Genero entity) {
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
        if (!(o instanceof GeneroDTO)) return false;
        GeneroDTO generoDTO = (GeneroDTO) o;
        return Objects.equals(getId(), generoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
