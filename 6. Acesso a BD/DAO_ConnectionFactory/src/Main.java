import data.*;
import model.Aluno;
import model.Cidade;
import model.Curso;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         Curso curso1 = new Curso(100,"Java");
         Curso curso2 = new Curso(200,"POO");

          CursoDAO cursoDAO = new CursoSQLiteDAO();
         //Outra forma de instanciar o DAO:
         //DAO<Curso> cursoDAO = new CursoSQLiteDAO();

         cursoDAO.salvar(curso1);
         cursoDAO.salvar(curso2);

        
        Cidade cidade1 = new Cidade(10, "São Carlos");
        Cidade cidade2 = new Cidade(20, "Ribeirão Preto");

         CidadeDAO cidadeDAO = new CidadeSQLiteDAO();
        //Outra forma de instanciar o DAO:
        //DAO<Cidade> cidadeDAO = new CidadeSQLiteDAO();
        cidadeDAO.salvar(cidade1);
        cidadeDAO.salvar(cidade2);

        Aluno a1 = new Aluno(1,"1010","Maria",curso1,cidade1);
        Aluno a2 = new Aluno(2,"2020","João",curso2,cidade2);

        AlunoDAO alunoDAO = new AlunoSQLiteDAO();
        //Outra forma de instanciar o DAO:
        //DAO<Aluno> alunoDAO = new AlunoSQLiteDAO();

        alunoDAO.salvar(a1);
        alunoDAO.salvar(a2);


        List<Curso> listaCursos=cursoDAO.buscarTodos();
        for (Curso c : listaCursos )
            c.mostrarDados();

        List<Cidade> listaCidades=cidadeDAO.buscarTodos();
        for (Cidade c : listaCidades )
            c.mostrarDados();

        List<Aluno> listaAlunos=alunoDAO.buscarTodos();
        for (Aluno a : listaAlunos )
            a.mostrarDados();

    }
}
