package com.fatec.bibliotecanos.repositories;

import com.fatec.bibliotecanos.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
