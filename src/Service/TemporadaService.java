package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
				bw.write("Posicion;Nombre;Escuderia;Puntos\n");
				
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
				int puntos = piloto.getPuntos();
				try {
					while(res.next()) {
						puntos += res.getInt("puntos");
					}
				}catch(SQLException e) {
					System.out.println(e.getStackTrace());
					JOptionPane.showMessageDialog(null, "Fallo al coger los puntos de la base de datos");
				}
				finally
				{
//					Conexion.CerrarConexion();
				}
				
				String sql1 = "UPDATE piloto SET puntos = " +puntos +" WHERE nombrePiloto = '" +piloto.getNombre() +"';";
				Conexion.EjecutarUpdatePuntosPiloto(sql1);
			}
		}
		
		String sql2 = "SELECT * FROM piloto order by puntos DESC";
		ResultSet res1 = Conexion.EjecutarSentencia(sql2);
		try{
				while(res1.next()) {
				String nombre = res1.getString("nombrePiloto");
				Escuderia escuderia = new Escuderia(res1.getString("escuderia"));
				int puntos = res1.getInt("puntos");
				
				Piloto piloto = new Piloto(nombre, puntos, escuderia);
				clasificacionPilotosTemporada.add(piloto);
				}
			}catch(SQLException ex) {
				System.out.println(ex.getStackTrace());
				JOptionPane.showMessageDialog(null, "Fallo al coger los pilotos de la base de datos");
			}
			finally
			{
//				Conexion.CerrarConexion();
			}
		ResultadoTemporada resultado = new ResultadoTemporada(clasificacionPilotosTemporada);
		return resultado;
	}

	public ArrayList<Escuderia> verResultadosEscuderias() {
		ArrayList<Piloto> pilotosEscuderias = new ArrayList<Piloto>();
		String sql = "SELECT * FROM piloto";
		ResultSet res = Conexion.EjecutarSentencia(sql);
		try {
			while(res.next()) {
				int puntos = res.getInt("puntos");
				String nombreEscuderia = res.getString("escuderia");
				Escuderia escuderia = new Escuderia(nombreEscuderia);
				Piloto piloto = new Piloto(escuderia, puntos);
				pilotosEscuderias.add(piloto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Piloto piloto : pilotosEscuderias) {
			String sql1 = "UPDATE escuderia SET puntosEscuderia = puntosEscuderia +" +piloto.getPuntos() +" WHERE nombreEscuderia = '" +piloto.getEscuderia().getNombreEscuderia() +"';";
			Conexion.EjecutarUpdatePuntosEscuderia(sql1);
		}
		ArrayList<Escuderia> escuderias = new ArrayList<Escuderia>();
		
		String sql2 = "SELECT * FROM escuderia ORDER BY puntosEscuderia DESC";
		ResultSet res1 = Conexion.EjecutarSentencia(sql2);
		try {
			while(res1.next()) {
				int puntos = res1.getInt("puntosEscuderia");
				String nombre = res1.getString("nombreEscuderia");
				String motor = res1.getString("motor");
				Escuderia escuderia = new Escuderia(nombre, motor, puntos);
				escuderias.add(escuderia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return escuderias;
	}

	public ArrayList<Piloto> verClasificacionPilotos() {
		ArrayList<Piloto> clasificacion = new ArrayList<Piloto>();
		String sql = "SELECT * FROM piloto ORDER BY puntos DESC";
		ResultSet res = Conexion.EjecutarSentencia(sql);
		try {
			while(res.next()) {
				int puntos = res.getInt("puntos");
				String nombreEscuderia = res.getString("escuderia");
				String nombrePiloto = res.getString("nombrePiloto");
				Escuderia escuderia = new Escuderia(nombreEscuderia);
				Piloto piloto = new Piloto(nombrePiloto, puntos, escuderia);
				clasificacion.add(piloto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clasificacion;
	}

	public ArrayList<Piloto> leerCircuito(String nombreCircuito) {
		//TODO: Aqui tengo que hacer el buffered reades para leer el fichero con el nombre del circuito, guardarlo en variables y meterlos a un arraylist de pilotos para devolverlo
		
		ArrayList<Piloto> clasificacionCircuito = new ArrayList<Piloto>();
		
		Path relativePath = Paths.get("src/Recursos/ResultadoCarreras");
		Path absolutePath = relativePath.toAbsolutePath();
		
		String ruta = absolutePath.toString() + "\\" + nombreCircuito +".csv";
		
		try{

            BufferedReader bufferLectura = new BufferedReader(new FileReader(ruta));

            String linea = bufferLectura.readLine();
            int numeroColumnas = linea.split(";").length;

            while ((linea = bufferLectura.readLine()) != null){
                String[] datos = linea.split(";");

                if(datos != null && datos.length == numeroColumnas){
                    Piloto piloto = new Piloto(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]));
                    clasificacionCircuito.add (piloto);
                }

                
            }
            bufferLectura.close();

        }catch (IOException e){
            e.printStackTrace();
        }
		return clasificacionCircuito;
	}
}
