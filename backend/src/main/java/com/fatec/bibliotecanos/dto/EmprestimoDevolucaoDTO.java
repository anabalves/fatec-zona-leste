package com.fatec.bibliotecanos.dto;

import com.fatec.bibliotecanos.entities.EmprestimoDevolucao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

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

    private String situacao;
    private LocalDate dataDevolucao;
    private LocalDate dataEmprestimo;

    public EmprestimoDevolucaoDTO(EmprestimoDevolucao entity) {
        this.id = entity.getId();
        this.usuarioId = entity.getUsuario().getId();
        this.livroId = entity.getLivro().getId();
        this.situacao = entity.getSituacao().name();
        this.dataDevolucao = entity.getDataDevolucao();
        this.dataEmprestimo = entity.getDataEmprestimo();
    }

}
