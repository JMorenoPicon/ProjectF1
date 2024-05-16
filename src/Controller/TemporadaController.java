package Controller;

import java.util.ArrayList;

import Service.TemporadaService;
import lib.Escuderia;
import lib.Piloto;
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

	public ArrayList<Escuderia> verResultadosEscuderias() {
		return temporadaService.verResultadosEscuderias();
		
	}

	public ArrayList<Piloto> verClasificacionPilotos() {
		return temporadaService.verClasificacionPilotos();
	}

}
