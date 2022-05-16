package com.fatec.bibliotecanos.repositories;

import com.fatec.bibliotecanos.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    Genero findByNome(String nome);

}
