package com.fatec.bibliotecanos.entities;

import com.fatec.bibliotecanos.entities.enums.EEmprestimoDevolucao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_emprestimo_devolucao")
public class EmprestimoDevolucao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EEmprestimoDevolucao situacao;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id")
    private Livro livro;

}
