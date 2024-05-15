package Controller;

import Service.TemporadaService;
import lib.ResultadoTemporada;
import lib.Temporada;

public class TemporadaController {
	
	private TemporadaService temporadaService;
	
	public TemporadaController() {
		temporadaService = new TemporadaService();
	}

	public boolean resetPuntosPilotos() {
		return temporadaService.checkResetPilotos();	
	}
	
	public boolean resetPuntosEscuderias() {
		return temporadaService.checkResetEscuderias();	
	}

	public ResultadoTemporada simularTemporada(Temporada temporada) {
		return temporadaService.simularTemporada(temporada);
		
	}

}
