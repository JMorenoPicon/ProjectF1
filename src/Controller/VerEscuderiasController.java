package Controller;

import java.util.ArrayList;

import Service.VerEscuderiasService;
import lib.Escuderia;

public class VerEscuderiasController {
	
	private VerEscuderiasService verEscuderiasNombreService;
	
	public VerEscuderiasController() {
		verEscuderiasNombreService = new VerEscuderiasService();
	}
	
	public ArrayList<String> verNombreEscuderias(){
		return verEscuderiasNombreService.verNombreEscuderias();
	}
	
	public ArrayList<Escuderia> verAllEscuderias(){
		return verEscuderiasNombreService.verAllEscuderias();
	}
}
