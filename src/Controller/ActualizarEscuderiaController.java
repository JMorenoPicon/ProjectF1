package Controller;
import Service.*;
import lib.*;
public class ActualizarEscuderiaController {
	
	private ActualizarEscuderiaService actualizarEscuderiaService;
	
	public ActualizarEscuderiaController() {
		actualizarEscuderiaService = new ActualizarEscuderiaService();
	}
	
	public boolean actualizarEscuderia(Escuderia escuderia, String nombreAntiguoEscuderia) {
		return actualizarEscuderiaService.checkUpdate(escuderia, nombreAntiguoEscuderia);
	}
}
