package com.fatec.bibliotecanos.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_editora")
public class Editora implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "editora")
    private List<Livro> livros = new ArrayList<>();

    public Editora() {}

    public Editora(Long id, String nome, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Editora)) return false;
        Editora editora = (Editora) o;
        return Objects.equals(getId(), editora.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}