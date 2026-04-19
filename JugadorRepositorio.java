import com.db4o.*;
import com.db4o.query.Query;
import java.util.List;

public class JugadorRepositorio implements InterfaceRepositorio {
    private ObjectContainer db;

    public JugadorRepositorio(ObjectContainer db) {
        this.db = db;
    }

    @Override
    public void guardarJugadorNuevo(String nombre, String contrasena) {
        JugadorStats jugador = obtenerJugador(nombre);

        if (jugador == null) {
            jugador = new JugadorStats(nombre, contrasena);
        }

        db.store(jugador);
        db.commit();
    }
    @Override
    public void guardarJugador(String nombre, String contrasena, boolean gano, int puntaje, int tiempoPartida) {
        JugadorStats jugador = obtenerJugador(nombre);

        if (jugador == null) {
            jugador = new JugadorStats(nombre, contrasena);
        }

        jugador.actualizarEstadisticas(gano, puntaje, tiempoPartida);

        db.store(jugador);
        db.commit();
    }
    @Override
    public JugadorStats obtenerJugador(String nombre) {
        Query q = db.query();
        q.constrain(JugadorStats.class);
        q.descend("nombre").constrain(nombre);

        List<JugadorStats> lista = q.execute();
        return lista.isEmpty() ? null : lista.get(0);
    }
    @Override
    public List<JugadorStats> obtenerJugadores() {
        return db.query(JugadorStats.class);
    }
}