package Controller;

import java.util.ArrayList;

import Service.VerEscuderiasService;

public class VerEscuderiasController {
	
	/*Codigo para ver las escuderias*/
	
	private VerEscuderiasService verEscuderiasNombreService;
	
	public VerEscuderiasController() {
		verEscuderiasNombreService = new VerEscuderiasService();
	}
	
	public ArrayList<String> verNombreEscuderias(){
		return verEscuderiasNombreService.verNombreEscuderias();
	}
}
