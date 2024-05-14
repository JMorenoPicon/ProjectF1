package lib;
import java.util.ArrayList;
import BBDD.*;

public class Temporada {
	private ArrayList<Circuito> circuitos;
    private ArrayList<Escuderia> escuderias;
    private ArrayList<Piloto> pilotos;

    public Temporada(ArrayList<Circuito> circuitos, ArrayList<Escuderia> escuderias, ArrayList<Piloto> pilotos) {
        this.circuitos = circuitos;
        this.escuderias = escuderias;
        this.pilotos = pilotos;
    }

	public ArrayList<Circuito> getCircuitos() {
		return circuitos;
	}

	public void setCircuitos(ArrayList<Circuito> circuitos) {
		this.circuitos = circuitos;
	}

	public ArrayList<Escuderia> getEscuderias() {
		return escuderias;
	}

	public void setEscuderias(ArrayList<Escuderia> escuderias) {
		this.escuderias = escuderias;
	}

	public ArrayList<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(ArrayList<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	
}
    
    



	//Tengo que hacer para ver las cualis de pilotos y escuderias
