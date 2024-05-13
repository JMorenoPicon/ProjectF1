package Controller;

import lib.Escuderia;
import Service.*;

public class CrearEscuderiaController {
	private CrearEscuderiaService crearEscuderiaService;
	
	public CrearEscuderiaController() {
		crearEscuderiaService = new CrearEscuderiaService();
	}
	
	public boolean checkRegistro(Escuderia escuderia) {
		return crearEscuderiaService.checkRegistro(escuderia);
	}
}
