package data;

import model.Time;

import java.util.List;

public interface TimeDAO extends DAO<Time> {
    void salvar(Time time);
    void atualizar(Time time);
    void apagar(Time time);
    Time buscar(int id);
    List<Time> buscarTodos();
}
