package Service;
import javax.swing.JOptionPane;
import BBDD.Conexion;
import lib.Circuito;


public class CrearCircuitoService {
	public boolean checkRegistro(Circuito circuito) {
		if(circuito.getNombre().isBlank() || circuito.getPais().isBlank()) {
			JOptionPane.showMessageDialog(null, "Registro fallido. Rellene todos los campos necesarios");
		}else if(circuito.getNumeroVueltas() == 0) {
			JOptionPane.showMessageDialog(null, "Registro fallido. El nº de vueltas debe ser mayor a cero");
		}else {
			String sql = "INSERT INTO circuito (nombreCircuito, paisCircuito, numeroVueltas) VALUES ('" +circuito.getNombre() +"', '" +circuito.getPais() +"', '"+circuito.getNumeroVueltas() +"');";
			return Conexion.EjecutarInsertCircuito(sql);
		}
		return false;
	}
	
	public boolean checkVueltas(String vueltas) {
		try{
			int vueltasInt = Integer.parseInt(vueltas);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
