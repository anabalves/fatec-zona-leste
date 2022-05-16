package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.EditoraDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEditoraService {

    Page<EditoraDTO> findAllPaged(Pageable pageable);
    EditoraDTO findById(Long id);
    EditoraDTO insert(EditoraDTO dto);
    EditoraDTO update(Long id, EditoraDTO dto);
    void delete(Long id);

}
