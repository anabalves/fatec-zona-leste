package com.fatec.bibliotecanos.resources;

import com.fatec.bibliotecanos.dto.EditoraDTO;
import com.fatec.bibliotecanos.services.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/editoras")
public class EditoraResource {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<Page<EditoraDTO>> findAll(Pageable pageable) {
        Page<EditoraDTO> list = editoraService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EditoraDTO> findById(@PathVariable Long id) {
        EditoraDTO dto = editoraService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<EditoraDTO> insert(@RequestBody EditoraDTO dto) {
        dto = editoraService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EditoraDTO> update(@PathVariable Long id, @RequestBody EditoraDTO dto) {
        dto = editoraService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        editoraService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
