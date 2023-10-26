import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int idCurso;
    private String nome;

    public void salvar(){
        String sql = "INSERT INTO curso (idCurso,nome) values (?,?)";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1,getIdCurso());
            stmt.setString(2,getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(){
        String sql = "UPDATE curso SET nome=? WHERE idCurso=?";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1,getNome());
            stmt.setInt(2,getIdCurso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagar(){
        String sql = "DELETE FROM curso WHERE idCurso=?";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
           stmt.setInt(1,getIdCurso());
           stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Curso buscar(int param){
        String sql = "SELECT * FROM curso WHERE idCurso=?";
        Curso c=null;
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1,param);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static List<Curso> buscarTodos(){
        String sql = "SELECT * FROM curso";
        List<Curso> listaCursos =new ArrayList<>();
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));
                listaCursos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCursos;
    }

    public void mostrarDados(){
        System.out.println("\n Id: " + getIdCurso() +
                "\n Nome: " + getNome());
    }
    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
