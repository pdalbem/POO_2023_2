import java.util.Objects;

public class Professor extends Pessoa{
    private String matricula;
    private String titulacao;

    //Implementação do método abstrato.
    @Override
    public void mostrarDados() {
        System.out.println("\n CPF: "+ this.getCpf()
                + "\n Nome: " + this.getNome()
                + "\n Titulação: "+ this.getTitulacao()
                + "\n Matrícula: " + this.getMatricula());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(matricula, professor.matricula) && Objects.equals(titulacao, professor.titulacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), matricula, titulacao);
    }

    public Professor(String cpf, String nome, String matricula, String titulacao) {
        super(cpf, nome);
        this.matricula = matricula;
        this.titulacao = titulacao;
    }

    public Professor(String cpf, String nome) {
        super(cpf, nome);
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }


}
