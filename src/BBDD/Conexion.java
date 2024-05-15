package BBDD;
import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author_Javier_Moreno
 */
public class Conexion {
	
	static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String dbName = "f1";
	static String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
	static String user = "root";
	static String pass = "";
	static String driver = "com.mysql.cj.jdbc.Driver";
    
    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;
    
    public static void Conectar(){
    	try {
           Class.forName(driver) ;
           conexion = DriverManager.getConnection(url, user, pass);
           System.out.println("Base de datos conectada.");
           //System.out.println("Base de datos clientes.fdb situada en :\n "+url);
           consulta = conexion.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    
	public static ResultSet EjecutarSentencia(String Sentencia){
    	Conectar();
        try {
        	resultado = consulta.executeQuery(Sentencia);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return resultado;
    }
      
    public static boolean EjecutarInsertPiloto(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, "Dorsal en uso, por favor elija otro");
//    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarInsertEscuderia(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, "Escuderia ya existente, por favor elija otro nombre para tu escuderia");
//    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarInsertCircuito(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, "Circuito ya existente, por favor elija otro nombre para tu circuito");
//    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarDeletePiloto(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarDeleteEscuderia(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarDeleteCircuito(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarUpdatePiloto(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLIntegrityConstraintViolationException e){
    		JOptionPane.showMessageDialog(null, "Dorsal en uso, por favor elija otro");
    		CerrarConexion();
    		return false;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarUpdateEscuderia(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLIntegrityConstraintViolationException e){
    		JOptionPane.showMessageDialog(null, "Escuderia ya existente, por favor elija otro nombre");
    		CerrarConexion();
    		return false;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarUpdateCircuito(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		System.out.println(e.getStackTrace());;
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarUpdatePuntosPiloto(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		JOptionPane.showMessageDialog(null, "Fallo insercion puntos en piloto");
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarResetPilotos(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static boolean EjecutarResetEscuderias(String Sentencia){
    	Conectar();
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    		CerrarConexion();
    		return true;
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		CerrarConexion();
    		return false;
    	}
    }
    
    public static void CerrarConexion(){
        try{
        	consulta.close();
        	System.out.println("Base de datos desconectada.");
        }catch(Exception e){}
    }
    
}
