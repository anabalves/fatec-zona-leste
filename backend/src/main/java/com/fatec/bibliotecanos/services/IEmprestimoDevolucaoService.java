package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.EmprestimoDevolucaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmprestimoDevolucaoService {

    Page<EmprestimoDevolucaoDTO> findAllPaged(Pageable pageable);
    EmprestimoDevolucaoDTO findById(Long id);
    EmprestimoDevolucaoDTO insert(EmprestimoDevolucaoDTO dto);
    EmprestimoDevolucaoDTO update(Long id, EmprestimoDevolucaoDTO dto);
    void delete(Long id);

}
