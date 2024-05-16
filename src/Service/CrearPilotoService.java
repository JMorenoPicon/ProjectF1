package Service;
import BBDD.*;


import lib.*;

import javax.swing.JOptionPane;

public class CrearPilotoService {
	
	public boolean checkRegistro(Piloto piloto){
		if(piloto.getNombre().isBlank()) {
			JOptionPane.showMessageDialog(null, "Registro fallido. Rellene el campo Nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}else{
			String sql = "INSERT INTO piloto (nombrePiloto, dorsal) VALUES ('" +piloto.getNombre() +"', '" +piloto.getDorsal() +"');";
			return Conexion.EjecutarInsertPiloto(sql);
		}
		return false;
		
	}
	
	public boolean checkDorsal(String dorsal) {
		try {
			Integer.parseInt(dorsal);
			return true;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Por favor introduzca un dorsal válido", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}
}
