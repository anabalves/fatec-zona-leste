package dao;

import model.Reserva;

import java.util.List;

public interface ReservaDAO {

    boolean inserir(Reserva reserva);
    boolean alterar(Long id, Reserva reserva);
    boolean deletar(Long id);
    List<Reserva> listar();
    Reserva buscar(String nome);

}
