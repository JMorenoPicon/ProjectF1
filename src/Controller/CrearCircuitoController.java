package Controller;

import Service.CrearCircuitoService;
import lib.Circuito;

public class CrearCircuitoController {
private CrearCircuitoService crearCircuitoService;
	
	public CrearCircuitoController() {
		crearCircuitoService = new CrearCircuitoService();
	}
	
	public boolean checkRegistro(Circuito circuito) {
		return crearCircuitoService.checkRegistro(circuito);
	}
	
	public boolean checkVueltas(String vueltas) {
		return crearCircuitoService.checkVueltas(vueltas);
	}
}
