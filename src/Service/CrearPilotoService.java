package Service;
import BBDD.*;
import lib.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class CrearPilotoService {
	
	public boolean checkRegistro(Piloto piloto) throws SQLException{
		if(piloto.getNombre().isBlank()) {
			JOptionPane.showMessageDialog(null, "Registro fallido. Rellene el campo Nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else if(piloto.getDorsal().equals(null)) { //Para ver si el dorsal es null o no, he puesto los int de dorsal a Integer
			JOptionPane.showMessageDialog(null, "Registro fallido. Rellene el campo Dorsal", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else{
			String sql = "INSERT INTO piloto (nombrePiloto, dorsal) VALUES ('" +piloto.getNombre() +"', '" +piloto.getDorsal() +"')";
			Conexion.EjecutarUpdate(sql);
			return true;
		}
		return false;
		
	}
}
