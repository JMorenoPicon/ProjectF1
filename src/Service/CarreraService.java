package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import BBDD.Conexion;
import lib.Carrera;
import lib.Circuito;
import lib.Escuderia;
import lib.Piloto;
import lib.ResultadoCarrera;

public class CarreraService {

	public ArrayList<Piloto> obtenerPilotos() {
		try {
			String sql = "SELECT * FROM piloto;";
			ResultSet res = Conexion.EjecutarSentencia(sql);
			ArrayList<Piloto> listaPilotos = new ArrayList<Piloto>();
			
			while(res.next()) {
				String nombre = res.getString("nombrePiloto");
				Escuderia escuderiaRes = new Escuderia(res.getString("escuderia"));
				int dorsal = res.getInt("dorsal");
				
				Piloto piloto = new Piloto(nombre, escuderiaRes, dorsal);
				
				listaPilotos.add(piloto);
			}
			return listaPilotos;
		}catch(SQLException e) {
			System.out.println("No funciona carreraService.obtenerPilotos");
			ArrayList<Piloto> listaVacia = new ArrayList<Piloto>();
			return listaVacia;
		}
		
	}

	public ResultadoCarrera correr(ArrayList<Piloto> pilotos, Circuito circuito) {

		Collections.shuffle(pilotos);
		
		for(int i = 0; i < pilotos.size(); i += 1) {
			Piloto piloto = pilotos.get(i);
			if(i == 0) {
				piloto.setPuntos(25);
			}else if(i == 1) {
				piloto.setPuntos(18);
			}else if(i == 2) {
				piloto.setPuntos(15);
			}else if(i == 3) {
				piloto.setPuntos(12);
			}else if(i == 4) {
				piloto.setPuntos(10);
			}else if(i == 5) {
				piloto.setPuntos(8);
			}else if(i == 6) {
				piloto.setPuntos(6);
			}else if(i == 7) {
				piloto.setPuntos(4);
			}else if(i == 8) {
				piloto.setPuntos(2);
			}else if(i == 9) {
				piloto.setPuntos(1);
			}else {
				piloto.setPuntos(0);
			}
		}
					
		
		int posicionPilotoVueltaRapida = (int) (Math.random()*(10 - 1) + 1);
		int puntos = pilotos.get(posicionPilotoVueltaRapida).getPuntos();
		pilotos.get(posicionPilotoVueltaRapida).setPuntos(puntos += 1);
		
		int vueltaRapida = (int) (Math.random()*(circuito.getNumeroVueltas() - 1) + 1);
		
		ResultadoCarrera resultado = new ResultadoCarrera(pilotos, pilotos.get(posicionPilotoVueltaRapida), vueltaRapida);
		
		return resultado;
	}

	public ResultadoCarrera simularCarreraTemporada(Carrera carrera) {
		
		Collections.shuffle(carrera.getPilotos());
		
		for(int i = 0; i < carrera.getPilotos().size(); i += 1) {
			Piloto piloto = carrera.getPilotos().get(i);
			if(i == 0) {
				piloto.setPuntos(25);
			}else if(i == 1) {
				piloto.setPuntos(18);
			}else if(i == 2) {
				piloto.setPuntos(15);
			}else if(i == 3) {
				piloto.setPuntos(12);
			}else if(i == 4) {
				piloto.setPuntos(10);
			}else if(i == 5) {
				piloto.setPuntos(8);
			}else if(i == 6) {
				piloto.setPuntos(6);
			}else if(i == 7) {
				piloto.setPuntos(4);
			}else if(i == 8) {
				piloto.setPuntos(2);
			}else if(i == 9) {
				piloto.setPuntos(1);
			}else {
				piloto.setPuntos(0);
			}
		}
		
		int posicionPilotoVueltaRapida = (int) (Math.random()*(10 - 1) + 1);
		int puntos = carrera.getPilotos().get(posicionPilotoVueltaRapida).getPuntos();
		carrera.getPilotos().get(posicionPilotoVueltaRapida).setPuntos(puntos += 1);
		
		int vueltaRapida = (int) (Math.random()*(carrera.getCircuito().getNumeroVueltas() - 1) + 1);
		
		ResultadoCarrera resultado = new ResultadoCarrera(carrera.getPilotos(), carrera.getPilotos().get(posicionPilotoVueltaRapida), vueltaRapida);
		return resultado;
	}
}

