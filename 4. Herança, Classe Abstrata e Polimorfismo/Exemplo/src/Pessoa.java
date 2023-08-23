import java.util.Objects;

public abstract class Pessoa {
    private String endereco;
    private String telefone;
    private String email;

    //método abstrato. Classes filhas (subclasses) deverão implementá-lo
    public abstract void mostrarDados();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(endereco, pessoa.endereco) && Objects.equals(telefone, pessoa.telefone) && Objects.equals(email, pessoa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco, telefone, email);
    }


    public Pessoa(String endereco, String telefone, String email) {
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
    public Pessoa() {
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
