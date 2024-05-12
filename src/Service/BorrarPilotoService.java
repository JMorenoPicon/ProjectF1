package Service;
import BBDD.*;
import lib.*;

import javax.swing.JOptionPane;

public class BorrarPilotoService {
	public boolean checkDelete(Piloto piloto) {
		
			String sql = ("DELETE FROM piloto WHERE nombrePiloto = '"+piloto.getNombre()+"'");
			
			if(Conexion.EjecutarDeletePiloto(sql)) {
				JOptionPane.showMessageDialog(null, "Piloto eliminado");
				return true;
			}else {
				return false;
			}
	}
}
