package com.fatec.bibliotecanos.repositories;

import com.fatec.bibliotecanos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);
    Optional<Usuario> findByEmail(String email);
    Boolean existsByCpf(String cpf);
    Boolean existsByEmail(String email);

}
