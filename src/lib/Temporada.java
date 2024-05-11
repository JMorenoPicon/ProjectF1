package lib;
import java.util.ArrayList;
import BBDD.*;

public class Temporada {
	private ArrayList<Carrera> carreras;
    private ArrayList<Escuderia> clasificacionEscuderias;
    private ArrayList<Piloto> clasificacionPilotos;

    public Temporada(ArrayList<Carrera> carreras, ArrayList<Escuderia> clasificacionEscuderias, ArrayList<Piloto> clasificacionPilotos) {
        this.carreras = carreras;
        this.clasificacionEscuderias = clasificacionEscuderias;
        this.clasificacionPilotos = clasificacionPilotos;
    }

    public ArrayList<Carrera> getCarreras() {
		return carreras;
	}



	public void setCarreras(ArrayList<Carrera> carreras) {
		this.carreras = carreras;
	}



	public ArrayList<Escuderia> getClasificacionEscuderias() {
		return clasificacionEscuderias;
	}



	public void setClasificacionEscuderias(ArrayList<Escuderia> clasificacionEscuderias) {
		this.clasificacionEscuderias = clasificacionEscuderias;
	}



	public ArrayList<Piloto> getClasificacionPilotos() {
		return clasificacionPilotos;
	}



	public void setClasificacionPilotos(ArrayList<Piloto> clasificacionPilotos) {
		this.clasificacionPilotos = clasificacionPilotos;
	}
}



	//Tengo que hacer para ver las cualis de pilotos y escuderias
