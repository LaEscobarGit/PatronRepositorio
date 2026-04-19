import com.db4o.*;
import java.util.ArrayList;
import java.util.List;

public class PartidaRepositorio implements PartidaRepositorioInterface {
    private ObjectContainer db;

    public PartidaRepositorio(ObjectContainer db) {
        this.db = db;
    }

    @Override
    public void guardarPartida(HistorialPartida partida) {
        db.store(partida);
        db.commit();
        System.out.println("Partida registrada de: " + partida.getJugador());
    }
    @Override
    public List<HistorialPartida> obtenerHistorial() {
        ObjectSet<HistorialPartida> res = db.query(HistorialPartida.class);
        List<HistorialPartida> lista = new ArrayList<>();
        for (HistorialPartida hp : res) {
            lista.add(hp);
        }
        return lista;
    }
}