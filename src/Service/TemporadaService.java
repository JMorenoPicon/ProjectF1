package Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BBDD.Conexion;
import Controller.CarreraController;
import lib.Carrera;
import lib.Escuderia;
import lib.Piloto;
import lib.ResultadoCarrera;
import lib.ResultadoTemporada;
import lib.Temporada;

public class TemporadaService {
	public boolean checkResetPilotos() {
		String sql = ("UPDATE piloto SET puntos = 0;");
		if(Conexion.EjecutarResetPilotos(sql)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkResetEscuderias() {
		String sql = ("UPDATE escuderia SET puntosEscuderia = 0;");
		if(Conexion.EjecutarResetPilotos(sql)) {
			return true;
		}else {
			return false;
		}
	}

	public ResultadoTemporada simularTemporada(Temporada temporada) {
		
		ArrayList<Piloto> clasificacionPilotosTemporada = new ArrayList<Piloto>();
		ArrayList<Escuderia> clasificacionEscuderiasTemporada = new ArrayList<Escuderia>();
		for(var circuito:temporada.getCircuitos()) {
			Carrera carrera = new Carrera(temporada.getPilotos(), circuito, temporada.getEscuderias());
			CarreraController carreraTemporada = new CarreraController();
			ResultadoCarrera resultadoCarrera = carreraTemporada.simularCarreraTemporada(carrera);
			
			Piloto pilotoVueltaRapida = resultadoCarrera.getPiloto();
			ArrayList<Piloto> clasificacionCarrera = resultadoCarrera.getPilotos();
			int vueltaRapida = resultadoCarrera.getVueltaRapida();
			
			//Escritura de fichero
			Path relativePath = Paths.get("src/Recursos/ResultadoCarreras");
			Path absolutePath = relativePath.toAbsolutePath();
			System.out.println("Current relative path is: " + absolutePath.toString());
			
			String ruta = absolutePath.toString() + "\\" + carrera.getCircuito().getNombre().toString() +".csv";
			Integer posicion = 0;
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
				bw.write("Posicion,Nombre,Escuderia,Puntos");
				
				for(Piloto piloto: clasificacionCarrera) {
					posicion += 1;
					String linea = String.join(";", posicion.toString());
					linea += ";" +piloto.getNombre();
					linea += ";" +piloto.getEscuderia().getNombreEscuderia();
					linea += ";" +piloto.getPuntos();
					
					bw.write(linea +"\n");
				}
				
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Fallo escritura de fichero", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}

			//Fin escritura de fichero
			
			//Insertar puntos de pilotos en BBDD
			for(Piloto piloto : clasificacionCarrera) {
				String sql ="SELECT puntos FROM piloto WHERE nombrePiloto = '" +piloto.getNombre() +"';"; //TODO: Mirar todos los selct y cerrar conexion
				ResultSet res = Conexion.EjecutarSentencia(sql);
				int puntos = 0;
				try {
					while(!res.next()) {
						puntos += res.getInt("puntos");
					}
				}catch(SQLException e) {
					System.out.println(e.getStackTrace());
					JOptionPane.showMessageDialog(null, "Fallo al coger los puntos de la base de datos");
				}
				finally
				{
					Conexion.CerrarConexion();
				}
				
				int puntosActualizados = piloto.getPuntos() + puntos;
				String sql1 = "UPDATE piloto SET puntos = " +puntosActualizados +" WHERE nombrePiloto = '" +piloto.getNombre() +"';";
				Conexion.EjecutarUpdatePuntosPiloto(sql1); //Falla al realizar esta sentencia
			}
		}
		
		ArrayList<Piloto> clasificacionTemporada = new ArrayList<Piloto>();
		String sql2 = "SELECT * FROM piloto order by puntos DESC";
		ResultSet res1 = Conexion.EjecutarSentencia(sql2);
		try{
				while(!res1.next()) {
				String nombre = res1.getString("nombrePiloto");
				Escuderia escuderia = new Escuderia(res1.getString("escuderia"));
				int puntos = res1.getInt("puntos");
				
				Piloto piloto = new Piloto(nombre, puntos, escuderia);
				clasificacionTemporada.add(piloto);
				}
			}catch(SQLException ex) {
				System.out.println(ex.getStackTrace());
				JOptionPane.showMessageDialog(null, "Fallo al coger los pilotos de la base de datos");
			}
			finally
			{
				Conexion.CerrarConexion();
			}
		ResultadoTemporada resultado = new ResultadoTemporada(clasificacionTemporada);
		return resultado;
	}
}
