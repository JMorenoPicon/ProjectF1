package lib;

public class Escuderia {
	    private String nombreEscuderia;
	    private String nombreMotor;
	    private int puntos;

	    public Escuderia(String nombreEscuderia, String nombreMotor, int puntos, String nacionalidadEscuderia) {
	        this.nombreEscuderia = nombreEscuderia;
	        this.nombreMotor = nombreMotor;
	        this.puntos = puntos;
	    }
	    
	    public Escuderia(String nombreEscuderia) {
	    	this.nombreEscuderia = nombreEscuderia;
	    }

	    public String getNombreEscuderia() {
	        return nombreEscuderia;
	    }

	    public void setNombreEscuderia(String nombreEscuderia) {
	        this.nombreEscuderia = nombreEscuderia;
	    }

	    public String getNombreMotor() {
	        return nombreMotor;
	    }

	    public void setNombreMotor(String nombreMotor) {
	        this.nombreMotor = nombreMotor;
	    }

	    public int getPuntos() {
	        return puntos;
	    }

	    public void setPuntos(int puntos) {
	        this.puntos = puntos;
	    }

	    public String verEscuderiaClasificacionPilotos() {
	        return nombreEscuderia;
	    }

	    @Override
	    public String toString() {
	        return "[ " +nombreEscuderia + "\t" +"\t" +puntos + " pts ]" +"\n";
	    }
}
