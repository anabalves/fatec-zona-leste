package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.UsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {

    Page<UsuarioDTO> findAllPaged(Pageable pageable);
    UsuarioDTO findById(Long id);
    UsuarioDTO update(Long id, UsuarioDTO dto);
    void delete(Long id);

}
