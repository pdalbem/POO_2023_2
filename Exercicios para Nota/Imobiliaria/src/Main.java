import data.*;
import model.Imovel;
import model.Inquilino;
import model.Proprietario;
import model.Aluguel;


public class Main {
    public static void main(String[] args) {

        Proprietario proprietario1 = new Proprietario("12345667", "Maria", 1, "Santander","123123");
        DAO<Proprietario> proprietarioDAO = new ProprietarioSqliteDAO();
        proprietarioDAO.salvar(proprietario1);


        Inquilino inquilino1 = new Inquilino("54321", "José", 1, 4000);
        DAO<Inquilino> inquilinoDAO = new InquilinoSqliteDAO();
        inquilinoDAO.salvar(inquilino1);


        Imovel imovel1 = new Imovel(1,"Rua AAA",1500,proprietario1);
        DAO<Imovel> imovelDAO = new ImovelSqliteDAO();
        imovelDAO.salvar(imovel1);


        Aluguel aluguel1 = new Aluguel(1, "10/01/2023", "10/01/2025", imovel1, inquilino1 );
        imovel1.incluirAluguel(aluguel1);
        DAO<Aluguel> aluguelDAO = new AluguelSqliteDAO();
        aluguelDAO.salvar(aluguel1);

        for (Proprietario p: proprietarioDAO.buscarTodos())
            p.mostrarDados();

        for (Inquilino i: inquilinoDAO.buscarTodos())
            i.mostrarDados();

       for (Imovel imovel: imovelDAO.buscarTodos())
           imovel.exibirHistoricoAluguel();

        for (Aluguel a: aluguelDAO.buscarTodos())
               a.mostrarDados();


        Imovel imovel3 = imovelDAO.buscar(1);
        imovel3.exibirHistoricoAluguel();

    }
}