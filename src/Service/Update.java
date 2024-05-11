package Service;

import java.sql.SQLException;

import BBDD.Conexion;

public class Update {
	public boolean updatetPointsPilotos(String tabla, int id, int points){
		
		try {
			Conexion.Conectar();
			Conexion.EjecutarUpdate("INSERT INTO "+tabla +" (puntos) VALUES (" +points +") WHERE dorsal = " +id +";");
			return true;
		}catch(SQLException e){
			System.out.println(e.getStackTrace());
			e.getMessage();
			return false;
		}
      
	}
	
public boolean updatetPointsEscuderias(String tabla, String nombreEscuderia, int points){
		
		try {
			Conexion.Conectar();
			Conexion.EjecutarUpdate("INSERT INTO "+tabla +" (puntosEscuderia) VALUES (" +points +") WHERE nombreEscuderia = '" +nombreEscuderia +"';");
			return true;
		}catch(SQLException e){
			System.out.println(e.getStackTrace());
			e.getMessage();
			return false;
		}
      
	}
}