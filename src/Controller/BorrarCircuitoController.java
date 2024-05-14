package Controller;

import lib.Circuito;
import Service.BorrarCircuitoService;

public class BorrarCircuitoController {
	
	private BorrarCircuitoService borrarCircuitoService;
	
	public BorrarCircuitoController() {
		borrarCircuitoService = new BorrarCircuitoService();
	}
	
	public boolean checkDelete (Circuito circuito) {
		return borrarCircuitoService.checkDelete(circuito);
	}
}
