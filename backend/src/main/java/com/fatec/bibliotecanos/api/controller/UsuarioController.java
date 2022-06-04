package com.fatec.bibliotecanos.api.controller;

import com.fatec.bibliotecanos.api.dto.UsuarioDTO;
import com.fatec.bibliotecanos.api.dto.request.AtualizarSenhaRequest;
import com.fatec.bibliotecanos.api.dto.request.AtualizarUsuarioRequest;
import com.fatec.bibliotecanos.api.dto.request.RoleToUsuarioRequest;
import com.fatec.bibliotecanos.api.dto.response.MessageResponse;
import com.fatec.bibliotecanos.api.dto.response.RoleToUsuarioResponse;
import com.fatec.bibliotecanos.domain.service.UsuarioServiceImpl;
import com.fatec.bibliotecanos.domain.service.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    Validacoes validacoes;

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> findAll(Pageable pageable) {
        Page<UsuarioDTO> list = usuarioServiceImpl.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        UsuarioDTO dto = usuarioServiceImpl.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioRequest dto) {
        UsuarioDTO newDto = usuarioServiceImpl.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PutMapping(value = "/update-role/{id}")
    public ResponseEntity<RoleToUsuarioResponse> updateRole(@PathVariable Long id, @RequestBody @Valid RoleToUsuarioRequest dto) {
        RoleToUsuarioResponse newDto = usuarioServiceImpl.updateRole(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PutMapping(value = "/update-senha/{id}")
    public ResponseEntity<UsuarioDTO> updateSenha(@PathVariable Long id, @RequestBody @Valid AtualizarSenhaRequest dto) {
        UsuarioDTO newDto = usuarioServiceImpl.updateSenha(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

}
