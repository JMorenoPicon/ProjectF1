import BBDD.*;
import Views.*;

public class Main {

	public static void main(String[] args) {
		
		Conexion.Conectar();
		
		new pantallaInicioJF().setVisible(true);
	}

}
