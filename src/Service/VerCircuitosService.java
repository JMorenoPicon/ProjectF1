package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BBDD.Conexion;

public class VerCircuitosService {

	public ArrayList<String> verNombreCircuitos(){
		try {
			String sql = ("SELECT nombreCircuito FROM circuito");
			ResultSet res = Conexion.EjecutarSentencia(sql);
			ArrayList<String> arrayCircuitos = new ArrayList<String>();
			while(res.next()) {
				arrayCircuitos.add(res.getString("nombreCircuito"));
			}
			return arrayCircuitos;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			ArrayList<String> arrayVacia = new ArrayList<String>();
			return arrayVacia;
		}
	}
	
	public ArrayList<String> verAllCircuitos(){
		try {
			String sql = ("SELECT * FROM circuito;");
			ResultSet res = Conexion.EjecutarSentencia(sql);
			ArrayList<String> arrayDatosCircuitos = new ArrayList<String>();
			while(res.next()) {
				arrayDatosCircuitos.add(res.getString("nombreCircuito") +"\t"+"Pais: "+res.getString("paisCircuito") +"\t" +"Nº Vueltas: " +res.getString("numeroVueltas"));
				arrayDatosCircuitos.add("\n");
			}
			return arrayDatosCircuitos;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			ArrayList<String> arrayVacia = new ArrayList<String>();
			return arrayVacia;
		}
	}

	public int verVueltasCircuito(String nombreCircuito) {
		try {
			String sql = ("SELECT * FROM circuito WHERE nombreCircuito = '" +nombreCircuito +"';");
			ResultSet res = Conexion.EjecutarSentencia(sql);
			int vueltas = -1;
			while(res.next()) {
				vueltas = res.getInt("numeroVueltas");
			}
			return vueltas;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			return -1;
		}
	}
}
