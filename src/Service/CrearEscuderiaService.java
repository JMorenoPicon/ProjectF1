package Service;

import javax.swing.JOptionPane;

import BBDD.Conexion;
import lib.Escuderia;

public class CrearEscuderiaService {
	public boolean checkRegistro(Escuderia escuderia) {
		if(escuderia.getNombreEscuderia().isBlank() || escuderia.getNombreMotor().isBlank()) {
			JOptionPane.showMessageDialog(null, "Registro fallido. Rellene todos los campos necesarios");
		}else {
			String sql = "INSERT INTO escuderia (nombreEscuderia, motor) VALUES ('" +escuderia.getNombreEscuderia() +"', '" +escuderia.getNombreMotor() +"');";
			return Conexion.EjecutarInsertEscuderia(sql);
		}
		return false;
	}
}
