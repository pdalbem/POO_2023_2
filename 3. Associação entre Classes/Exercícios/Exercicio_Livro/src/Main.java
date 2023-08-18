import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Editora ed1 = new Editora("Pearson", "123456");

        Autor a1 = new Autor();
        a1.setNome("Deitel");
        a1.setTelefone("3351-1234");

        Autor a2 = new Autor("Maria", "3351-1234");

        //Repare que os autores são passados no construtor.
        Livro livr1 = new Livro("Java", 2015, 400, ed1, List.of(a1,a2));

        //Os autores são passados via método setAutores()
        Livro livro2 = new Livro("POO", 2020, 300, ed1);
        livro2.setAutores(List.of(a1,a2));
        Autor a3 = new Autor("Joao", "1234");
        livro2.setAutores(List.of(a1,a2,a3));

        //ArrayList é criado no main e passado para o setAutores()
        List<Autor> lista = new ArrayList<>();
        lista.add(a1);
        lista.add(a2);
        livro2.setAutores(lista);
        lista.add(a3);

        //Uso do método adicionarAutor
        Livro livro3 = new Livro("C#", 2015, 200, ed1);
        livro3.adicionarAutor(a1);
        livro3.adicionarAutor(a2);
        livro3.adicionarAutor(a3);

        //Uso do método adicionarAutor() com quantidade variável de parâmetro
       // livro3.adicionarAutor(a1,a2,a3);

        System.out.println("Autores do livro " + livro3.getTitulo() + ": ");
        for (Autor a:livro3.getAutores())
            System.out.println("Nome: " + a.getNome());

    }
}