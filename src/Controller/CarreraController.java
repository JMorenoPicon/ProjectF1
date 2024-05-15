package Controller;

import java.util.ArrayList;

import Service.CarreraService;
import lib.Carrera;
import lib.Circuito;
import lib.Piloto;
import lib.ResultadoCarrera;

public class CarreraController {
	private CarreraService carreraService;
	
	public CarreraController() {
		carreraService = new CarreraService();
	}
	
	public ArrayList<Piloto>obtenerPilotos(){
		return carreraService.obtenerPilotos();
	}
	
	public ResultadoCarrera correr(ArrayList<Piloto> pilotos, Circuito circuito) {//Devuelve un objeto que tenga arraylist de pilotos ordenados (clasificacion) y un piloto y un numero de vuelta que sera la vuelta rapida
		return carreraService.correr(pilotos, circuito);
		
	}

	public ResultadoCarrera simularCarreraTemporada(Carrera carrera) {
		return carreraService.simularCarreraTemporada(carrera);
		
	}
}
