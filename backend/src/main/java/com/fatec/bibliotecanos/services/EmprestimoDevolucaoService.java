package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.dto.EmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.entities.EmprestimoDevolucao;
import com.fatec.bibliotecanos.repositories.EmprestimoDevolucaoRepository;
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
public class EmprestimoDevolucaoService implements IEmprestimoDevolucaoService {

    @Autowired
    private EmprestimoDevolucaoRepository emprestimoDevolucaoRepository;

    @Override
    public Page<EmprestimoDevolucaoDTO> findAllPaged(Pageable pageable) {
        Page<EmprestimoDevolucao> list = emprestimoDevolucaoRepository.findAll(pageable);
        return list.map(x -> new EmprestimoDevolucaoDTO(x));
    }

    @Override
    public EmprestimoDevolucaoDTO findById(Long id) {
        Optional<EmprestimoDevolucao> obj = emprestimoDevolucaoRepository.findById(id);
        EmprestimoDevolucao entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new EmprestimoDevolucaoDTO(entity);
    }

    @Override
    public EmprestimoDevolucaoDTO insert(EmprestimoDevolucaoDTO dto) {
        EmprestimoDevolucao entity = new EmprestimoDevolucao();
        copyDtoToEntity(dto, entity);
        entity = emprestimoDevolucaoRepository.save(entity);
        return new EmprestimoDevolucaoDTO(entity);
    }

    @Override
    public EmprestimoDevolucaoDTO update(Long id, EmprestimoDevolucaoDTO dto) {
        try {
            EmprestimoDevolucao entity = emprestimoDevolucaoRepository.getById(id);
            copyDtoToEntity(dto, entity);
            entity = emprestimoDevolucaoRepository.save(entity);
            return new EmprestimoDevolucaoDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Override
    public void delete(Long id) {
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

    private void copyDtoToEntity(EmprestimoDevolucaoDTO dto, EmprestimoDevolucao entity) {
        entity.setSituacao(dto.getSituacao());
        entity.setDataEmprestimo(dto.getDataEmprestimo());
        entity.setDataDevoliucao(dto.getDataDevoliucao());
    }

}
