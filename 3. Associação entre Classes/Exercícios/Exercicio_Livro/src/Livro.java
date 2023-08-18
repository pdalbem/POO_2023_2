import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Livro {
    private String titulo;
    private int anoPublicacao;
    private double preco;
    private Editora editora;
    private List<Autor> autores = new ArrayList<>();

    public void adicionarAutor(Autor...autores){
        Collections.addAll(this.autores,autores);
    }

    public void adicionarAutor(Autor autor){
        this.autores.add(autor);
    }

    public void removerAutor(Autor autor)
    {
        this.autores.remove(autor);
    }

    public Livro() {
    }

    public Livro(String titulo, int anoPublicacao, double preco, Editora editora) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.editora = editora;
    }

    public Livro(String titulo, int anoPublicacao, double preco, Editora editora, List<Autor> autores) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.editora = editora;
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
