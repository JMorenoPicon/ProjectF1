package Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import BBDD.Conexion;

public class Select {
	
	public void selectAllPiloto(){
		
		try {
			Conexion.Conectar();
			ResultSet selectAll = Conexion.EjecutarSentencia("select * from pilotos");
					
			while(selectAll.next()){
	            String nombrePiloto = selectAll.getString("nombrePiloto");
	            String nombreEscuderia= selectAll.getString("nombreEscuderia");
	            int dorsal = selectAll.getInt("dorsal");
	            System.out.println("Nombre: " +nombrePiloto+ "(" +dorsal +"), Escuderia: "+ nombreEscuderia);
			}
		}catch(SQLException e) {
			System.err.println(e.getStackTrace());
			e.getMessage();
		}
	}
	
	public void selectAllEscuderia(){
			
			try {
				Conexion.Conectar();
				ResultSet selectAll = Conexion.EjecutarSentencia("select * from escuderia");
						
				while(selectAll.next()){
		            String nombreEscuderia = selectAll.getString("nombreEscuderia");
		            String motor = selectAll.getString("motor");	            
		            System.out.println("Nombre: " +nombreEscuderia +"Motor: " +motor);
				}
			}catch(SQLException e) {
				System.err.println(e.getStackTrace());
				e.getMessage();
			}
		}
	
	public void selectAllCircuito(){
		
		try {
			Conexion.Conectar();
			ResultSet selectAll = Conexion.EjecutarSentencia("select * from circuito");
					
			while(selectAll.next()){
	            String nombreCircuito = selectAll.getString("nombreCircuito");
	            String pais = selectAll.getString("paisCircuito");
	            int numero = selectAll.getInt("numeroCircuito");
	            int vueltas = selectAll.getInt("numeroVueltas");
	            System.out.println(numero +"Nombre: " +nombreCircuito +"Pais: " +pais +"Vueltas: " +vueltas);
			}
		}catch(SQLException e) {
			System.err.println(e.getStackTrace());
			e.getMessage();
		}
	}
		
	public void verClasificacionPilotos() {
		
		int posicion = 1;
			try {
				Conexion.Conectar();
				ResultSet selectAll = Conexion.EjecutarSentencia("select * from piloto order by puntos DESC");
						
				while(selectAll.next()){
		            String nombrePiloto = selectAll.getString("nombrePiloto");
		            String nombreEscuderia= selectAll.getString("nombreEscuderia");
		            int puntos = selectAll.getInt("puntos");
		            System.out.println(posicion +"Nombre: " +nombrePiloto+ " (" +puntos +") "+ nombreEscuderia);
		            posicion += 1;
				}
			}catch(SQLException e) {
				System.err.println(e.getStackTrace());
				e.getMessage();
			}
		}
	
	public void verClasificacionEscuderias() {
		
		int posicion = 1;
		
		try {
			Conexion.Conectar();
			ResultSet selectAll = Conexion.EjecutarSentencia("select * from escuderia order by puntos DESC");
					
			while(selectAll.next()){
				String nombreEscuderia = selectAll.getString("nombreEscuderia");
	            String motor = selectAll.getString("motor");	
	            int puntos = selectAll.getInt("puntosEscuderia");
	            System.out.println(posicion +"Nombre: " +nombreEscuderia +"Motor: " +motor +" " +puntos);
	            posicion += 1;
			}
		}catch(SQLException e) {
			System.err.println(e.getStackTrace());
			e.getMessage();
		}
	}
}