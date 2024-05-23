package Controller;
import java.util.ArrayList;

import Service.*;
import lib.*;

public class VerPilotosController {
	
	private VerPilotosService verPilotosNombreService;
	
	public VerPilotosController() {
		verPilotosNombreService = new VerPilotosService();
	}
	
	public ArrayList<String> verNombrePilotos() {
		return verPilotosNombreService.verNombrePilotos();
	}
	
	public ArrayList<Piloto> verAllPilotos(){
		return verPilotosNombreService.verAllPilotos();
	}

	public ArrayList<Piloto> verAllPilotosTemporada() {
		return verPilotosNombreService.verAllPilotosTemporada();
		
	}
}
