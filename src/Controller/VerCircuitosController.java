package Controller;

import java.util.ArrayList;

import Service.VerCircuitosService;
import lib.Circuito;

public class VerCircuitosController {
	
	private VerCircuitosService verCircuitosService;
	
	public VerCircuitosController() {
		verCircuitosService = new VerCircuitosService();
	}
	
	public ArrayList<String> verNombreCircuitos(){
		return verCircuitosService.verNombreCircuitos();
	}
	
	public ArrayList<Circuito> verAllCircuitos(){
		return verCircuitosService.verAllCircuitos();
	}

	public int verVueltasCircuito(String nombreCircuito) {
		
		return verCircuitosService.verVueltasCircuito(nombreCircuito);
	}
}
