package data;

import model.Departamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoSQLiteDAO implements DepartamentoDAO{
    @Override
    public void salvar(Departamento departamento) {
        String sql = "INSERT INTO departamento(id, nome, sigla) VALUES (?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,departamento.getId());
            stmt.setString(2, departamento.getNome());
            stmt.setString(3, departamento.getSigla());
            stmt.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void atualizar(Departamento departamento) {
        String sql = "UPDATE departamento SET nome=?, sigla=? WHERE id=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,departamento.getNome());
            stmt.setString(2, departamento.getSigla());
            stmt.setInt(3, departamento.getId());
            stmt.executeUpdate();
        }catch (Exception e){e.printStackTrace();}

    }

    @Override
    public void apagar(Departamento departamento) {
        String sql = "DELETE FROM departamento WHERE id=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, departamento.getId());
            stmt.executeUpdate();
        }catch (Exception e){e.printStackTrace();}

    }

    @Override
    public Departamento buscar(int id) {
        String sql = "SELECT * FROM departamento WHERE id=?";
        Departamento d=null;
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                d = new Departamento(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("sigla"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }


    @Override
    public List<Departamento> buscarTodos() {
       String sql="SELECT * FROM departamento";
       List<Departamento> listaDep = new ArrayList<>();
       try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
           ResultSet rs = stmt.executeQuery();
           while (rs.next())
           {
               Departamento d = new Departamento(rs.getInt("id"),
                       rs.getString("nome"),
                       rs.getString("sigla"));
               listaDep.add(d);
           }
       }catch (Exception e){e.printStackTrace();}
       return listaDep;
    }
}
