public class JugadorStats {
    private String nombre;
    private String contrasena;
    private int mejorPuntaje;
    private int partidasJugadas;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int tiempoTotal;

    public JugadorStats() {}

    public JugadorStats(String nombre,String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.mejorPuntaje = 0;
    }

    public String getNombre() { 
        return nombre; 
    }
    public String getContrasena() { 
        return contrasena; 
    }
    public int getMejorPuntaje() { 
        return mejorPuntaje; 
    }
    public int getPartidasJugadas() { 
        return partidasJugadas; 
    }
    public int getPartidasGanadas() { 
        return partidasGanadas; 
    }
    public int getPartidasPerdidas() { 
        return partidasPerdidas; 
    }
    public int getTiempoTotal() { 
        return tiempoTotal;
     }

    public void actualizarEstadisticas(boolean gano, int puntaje, int tiempo) {
        partidasJugadas++;
        tiempoTotal += tiempo;

        if (gano) partidasGanadas++;
        else partidasPerdidas++;

        if (puntaje > mejorPuntaje)
            mejorPuntaje = puntaje;
    }
    @Override
    public String toString(){
        return ("Nombre: "+nombre+"\nMejor Puntaje: "+mejorPuntaje+"\nPartidasJugadas: "+partidasJugadas+"\nPartidas Ganadas: "+partidasGanadas+
        "\nPartidas Perdidas: "+partidasPerdidas+"\nTiempo jugado total: "+tiempoTotal);
    }
}
