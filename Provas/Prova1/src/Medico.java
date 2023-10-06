import java.util.Objects;

public class Medico extends Pessoa{
    private String numCRM;
    private String especialidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medico medico = (Medico) o;
        return Objects.equals(numCRM, medico.numCRM) && Objects.equals(especialidade, medico.especialidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numCRM, especialidade);
    }

    public Medico(String cpf, String nome, String numCRM, String especialidade) {
        super(cpf, nome);
        this.numCRM = numCRM;
        this.especialidade = especialidade;
    }

    public String getNumCRM() {
        return numCRM;
    }

    public void setNumCRM(String numCRM) {
        this.numCRM = numCRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nCPF:" + this.getCpf()
                            + "\nNome: " + this.getNome()
                            + "\nCRM: " + this.getNumCRM()
                            + "\nEspecialidade:" + this.getEspecialidade());
    }
}
