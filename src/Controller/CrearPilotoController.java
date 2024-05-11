package Controller;
import lib.*;

import java.sql.SQLException;

import Views.*;
import Service.*;

public class CrearPilotoController {
	private CrearPilotoService crearPilotoService;
	
	public CrearPilotoController() {
		crearPilotoService = new CrearPilotoService();
	}
	
	public boolean checkRegistro(Piloto piloto) throws SQLException{
		return crearPilotoService.checkRegistro(piloto);
	}
}
