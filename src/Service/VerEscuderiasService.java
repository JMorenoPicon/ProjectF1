package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BBDD.Conexion;
import lib.Escuderia;

public class VerEscuderiasService {
	public ArrayList<String> verNombreEscuderias(){
		try {
			String sql = ("SELECT nombreEscuderia FROM escuderia;");
			ResultSet res = Conexion.EjecutarSentencia(sql);
			ArrayList<String> arrayEscuderias = new ArrayList<String>();
			while(res.next()) {
				arrayEscuderias.add(res.getString("nombreEscuderia"));
			}
			return arrayEscuderias;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			ArrayList<String> arrayVacia = new ArrayList<String>();
			return arrayVacia;
		}finally {
//			Conexion.CerrarConexion();
		}
	}
	
	public ArrayList<Escuderia> verAllEscuderias(){
		try {
			String sql = ("SELECT * FROM escuderia;");
			ResultSet res = Conexion.EjecutarSentencia(sql);
			ArrayList<Escuderia> arrayDatosEscuderias = new ArrayList<Escuderia>();
			while(res.next()) {
				String nombre = res.getString("nombreEscuderia");
				String motor = res.getString("motor");
				Escuderia escuderia = new Escuderia(nombre, motor);
				arrayDatosEscuderias.add(escuderia);
			}
			return arrayDatosEscuderias;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			ArrayList<Escuderia> arrayVacia = new ArrayList<Escuderia>();
			return arrayVacia;
		}finally {
//			Conexion.CerrarConexion();
		}
	}
}
