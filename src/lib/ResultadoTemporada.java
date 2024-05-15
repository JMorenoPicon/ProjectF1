package lib;

import java.util.ArrayList;

public class ResultadoTemporada {
	
	private ArrayList<Piloto> clasificacionFinalPilotos = new ArrayList<Piloto>();
	private ArrayList<Escuderia> clasificacionFinalEscuderias = new ArrayList<Escuderia>();
	
	
	public ResultadoTemporada(ArrayList<Piloto> clasificacionFinalPilotos,
			ArrayList<Escuderia> clasificacionFinalEscuderias) {
		this.clasificacionFinalPilotos = clasificacionFinalPilotos;
		this.clasificacionFinalEscuderias = clasificacionFinalEscuderias;
	}
	
	public ResultadoTemporada(ArrayList<Piloto> clasificacionFinalPilotos) {
		this.clasificacionFinalPilotos = clasificacionFinalPilotos;
	}


	public ArrayList<Piloto> getClasificacionFinalPilotos() {
		return clasificacionFinalPilotos;
	}


	public void setClasificacionFinalPilotos(ArrayList<Piloto> clasificacionFinalPilotos) {
		this.clasificacionFinalPilotos = clasificacionFinalPilotos;
	}


	public ArrayList<Escuderia> getClasificacionFinalEscuderias() {
		return clasificacionFinalEscuderias;
	}


	public void setClasificacionFinalEscuderias(ArrayList<Escuderia> clasificacionFinalEscuderias) {
		this.clasificacionFinalEscuderias = clasificacionFinalEscuderias;
	}
	
	
}
