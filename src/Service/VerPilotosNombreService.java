package Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BBDD.*;
import lib.*;

public class VerPilotosNombreService {
	public ArrayList<String> verNombrePilotos() {
		try {
			String sql = ("SELECT nombrePiloto FROM piloto");
			ResultSet res = Conexion.EjecutarSentencia(sql);
			ArrayList<String> arrayPilotos = new ArrayList<String>();
			while(res.next()) {
				arrayPilotos.add(res.getString("nombrePiloto"));
			}
			return arrayPilotos;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			ArrayList<String> arrayVacia = new ArrayList<String>();
			return arrayVacia;
		}
		
	}
}
