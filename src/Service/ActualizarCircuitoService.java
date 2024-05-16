package Service;

import BBDD.Conexion;
import lib.Circuito;

public class ActualizarCircuitoService {
	
	public boolean checkUpdate(Circuito circuito, String nombreAntiguoCircuito) {
		if(!circuito.getNombre().isBlank() && !circuito.getPais().isBlank()) {
			String sql = "UPDATE circuito SET nombreCircuito = '" +circuito.getNombre() +"', paisCircuito = '" +circuito.getPais() +"', numeroVueltas = '" +circuito.getNumeroVueltas() +"' WHERE nombreCircuito = '" +nombreAntiguoCircuito +"';";  
			if(Conexion.EjecutarUpdateCircuito(sql)) {
				return true;
			}else {
				return false;
			}
		}else if(!circuito.getNombre().isBlank() && circuito.getPais().isBlank()) {
			String sql = "UPDATE circuito SET nombreCircuito = '" +circuito.getNombre() +"', numeroVueltas = '" +circuito.getNumeroVueltas() +"' WHERE nombreCircuito = '" +nombreAntiguoCircuito +"';";  
			if(Conexion.EjecutarUpdateCircuito(sql)) {
				return true;
			}else {
				return false;
			}
		}else if(circuito.getNombre().isBlank() && !circuito.getPais().isBlank()) {
			String sql = "UPDATE circuito SET paisCircuito = '" +circuito.getPais() +"', numeroVueltas = '" +circuito.getNumeroVueltas() +"' WHERE nombreCircuito = '" +nombreAntiguoCircuito +"';";  
			if(Conexion.EjecutarUpdateCircuito(sql)) {
				return true;
			}else {
				return false;
			}
		}else {
			String sql = "UPDATE circuito SET numeroVueltas = '" +circuito.getNumeroVueltas() +"' WHERE nombreCircuito = '" +nombreAntiguoCircuito +"';";  
			if(Conexion.EjecutarUpdateCircuito(sql)) {
				return true;
			}else {
				return false;
			}
		}
		
	}
}
