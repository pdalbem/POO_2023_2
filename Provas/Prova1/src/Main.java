import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Exame exame1 = new Exame("Eletrocardiograma");
        Exame exame2 = new Exame("Colesterol");

        Medicamento medicamento1 = new Medicamento("Dipirona");
        Medicamento medicamento2 = new Medicamento("Sivastatina");

        Secretaria secretaria = new Secretaria("123","Maria","MAT1", 2000);

        Medico medico1 = new Medico("444", "João","CRM1", "Cardiologista");

        Paciente paciente = new Paciente("555", "José", "Rua A, 1");

        Consulta consulta = new Consulta(LocalDate.of(2023,10,5),
                LocalTime.of(14,15), medico1,secretaria,paciente);

        consulta.adicionarExame(exame1,exame2);
        consulta.adicionarMedicamento(medicamento1,medicamento2);

        paciente.adicionarConsulta(consulta);

        paciente.exibirHistoricoConsultas(LocalDate.of(2023,10,1),
                                          LocalDate.of(2023,10,31));


        //medico2 é idêntico à médico1, porém cada um possui seu endereço de memória.
        Medico medico2 = new Medico("444", "João","CRM1", "Cardiologista");
        //o método exibirHistoricoConsultas() vai funcionar
        // por causa da sobrescrita do equals() na classe Medico
        paciente.exibirHistoricoConsultas(medico2);

        // Polimorfismo
        List<Pessoa> lista = new ArrayList<>();
        lista.add(paciente);
        lista.add(secretaria);
        lista.add(medico1);
        for (Pessoa p:lista)
            p.mostrarDados();
    }
}