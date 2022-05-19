package com.fatec.bibliotecanos.dto;

import com.fatec.bibliotecanos.entities.EmprestimoDevolucao;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class EmprestimoDevolucaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Emprestimo sem usuario não é permitido")
    private Long usuarioId;

    @NotEmpty(message = "Emprestimo sem livro não é permitido")
    private Long livroId;

    private String situacao;
    private Instant dataDevolucao;
    private Instant dataEmprestimo;

    public EmprestimoDevolucaoDTO() {}

    public EmprestimoDevolucaoDTO(Long id, Long usuarioId, Long livroId, String situacao, Instant dataDevolucao, Instant dataEmprestimo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.livroId = livroId;
        this.situacao = situacao;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
    }

    public EmprestimoDevolucaoDTO(EmprestimoDevolucao entity) {
        this.id = entity.getId();
        this.usuarioId = entity.getUsuario().getId();
        this.livroId = entity.getLivro().getId();
        this.situacao = entity.getSituacao().name();
        this.dataDevolucao = entity.getDataDevolucao();
        this.dataEmprestimo = entity.getDataEmprestimo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Instant getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Instant dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Instant getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Instant dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmprestimoDevolucaoDTO)) return false;
        EmprestimoDevolucaoDTO that = (EmprestimoDevolucaoDTO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
