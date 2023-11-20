package data;

import model.Partida;
import model.Time;

import java.util.List;

public interface PartidaDAO extends DAO<Partida> {
    void salvar(Partida partida);
    void atualizar(Partida partida);
    void apagar(Partida partida);
    Partida buscar(int id);
    List<Partida> buscarTodos();
}
