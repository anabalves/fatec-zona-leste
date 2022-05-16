package com.fatec.bibliotecanos.resources;

import com.fatec.bibliotecanos.dto.EmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.dto.LivroDTO;
import com.fatec.bibliotecanos.services.EmprestimoDevolucaoService;
import com.fatec.bibliotecanos.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/emprestimos-devolucoes")
public class EmprestimoDevolucaoResource {

    @Autowired
    private EmprestimoDevolucaoService emprestimoDevolucaoService;

    @GetMapping
    public ResponseEntity<Page<EmprestimoDevolucaoDTO>> findAll(Pageable pageable) {
        Page<EmprestimoDevolucaoDTO> list = emprestimoDevolucaoService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmprestimoDevolucaoDTO> findById(@PathVariable Long id) {
        EmprestimoDevolucaoDTO dto = emprestimoDevolucaoService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<EmprestimoDevolucaoDTO> insert(@RequestBody EmprestimoDevolucaoDTO dto) {
        dto = emprestimoDevolucaoService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmprestimoDevolucaoDTO> update(@PathVariable Long id, @RequestBody EmprestimoDevolucaoDTO dto) {
        dto = emprestimoDevolucaoService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emprestimoDevolucaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
