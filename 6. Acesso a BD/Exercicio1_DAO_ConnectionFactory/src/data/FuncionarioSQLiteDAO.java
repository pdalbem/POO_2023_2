package data;

import model.Departamento;
import model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioSQLiteDAO implements FuncionarioDAO{
    @Override
    public void salvar(Funcionario funcionario) {
        String sql="INSERT INTO funcionario(id, cpf, nome, departamento) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,funcionario.getId());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getNome());
            stmt.setInt(4,funcionario.getDepartamento().getId());
            stmt.executeUpdate();
        }catch (Exception e){e.printStackTrace();}

    }

    @Override
    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET cpf=?, nome=?, departamento=? WHERE id=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setInt(3,funcionario.getDepartamento().getId());
            stmt.setInt(4,funcionario.getId());
            stmt.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void apagar(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE id=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,funcionario.getId());
            stmt.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public Funcionario buscar(int id) {
        String sql = "SELECT * FROM funcionario WHERE id=?";
        Funcionario f=null;
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento d = new DepartamentoSQLiteDAO().buscar(rs.getInt("departamento"));
                f = new Funcionario(rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Funcionario> buscarTodos() {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> listaFunc=new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento d = new DepartamentoSQLiteDAO().buscar(rs.getInt("departamento"));
                Funcionario f = new Funcionario(rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        d);
                listaFunc.add(f);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFunc;
    }
}
