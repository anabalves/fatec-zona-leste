package com.fatec.bibliotecanos.resources;

import com.fatec.bibliotecanos.dto.EmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.services.EmprestimoDevolucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/emprestimos-devolucoes")
public class EmprestimoDevolucaoResource {

    @Autowired
    private EmprestimoDevolucaoService emprestimoDevolucaoService;

    @GetMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<Page<EmprestimoDevolucaoDTO>> findAll(Pageable pageable) {
        Page<EmprestimoDevolucaoDTO> list = emprestimoDevolucaoService.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<EmprestimoDevolucaoDTO> findById(@PathVariable Long id) {
        EmprestimoDevolucaoDTO dto = emprestimoDevolucaoService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<EmprestimoDevolucaoDTO> realizarEmprestimo(@RequestBody EmprestimoDevolucaoDTO dto) {
        dto = emprestimoDevolucaoService.realizarEmprestimo(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<EmprestimoDevolucaoDTO> realizarDevolucao(@PathVariable Long id, @RequestBody EmprestimoDevolucaoDTO dto) {
        dto = emprestimoDevolucaoService.realizarDevolucao(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteEmprestimo(@PathVariable Long id) {
        emprestimoDevolucaoService.deleteEmprestimo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/relatorioUsuarios")
    public ResponseEntity<Page<EmprestimoDevolucaoDTO>> relatorioUsuarios(Pageable pageable) {
        Page<EmprestimoDevolucaoDTO> list = emprestimoDevolucaoService.relatorioUsuarios(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/relatorioSaida")
    public ResponseEntity<Page<EmprestimoDevolucaoDTO>> relatorioSaida(Pageable pageable) {
        Page<EmprestimoDevolucaoDTO> list = emprestimoDevolucaoService.relatorioSaida(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/relatorioAtrasos")
    public ResponseEntity<Page<EmprestimoDevolucaoDTO>> relatorioAtrasos(Pageable pageable) {
        Page<EmprestimoDevolucaoDTO> list = emprestimoDevolucaoService.relatorioAtrasos(pageable);
        return ResponseEntity.ok().body(list);
    }

}
