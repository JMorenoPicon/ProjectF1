package Controller;
import Service.*;
import lib.Escuderia;
import lib.Piloto;

public class ActualizarPilotoController {

	//Codigo para actualizar/editar un piloto
	
	private ActualizarPilotoService actualizarPilotoService;
	
	public ActualizarPilotoController() {
		actualizarPilotoService = new ActualizarPilotoService();
	}
	
	public boolean actualizarPiloto(Piloto piloto, Escuderia escuderia, String nombreAntiguoPiloto) {
		return actualizarPilotoService.checkUpdate(piloto, escuderia, nombreAntiguoPiloto);
	}
}
