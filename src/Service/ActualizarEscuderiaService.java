package Service;
import javax.swing.JOptionPane;

import BBDD.Conexion;
import lib.Escuderia;

public class ActualizarEscuderiaService {
	public boolean checkUpdate(Escuderia escuderia, String nombreAntiguoEscuderia) {
		if(nombreAntiguoEscuderia.equals("Sin escuderia")) {
			JOptionPane.showMessageDialog(null, "Esta escuderia no se puede actualizar", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}else {
			if(!escuderia.getNombreEscuderia().isBlank() && !escuderia.getNombreMotor().isBlank()) {
				String sql = "UPDATE escuderia SET nombreEscuderia = '" +escuderia.getNombreEscuderia() +"', motor = '"+escuderia.getNombreMotor() +"' WHERE nombreEscuderia = '" +nombreAntiguoEscuderia +"';";
				if(Conexion.EjecutarUpdateEscuderia(sql)) {
					JOptionPane.showMessageDialog(null, "Escuderia Actualizada");
					return true;
				}else {
					return false;
				}
			}else if(!escuderia.getNombreEscuderia().isBlank() && escuderia.getNombreMotor().isBlank()) {
				String sql = "UPDATE escuderia SET nombreEscuderia = '" +escuderia.getNombreEscuderia() +"' WHERE nombreEscuderia = '" +nombreAntiguoEscuderia +"';";
				if(Conexion.EjecutarUpdateEscuderia(sql)) {
					JOptionPane.showMessageDialog(null, "Escuderia Actualizada");
					return true;
				}else {
					return false;
				}
			}else if(escuderia.getNombreEscuderia().isBlank() && !escuderia.getNombreMotor().isBlank()) {
				String sql = "UPDATE escuderia SET motor = '"+escuderia.getNombreMotor() +"' WHERE nombreEscuderia = '" +nombreAntiguoEscuderia +"';";
				if(Conexion.EjecutarUpdateEscuderia(sql)) {
					JOptionPane.showMessageDialog(null, "Escuderia Actualizada");
					return true;
				}else {
					return false;
				}
				
			}else {
				return true;
			}
		}
	}
}
