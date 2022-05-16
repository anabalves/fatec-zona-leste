package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.GeneroDTO;
import com.fatec.bibliotecanos.entities.Genero;
import com.fatec.bibliotecanos.repositories.GeneroRepository;
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
public class GeneroService implements IGeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public Page<GeneroDTO> findAllPaged(Pageable pageable) {
        Page<Genero> list = generoRepository.findAll(pageable);
        return list.map(x -> new GeneroDTO(x));
    }

    @Override
    public GeneroDTO findById(Long id) {
        Optional<Genero> obj = generoRepository.findById(id);
        Genero entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new GeneroDTO(entity);
    }

    @Override
    public GeneroDTO insert(GeneroDTO dto) {
        Genero entity = new Genero();
        copyDtoToEntity(dto, entity);
        entity = generoRepository.save(entity);
        return new GeneroDTO(entity);
    }

    @Override
    public GeneroDTO update(Long id, GeneroDTO dto) {
        try {
            Genero entity = generoRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = generoRepository.save(entity);
            return new GeneroDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            generoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação da integridade");
        }
    }

    private void copyDtoToEntity(GeneroDTO dto, Genero entity) {
        entity.setNome(dto.getNome());
    }

}
