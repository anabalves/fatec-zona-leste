package com.fatec.bibliotecanos.repositories;

import com.fatec.bibliotecanos.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Long> {

}
