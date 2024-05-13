package Service;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BBDD.Conexion;
import lib.Escuderia;
import lib.Piloto;

public class ActualizarPilotoService {
	public Boolean checkUpdate(Piloto piloto, Escuderia escuderia, String nombreAntiguoPiloto) {
		String sql = ("UPDATE piloto SET nombrePiloto = '" +piloto.getNombre() +"', escuderia = '"+escuderia.getNombreEscuderia() +"', dorsal = '" +piloto.getDorsal() +"' WHERE nombrePiloto = '" +nombreAntiguoPiloto +"';");
		if(Conexion.EjecutarUpdatePiloto(sql)) {
			JOptionPane.showMessageDialog(null, "Piloto actualizado");
			return true;
		}else {
			return false;
		}
		
	}
}
