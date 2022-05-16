package com.fatec.bibliotecanos.repositories;

import com.fatec.bibliotecanos.entities.EmprestimoDevolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoDevolucaoRepository extends JpaRepository<EmprestimoDevolucao, Long> {

}
