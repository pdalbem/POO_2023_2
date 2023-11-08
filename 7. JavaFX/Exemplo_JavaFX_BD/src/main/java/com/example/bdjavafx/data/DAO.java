package com.example.bdjavafx.data;

import java.util.List;

public interface DAO<T> {
    void  salvar(T type);
    void atualizar (T type);
    void excluir (T type);
    T buscar (int id);
    List<T> buscarTodos();
}
