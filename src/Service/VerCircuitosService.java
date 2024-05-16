package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BBDD.Conexion;
import lib.Circuito;

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
		}finally {
//			Conexion.CerrarConexion();
		}
	}
	
	public ArrayList<Circuito> verAllCircuitos(){
		try {
			String sql = ("SELECT * FROM circuito;");
			ResultSet res = Conexion.EjecutarSentencia(sql);
			ArrayList<Circuito> arrayDatosCircuitos = new ArrayList<Circuito>();
			while(res.next()) {
				String nombre = res.getString("nombreCircuito");
				String pais = res.getString("paisCircuito");
				int vueltas = res.getInt("numeroVueltas");
				
				Circuito circuito = new Circuito(nombre, pais, vueltas);
				arrayDatosCircuitos.add(circuito);
			}
			return arrayDatosCircuitos;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			ArrayList<Circuito> arrayVacia = new ArrayList<Circuito>();
			return arrayVacia;
		}finally {
//			Conexion.CerrarConexion();
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
		}finally {
//			Conexion.CerrarConexion();
		}
	}
}
