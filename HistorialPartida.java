import java.io.Serializable;
import java.util.Date;

public class HistorialPartida implements Serializable{
    private String jugador;
    private boolean gano;
    private int puntaje;
    private String dificultad;
    private int tiempo;
    private int vidasFinales;
    private Date fecha;

    public HistorialPartida() {}

    public HistorialPartida(String jugador, boolean gano, int puntaje, String dificultad, int tiempo, int vidasFinales) {
        this.jugador = jugador;
        this.gano = gano;
        this.puntaje = puntaje;
        this.dificultad = dificultad;
        this.tiempo = tiempo;
        this.vidasFinales = vidasFinales;
        this.fecha = new Date();
    }

    public String getJugador() { 
        return jugador;
     }
    public boolean isGano() {
         return gano;
         }
    public int getPuntaje() { 
        return puntaje;
     }
    public String getDificultad() { 
        return dificultad; 
    }
    public int getTiempo() { 
        return tiempo; 

    }
    public int getVidasFinales() { 
        return vidasFinales; 
    }
    public Date getFecha() { 
        return fecha; }
    @Override
    public String toString(){
        return ("Jugador: "+jugador+"\nResultado: "+((gano) ? "Victoria" : "Derrota")+"\nPuntaje: "+puntaje+"\nDificultad: "+dificultad+
        "\nTiempo: "+tiempo+"\nVidas Finales: "+vidasFinales+"\nFecha: "+fecha);
    }
}

