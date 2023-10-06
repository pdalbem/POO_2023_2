import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paciente extends Pessoa{
    private String endereco;
    private List<Consulta> consultaList = new ArrayList<>();

    public void exibirHistoricoConsultas(){
        for (Consulta c: consultaList)
            c.mostrarDados();
    }

    public void exibirHistoricoConsultas(LocalDate dataInicial, LocalDate dataFinal){
        boolean flag = false;
        for (Consulta c: consultaList)
            if (c.getData().isAfter(dataInicial) &&
                c.getData().isBefore(dataFinal))
            {
                c.mostrarDados();
                flag=true;
            }
        if (!flag)
            System.out.println("Não há consultas para o período informado");
    }

    public void exibirHistoricoConsultas(Medico medico){
        boolean flag=false;
        for (Consulta c: consultaList)
            if (c.getMedico().equals(medico)) {
                c.mostrarDados();
                flag=true;
            }
        if (!flag)
            System.out.println("Não há consultas com o médico informado");

    }


    @Override
    public void mostrarDados() {
        System.out.println("\nCPF: "+ getCpf()
                        + "\nNome: " + getNome()
                        + "\nEndereço: " + getEndereco());
        System.out.println("\nConsultas do paciente "+ getNome());
        for (Consulta c: consultaList)
              c.mostrarDados();

    }

    void adicionarConsulta(Consulta...consulta){
        Collections.addAll(consultaList,consulta);
    }

    void removerConsulta(Consulta consulta){
        consultaList.remove(consulta);
    }



    public Paciente(String cpf, String nome, String endereco) {
        super(cpf, nome);
        this.endereco = endereco;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }


}
