public class Secretaria extends Pessoa{
    private String matriculaFuncional;
    private double salario;

    public Secretaria(String cpf, String nome, String matriculaFuncional, double salario) {
        super(cpf, nome);
        this.matriculaFuncional = matriculaFuncional;
        this.salario = salario;
    }

    public String getMatriculaFuncional() {
        return matriculaFuncional;
    }

    public void setMatriculaFuncional(String matriculaFuncional) {
        this.matriculaFuncional = matriculaFuncional;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nCPF: " + this.getCpf()
                            + "\nNome: " + this.getNome()
                            + "\nMatrícula: "+ this.getMatriculaFuncional()
                            + "\nSalário:" + this.getSalario());
    }
}
