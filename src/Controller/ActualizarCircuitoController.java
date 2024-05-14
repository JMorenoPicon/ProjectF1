package Controller;

import Service.ActualizarCircuitoService;
import lib.Circuito;

public class ActualizarCircuitoController {

	private ActualizarCircuitoService actualizarCircuitoService;
	
	public ActualizarCircuitoController() {
		actualizarCircuitoService = new ActualizarCircuitoService();
	}
	
	public boolean actualizarCircuito(Circuito circuito, String nombreAntiguoCircuito) {
		return actualizarCircuitoService.checkUpdate(circuito, nombreAntiguoCircuito);
	}
}
