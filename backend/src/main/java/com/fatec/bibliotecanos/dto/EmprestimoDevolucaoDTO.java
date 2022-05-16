package com.fatec.bibliotecanos.dto;

import com.fatec.bibliotecanos.entities.EmprestimoDevolucao;
import com.fatec.bibliotecanos.entities.enums.EEmprestimoDevolucao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmprestimoDevolucaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private EEmprestimoDevolucao situacao;

    @NotBlank(message = "Campo obrigatório")
    private Instant dataEmprestimo;
    private Instant dataDevoliucao;

    public EmprestimoDevolucaoDTO(EmprestimoDevolucao entity) {
        this.id = entity.getId();
        this.situacao = entity.getSituacao();
        this.dataEmprestimo = entity.getDataEmprestimo();
        this.dataDevoliucao = entity.getDataDevoliucao();
    }

}
