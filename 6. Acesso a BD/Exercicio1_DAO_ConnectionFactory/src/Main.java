import data.*;
import model.Departamento;
import model.Funcionario;

public class Main {
    public static void main(String[] args) {
        Departamento d1 = new Departamento(3, "Recursos Humanos", "RH");

        DepartamentoDAO departamentoDAO = new DepartamentoSQLiteDAO();
        //Pode instanciar assim também:
        //DAO<Departamento> departamentoDAO1 = new DepartamentoSQLiteDAO();

        departamentoDAO.salvar(d1);

        Funcionario f1 = new Funcionario(10,"12345", "Maria", d1);

        FuncionarioDAO funcionarioDAO = new FuncionarioSQLiteDAO();
        funcionarioDAO.salvar(f1);

        for (Departamento d: departamentoDAO.buscarTodos())
                d.mostrarDados();

    }
}
