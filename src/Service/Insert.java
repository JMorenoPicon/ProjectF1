package Service;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BBDD.Conexion;

public class Insert { //Esto es el update , no el insert, hacer mas tarde para escuderias, pilotos y circuitos

	public boolean insertPiloto(String tabla, int id, int points){
		
	    public static boolean EjecutarInsertPiloto(String Sentencia){
	    	Conexion.Conectar();
	    	try{
	    		consulta.executeUpdate(Sentencia);
	    		System.out.println("Done.");
	    		CerrarConexion();
	    		return true;
	    	}catch(SQLException e){
	    		JOptionPane.showMessageDialog(null, "Dorsal en uso, por favor elija otro");
	    		JOptionPane.showMessageDialog(null, e.getMessage());
	    		CerrarConexion();
	    		return false;
	    	}
	    }

}