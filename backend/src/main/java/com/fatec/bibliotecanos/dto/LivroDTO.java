package com.fatec.bibliotecanos.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.bibliotecanos.entities.Livro;
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

    public LivroDTO(Livro entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
        this.autor = entity.getAutor();
        this.edicao = entity.getEdicao();
        this.isbn = entity.getIsbn();
        this.quantidade = entity.getQuantidade();
        this.imgUrl = entity.getImgUrl();
        this.anoPublicacao = entity.getAnoPublicacao();
        this.generoId = entity.getGenero().getId();
        this.editoraId = entity.getEditora().getId();
    }

}
