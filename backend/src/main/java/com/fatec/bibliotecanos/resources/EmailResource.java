package com.fatec.bibliotecanos.resources;

import com.fatec.bibliotecanos.dto.EmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.dto.LivroDTO;
import com.fatec.bibliotecanos.dto.UsuarioDTO;
import com.fatec.bibliotecanos.entities.Livro;
import com.fatec.bibliotecanos.services.EmailServiceImpl;
import com.fatec.bibliotecanos.services.EmprestimoDevolucaoService;
import com.fatec.bibliotecanos.services.LivroService;
import com.fatec.bibliotecanos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Configuration
@EnableScheduling
public class EmailResource {

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    private EmprestimoDevolucaoService emprestimoDevolucaoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LivroService livroService;

    @Scheduled(cron="0 0 8 * * *", zone="America/Sao_Paulo")
    public void sendMail() {
        List<EmprestimoDevolucaoDTO> usuariosComDevolucaoEmDoisDias = emprestimoDevolucaoService.findAllUsuarioIdComDevolucaoEmDoisDias();

        for (EmprestimoDevolucaoDTO emprestimoDevolucao : usuariosComDevolucaoEmDoisDias) {
            UsuarioDTO usuario = usuarioService.findById(emprestimoDevolucao.getUsuarioId());
            LivroDTO livro = livroService.findById(emprestimoDevolucao.getLivroId());
            emailService.sendMail(
                    usuario.getEmail(),
                    "Olá " + usuario.getNome() + "!\n\nEstamos enviando esse e-mail para te lembrar que faltam apenas 2 dias para o vencimento do seu empréstimo do livro " + livro.getTitulo() + ".\nFaça a devolucação para que sua situação não se torne irregular, impossibilitando a realização de empréstimos por 30 dias.\n\nDesejamos uma ótima semana ;) \n\nAtenciosamente,\nEquipe Bibliotecanos",
                    usuario.getNome() + " seu Empréstimo vence em 2 dias!!");
        }
    }

}
