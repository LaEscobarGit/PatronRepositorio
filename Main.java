import java.util.List;
import com.db4o.*;
import com.db4o.query.Query;

public class Main {
    public static void main(String[] args) {
        ObjectContainer db = Db4o.openFile("DatosJugadores.db4o");
        JugadorRepositorio jugadores  = new JugadorRepositorio(db);
        PartidaRepositorio partidas = new PartidaRepositorio(db);

        crear(jugadores, partidas);

        List<JugadorStats> jugadoresStats = jugadores.obtenerJugadores();
        System.out.println("Jugadores");
        for(JugadorStats jugador : jugadoresStats){
            System.out.println("");
            System.out.println(jugador.toString());
        }
        List<HistorialPartida> historial = partidas.obtenerHistorial();
        System.out.println("\nPartidas");
        for(HistorialPartida partida : historial){
            System.out.println("");
            System.out.println(partida.toString());
        }
    }
    public static void crear(JugadorRepositorio jugadores, PartidaRepositorio partidas){
        jugadores.guardarJugadorNuevo("runicrow", "m123");
        jugadores.guardarJugador("runicrow", "m123", true, 1500, 250);
        jugadores.guardarJugadorNuevo("laescobar", "n123");
        jugadores.guardarJugador("laescobar", "n123", false, 1300, 260);

        partidas.guardarPartida(new HistorialPartida("runicrow", true, 1500, "Avanzado", 250, 2));
        partidas.guardarPartida(new HistorialPartida("laescobar", false, 1300, "Avanzado", 260, 1));
    }
}