package Service;

import java.sql.SQLException;

import BBDD.Conexion;

public class Delete {
	
	public boolean deletePiloto(String tabla, int dorsal){
		
		try {
			
			Conexion.Conectar();
			Conexion.EjecutarUpdate("delete from "+tabla+" where dorsal = '"+dorsal+"'");
			
			return true;
			
		}catch(SQLException e){
			
		System.err.println(e.getStackTrace());
		e.getMessage();
		
		return false;
		}
	}
	
public boolean deleteEscuderia(String tabla, String nombreEscuderia){
		
		try {
			
			Conexion.Conectar();
			Conexion.EjecutarUpdate("delete from "+tabla+" where dorsal = '"+nombreEscuderia+"'");
			
			return true;
			
		}catch(SQLException e){
			
		System.err.println(e.getStackTrace());
		e.getMessage();
		
		return false;
		}
	}

public boolean deleteCircuito(String tabla, int numeroCircuito){
	
	try {
		
		Conexion.Conectar();
		Conexion.EjecutarUpdate("delete from "+tabla+" where numeroCircuito = '"+numeroCircuito+"'");
		
		return true;
		
	}catch(SQLException e){
		
		System.err.println(e.getStackTrace());
		e.getMessage();
	
		return false;
		}
	}
}