package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.EmprestimoDevolucaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmprestimoDevolucaoService {

    Page<EmprestimoDevolucaoDTO> relatorioUsuarios(Pageable pageable);
    Page<EmprestimoDevolucaoDTO> relatorioSaida(Pageable pageable);
    Page<EmprestimoDevolucaoDTO> relatorioAtrasos(Pageable pageable);
    Page<EmprestimoDevolucaoDTO> findAll(Pageable pageable);
    EmprestimoDevolucaoDTO findById(Long id);
    EmprestimoDevolucaoDTO realizarEmprestimo(EmprestimoDevolucaoDTO dto);
    EmprestimoDevolucaoDTO realizarDevolucao(Long id, EmprestimoDevolucaoDTO dto);
    void deleteEmprestimo(Long id);

}
