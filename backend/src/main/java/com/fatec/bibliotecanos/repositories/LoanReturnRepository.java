package com.fatec.bibliotecanos.repositories;

import com.fatec.bibliotecanos.entities.LoanReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanReturnRepository extends JpaRepository<LoanReturn, Long> {

}
