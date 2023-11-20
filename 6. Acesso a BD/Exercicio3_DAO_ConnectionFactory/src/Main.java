import data.PartidaDAO;
import data.PartidaSQLiteDAO;
import data.TimeDAO;
import data.TimeSQLiteDAO;
import model.Partida;
import model.Time;

public class Main {
    public static void main(String[] args) {
        Time t1 = new Time(1,"Brasil");
        Time t2 = new Time(2, "Argentina");

        TimeDAO timeDAO = new TimeSQLiteDAO();
        timeDAO.salvar(t1);
        timeDAO.salvar(t2);

        for (Time time: timeDAO.buscarTodos())
             time.mostrarDados();


        Partida partida = new Partida(1,"20/11/2023",
                    t1,t2,0,0);

        PartidaDAO partidaDAO = new PartidaSQLiteDAO();
        partidaDAO.salvar(partida);

        partida.atualizarResultado(1,0);
        partidaDAO.atualizar(partida);

        for(Partida p : partidaDAO.buscarTodos())
            p.mostrarResultado();

    }
}