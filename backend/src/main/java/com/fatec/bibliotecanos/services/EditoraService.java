package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.EditoraDTO;
import com.fatec.bibliotecanos.entities.Editora;
import com.fatec.bibliotecanos.repositories.EditoraRepository;
import com.fatec.bibliotecanos.services.exceptions.DatabaseException;
import com.fatec.bibliotecanos.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EditoraService implements IEditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    @Override
    public Page<EditoraDTO> findAllPaged(Pageable pageable) {
        Page<Editora> list = editoraRepository.findAll(pageable);
        return list.map(x -> new EditoraDTO(x));
    }

    @Override
    public EditoraDTO findById(Long id) {
        Optional<Editora> obj = editoraRepository.findById(id);
        Editora entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new EditoraDTO(entity);
    }

    @Override
    public EditoraDTO insert(EditoraDTO dto) {
        Editora entity = new Editora();
        copyDtoToEntity(dto, entity);
        entity = editoraRepository.save(entity);
        return new EditoraDTO(entity);
    }

    @Override
    public EditoraDTO update(Long id, EditoraDTO dto) {
        try {
            Editora entity = editoraRepository.getById(id);
            copyDtoToEntity(dto, entity);
            entity = editoraRepository.save(entity);
            return new EditoraDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            editoraRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação da integridade");
        }
    }

    private void copyDtoToEntity(EditoraDTO dto, Editora entity) {
        entity.setNome(dto.getNome());
    }

}
