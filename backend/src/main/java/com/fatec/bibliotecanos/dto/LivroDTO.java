package com.fatec.bibliotecanos.dto;

import com.fatec.bibliotecanos.entities.Livro;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class LivroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String titulo;
    private String descricao;
    private String autor;
    private Integer edicao;
    private String isbn;
    private Integer quantidade;
    private String imgUrl;
    private Instant anoPublicacao;
    private Long generoId;
    private Long editoraId;

    public LivroDTO() {}

    public LivroDTO(Long id, String titulo, String descricao, String autor, Integer edicao, String isbn, Integer quantidade, String imgUrl, Instant anoPublicacao, Long generoId, Long editoraId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
        this.edicao = edicao;
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.imgUrl = imgUrl;
        this.anoPublicacao = anoPublicacao;
        this.generoId = generoId;
        this.editoraId = editoraId;
    }

    public LivroDTO(Livro entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        descricao = entity.getDescricao();
        autor = entity.getAutor();
        edicao = entity.getEdicao();
        isbn = entity.getIsbn();
        quantidade = entity.getQuantidade();
        imgUrl = entity.getImgUrl();
        anoPublicacao = entity.getAnoPublicacao();
        generoId = entity.getGenero().getId();
        editoraId = entity.getEditora().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Instant getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Instant anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }

    public Long getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(Long editoraId) {
        this.editoraId = editoraId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivroDTO)) return false;
        LivroDTO livroDTO = (LivroDTO) o;
        return Objects.equals(getId(), livroDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
