package com.example.bdjavafx.data;

import com.example.bdjavafx.model.Departamento;

import java.util.List;

public interface DepartamentoDAO extends DAO<Departamento> {
    void  salvar(Departamento d);
    void atualizar (Departamento d);
    void excluir (Departamento d);
    Departamento buscar (int id);
    List<Departamento> buscarTodos();
}
