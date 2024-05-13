package Service;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BBDD.*;
import lib.*;

public class VerPilotosService {
	public ArrayList<String> verNombrePilotos() {
		try {
			String sql = ("SELECT nombrePiloto FROM piloto;");
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
	
	public ArrayList<String> verDatosPiloto(Piloto piloto){
		try {
			String sql = ("SELECT * FROM piloto WHERE nombrePiloto = '" +piloto.getNombre() +"';");
			ResultSet res = Conexion.EjecutarSentencia(sql);
			ArrayList<String> arrayDatosPiloto = new ArrayList<String>();
			while(res.next()) {
				arrayDatosPiloto.add(res.getString("nombrePiloto"));
				int dorsalInt = res.getInt("dorsal");
				String dorsalString = Integer.toString(dorsalInt);
				arrayDatosPiloto.add(dorsalString);
			}
			return arrayDatosPiloto;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			ArrayList<String> arrayVacia = new ArrayList<String>();
			return arrayVacia;
		}
	}
}
