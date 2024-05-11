package Service;
import java.sql.SQLException;

import BBDD.Conexion;

public class Insert { //Esto es el update , no el insert, hacer mas tarde para escuderias, pilotos y circuitos

	public boolean insertPiloto(String tabla, int id, int points){
		
		try {
			
			Conexion.Conectar();
			Conexion.EjecutarUpdate("INSERT INTO "+tabla +" (PUNTOS) VALUES (" +points +") WHERE id = '" +id +"';"); //Aqui el where no hay que ponerlo
			
			return true;
			
		}catch(SQLException e){
			
			System.out.println(e.getStackTrace());
			e.getMessage();
			
			return false;
		}
       
	}

}