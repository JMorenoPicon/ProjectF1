package Controller;
import java.util.ArrayList;

import Service.*;
import lib.*;

public class VerPilotosController {
	
	/*Codigo para ver los pilotos*/
	
	private VerPilotosNombreService verPilotosNombreService;
	
	public VerPilotosController() {
		verPilotosNombreService = new VerPilotosNombreService();
	}
	
	public ArrayList<String> verNombrePilotos() {
		return verPilotosNombreService.verNombrePilotos();
	}
}
