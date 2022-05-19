package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.EmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.entities.*;
import com.fatec.bibliotecanos.entities.enums.EEmprestimoDevolucao;
import com.fatec.bibliotecanos.entities.enums.ELivro;
import com.fatec.bibliotecanos.repositories.EmprestimoDevolucaoRepository;
import com.fatec.bibliotecanos.repositories.LivroRepository;
import com.fatec.bibliotecanos.repositories.UsuarioRepository;
import com.fatec.bibliotecanos.services.exceptions.DatabaseException;
import com.fatec.bibliotecanos.services.exceptions.EmprestimoDevolucaoException;
import com.fatec.bibliotecanos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@Transactional
public class EmprestimoDevolucaoService implements IEmprestimoDevolucaoService {

    @Autowired
    private EmprestimoDevolucaoRepository emprestimoDevolucaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public EmprestimoDevolucaoDTO findById(Long id) {
        Optional<EmprestimoDevolucao> obj = emprestimoDevolucaoRepository.findById(id);
        EmprestimoDevolucao entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new EmprestimoDevolucaoDTO(entity);
    }

    @Override
    public EmprestimoDevolucaoDTO realizarEmprestimo(EmprestimoDevolucaoDTO dto) {
        EmprestimoDevolucao entity = new EmprestimoDevolucao();
        Livro livro = livroRepository.getOne(dto.getLivroId());
        if (livro.getStatus().equals(ELivro.INDISPONIVEL)) {
            throw new EmprestimoDevolucaoException("Livro Indisponivel");
        } else {
            copyDtoToEntity(dto, entity);
            entity.setDataEmprestimo(Instant.now());
            entity.setSituacao(EEmprestimoDevolucao.EM_DIA);
            Instant instant = entity.getDataEmprestimo();
            entity.setDataDevolucao(instant.plus(30, ChronoUnit.DAYS));

            entity = emprestimoDevolucaoRepository.save(entity);

            livro.setQuantidade(livro.getQuantidade() - 1);

            return new EmprestimoDevolucaoDTO(entity);
        }
    }

    @Override
    public EmprestimoDevolucaoDTO realizarDevolucao(Long id, EmprestimoDevolucaoDTO dto) {
        try {
            Livro livro = livroRepository.getOne(dto.getLivroId());
            EmprestimoDevolucao entity = emprestimoDevolucaoRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity.setDataEmprestimo(entity.getDataEmprestimo());
            entity.setDataDevolucao(Instant.now());
            entity.setSituacao(EEmprestimoDevolucao.DEVOLVIDO);
            livro.setQuantidade(livro.getQuantidade() + 1);
            entity = emprestimoDevolucaoRepository.save(entity);
            return new EmprestimoDevolucaoDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Override
    public void deleteEmprestimo(Long id) {
        try {
            emprestimoDevolucaoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação da integridade");
        }
    }

    @Override
    public Page<EmprestimoDevolucaoDTO> relatorioUsuarios(Pageable pageable) {
        Page<EmprestimoDevolucao> list = emprestimoDevolucaoRepository.findAll(pageable);
        return list.map(EmprestimoDevolucaoDTO::new);
    }

    @Override
    public Page<EmprestimoDevolucaoDTO> relatorioSaida(Pageable pageable) {
        Page<EmprestimoDevolucao> list = emprestimoDevolucaoRepository.findAll(pageable);
        return list.map(EmprestimoDevolucaoDTO::new);
    }

    @Override
    public Page<EmprestimoDevolucaoDTO> relatorioAtrasos(Pageable pageable) {
        Page<EmprestimoDevolucao> list = emprestimoDevolucaoRepository.findAll(pageable);
        return list.map(EmprestimoDevolucaoDTO::new);
    }

    @Override
    public Page<EmprestimoDevolucaoDTO> findAll(Pageable pageable) {
        Page<EmprestimoDevolucao> list = emprestimoDevolucaoRepository.findAll(pageable);
        return list.map(EmprestimoDevolucaoDTO::new);
    }

    private void copyDtoToEntity(EmprestimoDevolucaoDTO dto, EmprestimoDevolucao entity) {
        Usuario usuario = usuarioRepository.getOne(dto.getUsuarioId());
        entity.setUsuario(usuario);

        Livro livro = livroRepository.getOne(dto.getLivroId());
        entity.setLivro(livro);
    }

}
