package com.fatec.bibliotecanos.repositories;

import com.fatec.bibliotecanos.entities.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

    Editora findByNome(String nome);

}
