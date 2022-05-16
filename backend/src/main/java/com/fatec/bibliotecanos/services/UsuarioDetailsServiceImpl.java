package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.entities.Role;
import com.fatec.bibliotecanos.entities.Usuario;
import com.fatec.bibliotecanos.repositories.RoleRepository;
import com.fatec.bibliotecanos.repositories.UsuarioRepository;
import com.fatec.bibliotecanos.services.exceptions.DatabaseException;
import com.fatec.bibliotecanos.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UsuarioDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Override
//    public Page<UsuarioDTO> findAllPaged(Pageable pageable) {
//        Page<Usuario> list = usuarioRepository.findAll(pageable);
//        return list.map(UsuarioDTO::new);
//    }
//
//    @Override
//    public UsuarioDTO findById(Long id) {
//        Optional<Usuario> obj = usuarioRepository.findById(id);
//        Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
//        return new UsuarioDTO(entity);
//    }
//
//    @Override
//    public UsuarioDTO insert(UsuarioInsertDTO dto) {
//        Usuario entity = new Usuario();
//        copyDtoToEntity(dto, entity);
//        entity.setSenha(passwordEncoder.encode(dto.getSenha()));
//        entity = usuarioRepository.save(entity);
//        return new UsuarioDTO(entity);
//    }
//
//    @Override
//    public UsuarioDTO update(Long id, UsuarioUpdateDTO dto) {
//        try {
//            Usuario entity = usuarioRepository.getById(id);
//            copyDtoToEntity(dto, entity);
//            entity = usuarioRepository.save(entity);
//            return new UsuarioDTO(entity);
//        }
//        catch (EntityNotFoundException e) {
//            throw new ResourceNotFoundException("Id não encontrado " + id);
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        try {
//            usuarioRepository.deleteById(id);
//        }
//        catch (EmptyResultDataAccessException e) {
//            throw new ResourceNotFoundException("Id não encontrado " + id);
//        }
//        catch (DataIntegrityViolationException e) {
//            throw new DatabaseException("Violação da integridade");
//        }
//    }
//
//    private void copyDtoToEntity(UsuarioDTO dto, Usuario entity) {
//
//        entity.setNome(dto.getNome());
//        entity.setSobrenome(dto.getSobrenome());
//        entity.setEmail(dto.getEmail());
//        entity.setEmailAlternativo(dto.getEmailAlternativo());
//        entity.setCpf(dto.getCpf());
//        entity.setTelefone(dto.getTelefone());
//        entity.setCep(dto.getCep());
//        entity.setEndereco(dto.getEndereco());
//        entity.setNumeroEndereco(dto.getNumeroEndereco());
//        entity.setComplemento(dto.getComplemento());
//        entity.setCidade(dto.getCidade());
//        entity.setEstado(dto.getEstado());
//        entity.setSituacao(dto.getSituacao());
//        entity.setObservacao(dto.getObservacao());
//
//        entity.getRoles().clear();
//        for (RoleDTO roleDto : dto.getRoles()) {
//            Role role = roleRepository.getById(roleDto.getId());
//            entity.getRoles().add(role);
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UsuarioDetailsImpl.build(usuario);
    }

}
