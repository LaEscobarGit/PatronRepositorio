import java.util.List;

interface InterfaceRepositorio {
    void guardarJugadorNuevo(String nombre, String contrasena);
    void guardarJugador(String nombre, String contrasena, boolean gano, int puntaje, int tiempoPartida);
    JugadorStats obtenerJugador(String nombre);
    List<JugadorStats> obtenerJugadores();
}

interface PartidaRepositorioInterface {
    void guardarPartida(HistorialPartida partida);
    List<HistorialPartida> obtenerHistorial();
}