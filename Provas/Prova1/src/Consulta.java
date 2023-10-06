import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consulta implements MostraDados{
    private LocalDate data;
    private LocalTime hora;
    private Medico medico;
    private Secretaria secretaria;
    private Paciente paciente;
    private List<Medicamento> medicamentoList = new ArrayList<>();
    private List<Exame> exameList = new ArrayList<>();

    @Override
    public void mostrarDados() {
        System.out.println("\nData: " + getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        + "\nHora: " + getHora()
                        +"\nMedico: " + getMedico().getNome()
                        + "\nSecretária: " + getSecretaria().getNome()
                        +"\nPaciente: " + getPaciente().getNome());

        System.out.println("\nMedicamentos:");
        for (Medicamento m: medicamentoList)
            System.out.println(m.getNomeMedicamento());

        System.out.println("\nExames: ");
        for (Exame e: exameList)
            System.out.println(e.getNomeExame());

    }




    public void adicionarMedicamento(Medicamento...medicamento){
        Collections.addAll(medicamentoList,medicamento);
    }

    public void removerMedicamento(Medicamento medicamento){
        medicamentoList.remove(medicamento);
    }

    public void adicionarExame(Exame...exame){
        Collections.addAll(exameList,exame);
    }

    public void removerExame(Exame exame){
        exameList.remove(exame);
    }


    public Consulta(LocalDate data, LocalTime hora, Medico medico, Secretaria secretaria, Paciente paciente) {
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.secretaria = secretaria;
        this.paciente = paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    public List<Exame> getExameList() {
        return exameList;
    }

    public void setExameList(List<Exame> exameList) {
        this.exameList = exameList;
    }


}
