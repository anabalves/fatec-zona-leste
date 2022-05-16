package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.LivroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILivroService {

    Page<LivroDTO> findAllPaged(Pageable pageable);
    LivroDTO findById(Long id);
    LivroDTO insert(LivroDTO dto);
    LivroDTO update(Long id, LivroDTO dto);
    void delete(Long id);

}
