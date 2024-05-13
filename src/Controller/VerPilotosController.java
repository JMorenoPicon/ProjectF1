package Controller;
import java.util.ArrayList;

import Service.*;
import lib.*;

public class VerPilotosController {
	
	/*Codigo para ver los pilotos*/
	
	private VerPilotosService verPilotosNombreService;
	
	public VerPilotosController() {
		verPilotosNombreService = new VerPilotosService();
	}
	
	public ArrayList<String> verNombrePilotos() {
		return verPilotosNombreService.verNombrePilotos();
	}
}
