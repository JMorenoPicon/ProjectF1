package Controller;
import Service.*;
import lib.*;

public class BorrarPilotoController {
	
	private BorrarPilotoService borrarPilotoService;
	
	public BorrarPilotoController() {
		borrarPilotoService = new BorrarPilotoService();
	}
	
	public boolean checkDelete(Piloto piloto){
		return borrarPilotoService.checkDelete(piloto);
	}
}
