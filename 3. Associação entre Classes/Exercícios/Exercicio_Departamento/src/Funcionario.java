public class Funcionario {
    private String nome;
    private String cpf;
    private double salario;
    private Departamento departamento;

    public void mostrarDados(){
        System.out.println("\n Nome: " + this.nome
                          + "\n CPF: " + this.cpf
                          + "\n Salário: " + this.salario
                          + "\n Departamento: " + this.departamento.getNome() );
    }

    public Funcionario(String nome, String cpf, double salario, Departamento departamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
