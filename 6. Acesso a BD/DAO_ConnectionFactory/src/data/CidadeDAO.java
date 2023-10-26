package data;

import model.Cidade;

import java.util.List;


public interface CidadeDAO extends DAO<Cidade> {
    void  salvar(Cidade cidade);
    void atualizar (Cidade cidade);
    void apagar (Cidade cidade);
    Cidade buscar (int id);
    List<Cidade> buscarTodos();
}
