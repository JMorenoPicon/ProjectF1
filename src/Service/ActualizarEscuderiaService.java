package Service;
import javax.swing.JOptionPane;

import BBDD.Conexion;
import lib.Escuderia;

public class ActualizarEscuderiaService {
	public boolean checkUpdate(Escuderia escuderia, String nombreAntiguoEscuderia) {
		String sql = "UPDATE escuderia SET nombreEscuderia = '" +escuderia.getNombreEscuderia() +"', motor = '"+escuderia.getNombreMotor() +"' WHERE nombreEscuderia = '" +nombreAntiguoEscuderia +"';";
		if(Conexion.EjecutarUpdateEscuderia(sql)) {
			JOptionPane.showMessageDialog(null, "Escuderia Actualizada");
			return true;
		}else {
			return false;
		}
	}
}
