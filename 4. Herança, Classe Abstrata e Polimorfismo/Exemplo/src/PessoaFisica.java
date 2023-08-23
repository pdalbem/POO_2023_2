import java.util.Objects;

public  class PessoaFisica extends Pessoa{
    private String cpf;
    private String nome;

    //Implementação do método abstrato mostrarDados()
    @Override
    public void mostrarDados() {
        System.out.println("\n CPF: "+ cpf
                + "\n Nome: "+ nome
                + "\n E-mail: "+ getEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaFisica that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(cpf, that.cpf) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, nome);
    }

    public PessoaFisica(String cpf, String nome, String endereco, String telefone, String email) {
        super(endereco, telefone, email);
        this.nome = nome;
        this.cpf = cpf;
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

    public boolean validarCPF(){
        //código para validar CPF
        return false;
    }


}
