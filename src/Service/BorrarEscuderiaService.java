package Service;

import javax.swing.JOptionPane;
import BBDD.Conexion;
import lib.Escuderia;

public class BorrarEscuderiaService {
	public boolean checkDelete(Escuderia escuderia) {

		if (escuderia.getNombreEscuderia().equals("Sin escuderia")) {
			JOptionPane.showMessageDialog(null, "Esta escuderia no puede editarse");
			return false;
		} else {
			String sql = ("DELETE FROM escuderia WHERE nombreEscuderia = '" + escuderia.getNombreEscuderia() + "'");

			if (Conexion.EjecutarDeleteEscuderia(sql)) {
				JOptionPane.showMessageDialog(null, "Escuderia eliminada");
				return true;
			} else {
				return false;
			}
		}
	}
}
