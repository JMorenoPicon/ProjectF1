package Controller;
import lib.*;

import java.sql.SQLException;

import Views.*;
import Service.*;

public class EditorPilotosController {
	
	/*Codigo para crear un piloto*/
	private EditorPilotosService crearPilotoService;
	
	public EditorPilotosController() {
		crearPilotoService = new EditorPilotosService();
	}
	
	public boolean checkRegistro(Piloto piloto) throws SQLException{
		return crearPilotoService.checkRegistro(piloto);
	}
	
	/*Codigo para borrar un piloto*/
	private BorrarPilotoService borrarPilotoService;
	
	public borrarPilotoController() {
		borrarPilotoService = new borrarPilotoService();
	}
	
	public boolean checkDelete(Piloto piloto)throws SQLException{
		return borrarPilotoService.checkDelete(piloto);
	}
}
