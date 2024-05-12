package Controller;
import Service.*;
import lib.*;

public class BorrarPilotoController {
	
	/*Codigo para borrar un piloto*/
	
	private BorrarPilotoService borrarPilotoService;
	
	public BorrarPilotoController() {
		borrarPilotoService = new BorrarPilotoService();
	}
	
	public boolean checkDelete(Piloto piloto){
		return borrarPilotoService.checkDelete(piloto);
	}
}
