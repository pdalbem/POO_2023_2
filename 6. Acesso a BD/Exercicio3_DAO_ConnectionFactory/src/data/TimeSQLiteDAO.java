package data;

import model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeSQLiteDAO implements TimeDAO{

    @Override
    public void salvar(Time time) {
        String sql = "INSERT INTO time(idTime,pais) VALUES (?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,time.getIdTime());
            stmt.setString(2,time.getPais());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Time time) {
        String sql = "UPDATE time SET pais=? WHERE idTime = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,time.getPais());
            stmt.setInt(2,time.getIdTime());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Time time) {
        String sql = "DELETE FROM time WHERE idTime=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,time.getIdTime());
            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Time buscar(int id) {
        String sql = "SELECT * FROM time WHERE idTime=?";
        Time time = null;
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                time = new Time(rs.getInt("idTime"),rs.getString("pais"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public List<Time> buscarTodos() {
        String sql = "SELECT * FROM time";
        List<Time> listaTimes = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Time time = new Time(rs.getInt("idTime"),rs.getString("pais"));
                listaTimes.add(time);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return listaTimes;
    }
    }

