package data;

import model.Aluno;
import java.util.List;
public interface AlunoDAO extends DAO<Aluno> {
    void  salvar(Aluno aluno);
    void atualizar (Aluno aluno);
    void apagar (Aluno aluno);
    Aluno buscar (int id);
    List<Aluno> buscarTodos();

}
