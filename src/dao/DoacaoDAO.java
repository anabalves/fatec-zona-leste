package dao;

import model.Doacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DoacaoDAO {

    boolean inserir(Doacao doacao);
    boolean alterar(Long id, Doacao doacao);
    boolean deletar(Long id);
    List<Doacao> listar();
    Doacao buscar(Long id);

    Map<Integer, ArrayList> listarQuantidadeVisitasPorMes();

}
