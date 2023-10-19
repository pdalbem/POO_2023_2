import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Aluno   {
    private int idAluno;
    private String prontuario;
    private String nome;
    private Curso curso;



    public void salvar(){
        String sql = "INSERT INTO aluno (idAluno, prontuario, nome, curso) values (?,?,?,?,)";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(1,getIdAluno());
            stmt.setString(2,getProntuario());
            stmt.setString(3,getNome());
            stmt.setInt(4,getCurso().getIdCurso());
            stmt.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    public void atualizar(){
        String sql = "UPDATE aluno SET prontuario=?, nome=?, curso=? WHERE idAluno=?";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setString(1,getProntuario());
            stmt.setString(2,getNome());
            stmt.setInt(3,getCurso().getIdCurso());
            stmt.setInt(4,getIdAluno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagar(){
        String sql = "DELETE FROM aluno WHERE idAluno=?";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(1,getIdAluno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Aluno buscar(int param){
        String sql = "SELECT * FROM aluno WHERE idAluno=?";
        Aluno a=null;
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(1,param);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = Curso.buscar(rs.getInt("curso"));
                a = new Aluno(rs.getInt("idAluno"),
                              rs.getString("prontuario"),
                              rs.getString("nome"),
                              curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public static List<Aluno> buscarTodos(){
        String sql = "SELECT * FROM aluno";
        List<Aluno> listaAlunos=new ArrayList<>();
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = Curso.buscar(rs.getInt("curso"));
                Aluno a = new Aluno(rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso);
                listaAlunos.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlunos;
    }

    public void mostrarDados(){
        System.out.println("\n Id: " + getIdAluno() +
                "\n Nome: " + getNome() +
                "\n Prontuario: " + getProntuario()+
                "\n Curso: " + getCurso().getNome()
               );
    }

    public Aluno(int idAluno, String prontuario, String nome, Curso curso) {
        this.idAluno = idAluno;
        this.prontuario = prontuario;
        this.nome = nome;
        this.curso = curso;
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
