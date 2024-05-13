package Controller;
import Service.*;
import lib.Escuderia;

public class BorrarEscuderiaController {
	
	private BorrarEscuderiaService borrarEscuderiaService;
	
	public BorrarEscuderiaController() {
		borrarEscuderiaService = new BorrarEscuderiaService();
	}
	
	public boolean checkDelete(Escuderia escuderia) {
		return borrarEscuderiaService.checkDelete(escuderia);
	}
}
