package lib;

import java.util.ArrayList;

public class ResultadoCarrera {
	ArrayList<Piloto> pilotos;
	Piloto pilotoVueltaRapida;
	int vueltaRapida;
	
	public ResultadoCarrera(ArrayList<Piloto> pilotos, Piloto pilotoVueltaRapida, int vueltaRapida) {
		this.pilotos = pilotos;
		this.pilotoVueltaRapida = pilotoVueltaRapida;
		this.vueltaRapida = vueltaRapida;
	}

	public ArrayList<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(ArrayList<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	public Piloto getPiloto() {
		return pilotoVueltaRapida;
	}

	public void setPiloto(Piloto pilotoVueltaRapida) {
		this.pilotoVueltaRapida = pilotoVueltaRapida;
	}

	public int getVueltaRapida() {
		return vueltaRapida;
	}

	public void setVueltaRapida(int vueltaRapida) {
		this.vueltaRapida = vueltaRapida;
	}
	
	
	
	
}
