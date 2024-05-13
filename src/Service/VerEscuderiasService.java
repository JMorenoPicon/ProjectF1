package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BBDD.Conexion;

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
		}
	}
}
