package data;
import model.Aluguel;
import model.Imovel;
import model.Inquilino;
import model.Proprietario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AluguelSqliteDAO implements AluguelDAO {


    @Override
    public void salvar(Aluguel aluguel) {
        String sql = "INSERT INTO aluguel(idAluguel ,inicioContrato, fimContrato, inquilino, imovel) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,aluguel.getIdAluguel());
            stmt.setString(2,aluguel.getInicioContrato());
            stmt.setString(3,aluguel.getFimContrato());
            stmt.setInt(4,aluguel.getInquilino().getIdInquilino());
            stmt.setInt(5,aluguel.getImovel().getIdImovel());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(); }
    }

    @Override
    public void alterar(Aluguel aluguel) {
        String sql = "UPDATE aluguel SET inicioContrato = ?, fimContrato = ?, inquilino = ?, imovel = ? WHERE idAluguel = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,aluguel.getInicioContrato());
            stmt.setString(2,aluguel.getFimContrato());
            stmt.setInt(3,aluguel.getInquilino().getIdInquilino());
            stmt.setInt(4,aluguel.getImovel().getIdImovel());
            stmt.setInt(5,aluguel.getIdAluguel());

            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }



        @Override
    public void apagar(Aluguel aluguel) {
        String sql = "DELETE FROM aluguel WHERE idAluguel=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,aluguel.getIdAluguel());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para buscar alugueis de um determinado imovel.
    //Sera util para fazer a associacao entre imoveis e seus respectivos alugueis  (navegabilidade birecional)
    //Este metodo sera chamado pelos metodos buscar() e buscarTodos() da classe Imovel
    @Override
    public List<Aluguel> buscarAluguelPorImovel(Imovel imovel){
        String sql = "SELECT * FROM aluguel WHERE imovel=?";
        List<Aluguel> listaAluguel=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,imovel.getIdImovel());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Inquilino inquilino = new InquilinoSqliteDAO().buscar(rs.getInt("inquilino"));

                Aluguel aluguel = new Aluguel(rs.getInt("idAluguel"),
                        rs.getString("inicioContrato"),
                        rs.getString("fimContrato"),
                        imovel,
                        inquilino);
                listaAluguel.add(aluguel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAluguel;
    }

    @Override
    public Aluguel buscar(int idAluguel) {
        String sql = "SELECT * FROM aluguel WHERE idAluguel=?";
        Aluguel a=null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idAluguel);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Inquilino inquilino = new InquilinoSqliteDAO().buscar(rs.getInt("inquilino"));
                Imovel imovel = new ImovelSqliteDAO().buscar(rs.getInt("imovel"));

                a = new Aluguel(rs.getInt("idAluguel"),
                        rs.getString("inicioContrato"),
                        rs.getString("fimContrato"),
                        imovel,
                        inquilino);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Aluguel> buscarTodos() {
        String sql = "SELECT * FROM aluguel";
        List<Aluguel> listaAluguel=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inquilino inquilino = new InquilinoSqliteDAO().buscar(rs.getInt("inquilino"));
                Imovel imovel = new ImovelSqliteDAO().buscar(rs.getInt("imovel"));

                Aluguel a = new Aluguel(rs.getInt("idAluguel"),
                        rs.getString("inicioContrato"),
                        rs.getString("fimContrato"),
                        imovel,
                        inquilino
                );
                listaAluguel.add(a);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAluguel;
    }
    }


