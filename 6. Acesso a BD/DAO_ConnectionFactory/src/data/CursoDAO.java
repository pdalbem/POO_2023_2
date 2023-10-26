package data;

import model.Curso;

import java.util.List;

public interface CursoDAO extends DAO<Curso> {

    void  salvar(Curso curso);
    void atualizar (Curso curso);
    void apagar (Curso curso);
    Curso buscar (int id);
    List<Curso> buscarTodos();
}
