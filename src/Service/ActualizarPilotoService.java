package Service;
import javax.swing.JOptionPane;
import BBDD.Conexion;
import lib.Escuderia;
import lib.Piloto;

public class ActualizarPilotoService {
	public boolean checkUpdate(Piloto piloto, Escuderia escuderia, String nombreAntiguoPiloto) {
		if(piloto.getNombre().isBlank()){
			if(escuderia.getNombreEscuderia().equals("Sin escuderia")) {
				String sql = "UPDATE piloto SET escuderia = NULL, dorsal = '" +piloto.getDorsal() +"' WHERE nombrePiloto = '" +nombreAntiguoPiloto +"';";
				if(Conexion.EjecutarUpdatePiloto(sql)) {
					JOptionPane.showMessageDialog(null, "Piloto actualizado");
					return true;
				}else {
					return false;
				}
			}else {
				String sql = "UPDATE piloto SET escuderia = '"+escuderia.getNombreEscuderia() +"', dorsal = '" +piloto.getDorsal() +"' WHERE nombrePiloto = '" +nombreAntiguoPiloto +"';";
				if(Conexion.EjecutarUpdatePiloto(sql)) {
					JOptionPane.showMessageDialog(null, "Piloto actualizado");
					return true;
				}else {
					return false;
				}
			}
		}else {
			if(escuderia.getNombreEscuderia().equals("Sin escuderia")) {
				String sql = "UPDATE piloto SET nombrePiloto = '" +piloto.getNombre() +"', escuderia = null, dorsal = '" +piloto.getDorsal() +"' WHERE nombrePiloto = '" +nombreAntiguoPiloto +"';";
				if(Conexion.EjecutarUpdatePiloto(sql)) {
					JOptionPane.showMessageDialog(null, "Piloto actualizado");
					return true;
				}else {
					return false;
				}
			}else {
				String sql = "UPDATE piloto SET nombrePiloto = '" +piloto.getNombre() +"', escuderia = '"+escuderia.getNombreEscuderia() +"', dorsal = '" +piloto.getDorsal() +"' WHERE nombrePiloto = '" +nombreAntiguoPiloto +"';";
				if(Conexion.EjecutarUpdatePiloto(sql)) {
					JOptionPane.showMessageDialog(null, "Piloto actualizado");
					return true;
				}else {
					return false;
				}
			}
			
		}
				
		
	}
}
