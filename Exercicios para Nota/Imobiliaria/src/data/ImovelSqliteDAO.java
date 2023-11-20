package data;
import model.Aluguel;
import model.Imovel;
import model.Proprietario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ImovelSqliteDAO implements ImovelDAO {
    @Override
    public void salvar(Imovel imovel) {
        String sql = "INSERT INTO imovel(idImovel,endereco, valorAluguel, proprietario) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,imovel.getIdImovel());
            stmt.setString(2,imovel.getEndereco());
            stmt.setDouble(3,imovel.getValorAluguel());
            stmt.setInt(4,imovel.getProprietario().getIdProprietario());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(); }
    }

    @Override
    public void alterar(Imovel imovel) {
        String sql = "UPDATE aluguel SET endereco=?, valorAluguel=?, proprietario=? WHERE idAluguel=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,imovel.getEndereco());
            stmt.setDouble(2,imovel.getValorAluguel());
            stmt.setInt(3,imovel.getProprietario().getIdProprietario());
            stmt.setInt(4,imovel.getIdImovel());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Imovel imovel) {
        String sql = "DELETE FROM imovel WHERE idImovel=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,imovel.getIdImovel());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Imovel buscar(int idImovel) {
        String sql = "SELECT * FROM imovel WHERE idImovel=?";
        Imovel imovel=null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idImovel);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proprietario proprietario = new ProprietarioSqliteDAO().buscar(rs.getInt("proprietario"));

                imovel = new Imovel(rs.getInt("idImovel"),
                        rs.getString("endereco"),
                        rs.getDouble("valorAluguel"),
                        proprietario);


                List<Aluguel> listaAluguelPorImovel=new AluguelSqliteDAO().buscarAluguelPorImovel(imovel);
               imovel.incluirAluguel(listaAluguelPorImovel.toArray(new Aluguel[0]));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imovel;
    }

    @Override
    public List<Imovel> buscarTodos() {
        String sql = "SELECT * FROM imovel";
        List<Imovel> listaImoveis=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Proprietario proprietario = new ProprietarioSqliteDAO().buscar(rs.getInt("proprietario"));

                Imovel imovel = new Imovel(rs.getInt("idImovel"),
                        rs.getString("endereco"),
                        rs.getDouble("valorAluguel"),
                        proprietario);

                // É preciso retornar os alugueis desse imovel. Por isso, chamamos o metodo AluguelSqliteDAO().buscarAluguelPorImovel
                List<Aluguel> listaAluguelPorImovel=new AluguelSqliteDAO().buscarAluguelPorImovel(imovel);
                //Agora, éó so associar os alugueis com o imovel
                imovel.incluirAluguel(listaAluguelPorImovel.toArray(new Aluguel[0]));

                listaImoveis.add(imovel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaImoveis;}
}
