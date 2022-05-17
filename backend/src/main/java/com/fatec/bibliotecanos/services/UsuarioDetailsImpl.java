package com.fatec.bibliotecanos.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.bibliotecanos.entities.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioDetailsImpl implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private String email;
    private String emailAlternativo;
    private String cep;
    private String endereco;
    private String numeroEndereco;
    private String complemento;
    private String cidade;
    private String estado;

    @JsonIgnore
    private String senha;

    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioDetailsImpl(Long id, String nome, String sobrenome, String cpf, String telefone, String email, String emailAlternativo, String cep, String endereco, String numeroEndereco, String complemento, String cidade, String estado, String senha, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.emailAlternativo = emailAlternativo;
        this.cep = cep;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.senha = senha;
        this.authorities = authorities;
    }

    public static UsuarioDetailsImpl build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAutorizacao().name()))
                .collect(Collectors.toList());

        return new UsuarioDetailsImpl(
            usuario.getId(),
            usuario.getNome(),
            usuario.getSobrenome(),
            usuario.getCpf(),
            usuario.getTelefone(),
            usuario.getEmail(),
            usuario.getEmailAlternativo(),
            usuario.getCep(),
            usuario.getEndereco(),
            usuario.getNumeroEndereco(),
            usuario.getComplemento(),
            usuario.getCidade(),
            usuario.getEstado(),
            usuario.getSenha(),
            authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsuarioDetailsImpl usuarioDetails = (UsuarioDetailsImpl) o;
        return Objects.equals(id, usuarioDetails.id);
    }

}