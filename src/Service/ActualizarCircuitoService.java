package Service;

import BBDD.Conexion;
import lib.Circuito;

public class ActualizarCircuitoService {
	
	public boolean checkUpdate(Circuito circuito, String nombreAntiguoCircuito) {
		String sql = "UPDATE circuito SET nombreCircuito = '" +circuito.getNombre() +"', paisCircuito = '" +circuito.getPais() +"', numeroVueltas = '" +circuito.getNumeroVueltas() +"' WHERE nombreCircuito = '" +nombreAntiguoCircuito +"';";  
	if(Conexion.EjecutarUpdateCircuito(sql)) {
		return true;
	}else {
		return false;
	}
	}
}
