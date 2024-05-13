package Service;

import javax.swing.JOptionPane;
import BBDD.Conexion;
import lib.Escuderia;

public class BorrarEscuderiaService {
	public boolean checkDelete(Escuderia escuderia) {
		
		String sql = ("DELETE FROM escuderia WHERE nombreEscuderia = '"+escuderia.getNombreEscuderia()+"'");
		
		if(Conexion.EjecutarDeleteEscuderia(sql)) {
			JOptionPane.showMessageDialog(null, "Escuderia eliminada");
			return true;
		}else {
			return false;
		}
}
}
