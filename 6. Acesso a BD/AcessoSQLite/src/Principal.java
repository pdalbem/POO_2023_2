import java.util.List;

public class Principal {
    public static void main(String[] args) {

         //ATENÇÃO: Se você executar este código mais de uma vez
        // sem alterar a chave-primária do curso, ocorrerá um erro.
         Curso c1 = new Curso(100,"Java");
         c1.salvar();
         c1.setNome("Java Avançado");
         c1.atualizar();

         System.out.println(Curso.buscar(100).getNome());

         //ATENÇÃO: Se você executar este código mais de uma vez
        // sem alterar a chave-primária do curso, ocorrerá um erro.
         Curso c2 = new Curso(200,"Android");
         c2.salvar();

        List<Curso> listaCursos;
        listaCursos=Curso.buscarTodos();
        for (Curso curso : listaCursos)
                curso.mostrarDados();

        //ATENÇÃO: Se você executar este código mais de uma vez
        // sem alterar a chave-primária do aluno, ocorrerá um erro.
        Aluno a1 = new Aluno(1,"12345","Maria",c1);
        a1.salvar();
        a1.setProntuario("123456");
        a1.atualizar();
        List<Aluno> listaAlunos;
        listaAlunos=Aluno.buscarTodos();
        for  (Aluno aluno : listaAlunos)
             aluno.mostrarDados();

    }
}
