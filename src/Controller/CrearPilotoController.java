package Controller;
import lib.*;
import Service.*;

public class CrearPilotoController {
	
	/*Codigo para crear un piloto*/
	
	private CrearPilotoService crearPilotoService;
	
	public CrearPilotoController() {
		crearPilotoService = new CrearPilotoService();
	}
	
	public boolean checkRegistro(Piloto piloto){
		return crearPilotoService.checkRegistro(piloto);
	}
	
	public boolean checkDorsal(String dorsal){
		return crearPilotoService.checkDorsal(dorsal);
	}
}
