package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.LivroDTO;
import com.fatec.bibliotecanos.entities.Editora;
import com.fatec.bibliotecanos.entities.EmprestimoDevolucao;
import com.fatec.bibliotecanos.entities.Genero;
import com.fatec.bibliotecanos.entities.Livro;
import com.fatec.bibliotecanos.entities.enums.ELivro;
import com.fatec.bibliotecanos.repositories.EditoraRepository;
import com.fatec.bibliotecanos.repositories.GeneroRepository;
import com.fatec.bibliotecanos.repositories.LivroRepository;
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
public class LivroService implements ILivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @Override
    public Page<LivroDTO> findAll(Pageable pageable) {
        Page<Livro> list = livroRepository.findAll(pageable);
        return list.map(x -> new LivroDTO(x));
    }

    @Override
    public LivroDTO findById(Long id) {
        Optional<Livro> obj = livroRepository.findById(id);
        Livro entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new LivroDTO(entity);
    }

    @Override
    public LivroDTO insert(LivroDTO dto) {
        Livro entity = new Livro();

        if (dto.getQuantidade().equals(0))
            entity.setStatus(ELivro.INDISPONIVEL);

        copyDtoToEntity(dto, entity);
        entity.setStatus(ELivro.DISPONIVEL);
        entity = livroRepository.save(entity);
        return new LivroDTO(entity);
    }

    @Override
    public LivroDTO update(Long id, LivroDTO dto) {
        try {
            Livro entity = livroRepository.getById(id);

            if (dto.getQuantidade().equals(0))
                entity.setStatus(ELivro.INDISPONIVEL);

            copyDtoToEntity(dto, entity);
            entity.setStatus(ELivro.DISPONIVEL);
            entity = livroRepository.save(entity);
            return new LivroDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            livroRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação da integridade");
        }
    }

    private void copyDtoToEntity(LivroDTO dto, Livro entity) {
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setAutor(dto.getAutor());
        entity.setEdicao(dto.getEdicao());
        entity.setIsbn(dto.getIsbn());
        entity.setQuantidade(dto.getQuantidade());
        entity.setImgUrl(dto.getImgUrl());
        entity.setAnoPublicacao(dto.getAnoPublicacao());

        Genero genero = generoRepository.getOne(dto.getId());
        entity.setGenero(genero);

        Editora editora = editoraRepository.getOne(dto.getId());
        entity.setEditora(editora);
    }

}
