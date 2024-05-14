package lib;
import java.util.ArrayList;

public class Carrera {
	private ArrayList<Piloto> pilotos;
    private Circuito circuito;
    private ArrayList<Escuderia> escuderias;

    public Carrera(ArrayList<Piloto> pilotos, Circuito circuito, ArrayList<Escuderia> escuderias) {
        this.pilotos = pilotos;
        this.circuito = circuito;
        this.escuderias = escuderias;
    }
    
    public Carrera(ArrayList<Piloto> pilotos, Circuito circuito) {
        this.pilotos = pilotos;
        this.circuito = circuito;
    }

    public ArrayList<Piloto> getPilotos() {
		return pilotos;
	}



	public void setPilotos(ArrayList<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

	public ArrayList<Escuderia> getEscuderias() {
		return escuderias;
	}

	public void setEscuderias(ArrayList<Escuderia> escuderias) {
		this.escuderias = escuderias;
	}
    
    
}
