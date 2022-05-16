package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.GeneroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneroService {

    Page<GeneroDTO> findAllPaged(Pageable pageable);
    GeneroDTO findById(Long id);
    GeneroDTO insert(GeneroDTO dto);
    GeneroDTO update(Long id, GeneroDTO dto);
    void delete(Long id);

}
