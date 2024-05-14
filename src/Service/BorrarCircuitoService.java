package Service;

import BBDD.Conexion;
import lib.Circuito;

public class BorrarCircuitoService {
	public boolean checkDelete(Circuito circuito) {
		String sql = "DELETE FROM circuito WHERE nombrecircuito = '"+circuito.getNombre()+"';";
		
		if(Conexion.EjecutarDeleteCircuito(sql)) {
			return true;
		}else {
			return false;
		}
	}
}
