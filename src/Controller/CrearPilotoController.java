package Controller;
import lib.*;

import java.sql.SQLException;

import Views.*;
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
	
//	/*Codigo para borrar un piloto*/
//	private BorrarPilotoService borrarPilotoService;
//	
//	public BorrarPilotoController() {
//		borrarPilotoService = new borrarPilotoService();
//	}
//	
//	public boolean checkDelete(Piloto piloto)throws SQLException{
//		return borrarPilotoService.checkDelete(piloto);
//	}
}
