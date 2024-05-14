package Controller;

import java.util.ArrayList;

import Service.VerCircuitosService;

public class VerCircuitosController {
	
	private VerCircuitosService verCircuitosService;
	
	public VerCircuitosController() {
		verCircuitosService = new VerCircuitosService();
	}
	
	public ArrayList<String> verNombreCircuitos(){
		return verCircuitosService.verNombreCircuitos();
	}
	
	public ArrayList<String> verAllCircuitos(){
		return verCircuitosService.verAllCircuitos();
	}

	public int verVueltasCircuito(String nombreCircuito) {
		
		return verCircuitosService.verVueltasCircuito(nombreCircuito);
	}
}
