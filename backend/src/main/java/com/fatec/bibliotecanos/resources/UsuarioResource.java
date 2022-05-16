package com.fatec.bibliotecanos.resources;

import com.fatec.bibliotecanos.services.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioResource {

//    @Autowired
//    private UsuarioDetailsServiceImpl usuarioService;
//
//    @GetMapping
//    public ResponseEntity<Page<UsuarioDTO>> findAll(Pageable pageable) {
//        Page<UsuarioDTO> list = usuarioService.findAllPaged(pageable);
//        return ResponseEntity.ok().body(list);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
//        UsuarioDTO dto = usuarioService.findById(id);
//        return ResponseEntity.ok().body(dto);
//    }
//
//    @PostMapping
//    public ResponseEntity<UsuarioDTO> insert(@RequestBody @Valid UsuarioInsertDTO dto) {
//        UsuarioDTO newDto = usuarioService.insert(dto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(newDto.getId()).toUri();
//        return ResponseEntity.created(uri).body(newDto);
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateDTO dto) {
//        UsuarioDTO newDto = usuarioService.update(id, dto);
//        return ResponseEntity.ok().body(newDto);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        usuarioService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
