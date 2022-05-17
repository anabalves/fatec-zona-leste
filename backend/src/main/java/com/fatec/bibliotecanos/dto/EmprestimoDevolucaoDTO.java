package com.fatec.bibliotecanos.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.bibliotecanos.entities.EmprestimoDevolucao;
import com.fatec.bibliotecanos.entities.enums.EEmprestimoDevolucao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmprestimoDevolucaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Emprestimo sem usuario não é permitido")
    private Long usuarioId;

    @NotEmpty(message = "Emprestimo sem livro não é permitido")
    private Long livroId;

    @JsonIgnore
    private String situacao;
    private Instant dataDevolucao;
    private Instant dataEmprestimo;

    public EmprestimoDevolucaoDTO(EmprestimoDevolucao entity) {
        this.id = entity.getId();
        this.usuarioId = entity.getUsuario().getId();
        this.livroId = entity.getLivro().getId();
        this.situacao = entity.getSituacao().name();
        this.dataDevolucao = entity.getDataDevolucao();
        this.dataEmprestimo = entity.getDataEmprestimo();
    }

}
