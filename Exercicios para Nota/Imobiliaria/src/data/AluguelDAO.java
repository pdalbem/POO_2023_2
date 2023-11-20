package data;
import model.Aluguel;
import model.Imovel;

import java.util.List;

public interface AluguelDAO extends DAO<Aluguel> {

    //salvar
    void salvar(Aluguel aluguel);
    //atualizar
    void alterar (Aluguel aluguel);
    //apagar
    void apagar(Aluguel aluguel);
    //buscar
    Aluguel buscar (int id);
    //buscar todos
    List<Aluguel> buscarTodos();

    //Metodo para buscar alugueis de um determinado imovel.
    //Sera util para fazer a associacao entre imoveis e seus respectivos alugueis  (navegabilidade birecional)
    List<Aluguel> buscarAluguelPorImovel(Imovel imovel);
}