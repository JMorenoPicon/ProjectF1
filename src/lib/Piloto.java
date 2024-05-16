package lib;

public class Piloto {
    private String nombre;
    private Escuderia escuderia;
    private int puntos;
    private Integer dorsal;
    private int posicion;
    private String nombreEscuderia;

    public Piloto(String nombre, Escuderia escuderia, int puntos, int superLicencia, Integer dorsal) {
        this.nombre = nombre;
        this.escuderia = escuderia;
        this.puntos = puntos;
        this.dorsal = dorsal;
    }
    
    public Piloto(String nombre, Integer dorsal) {
    	this.nombre = nombre;
    	this.dorsal = dorsal;
    }
    
    public Piloto(String nombre, Escuderia escuderia, Integer dorsal) {
    	this.nombre = nombre;
    	this.escuderia = escuderia;
    	this.dorsal = dorsal;
    }
    
    public Piloto(String nombre, int puntos, Escuderia escuderia) {
    	this.nombre = nombre;
    	this.puntos = puntos;
    	this.escuderia = escuderia;
    }
    
    public Piloto(String nombre) {
    	this.nombre = nombre;
    }
    
    public Piloto(Escuderia escuderia, int puntos) {
    	this.escuderia = escuderia;
    	this.puntos = puntos;
    }
    
    public Piloto(int posicion, String nombre, String escuderia, int puntos){
    	this.posicion = posicion;
    	this.nombre = nombre;
    	this.nombreEscuderia = escuderia;
    	this.puntos = puntos;
    }

    public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getNombreEscuderia() {
		return nombreEscuderia;
	}

	public void setNombreEscuderia(String nombreEscuderia) {
		this.nombreEscuderia = nombreEscuderia;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Escuderia getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(Escuderia escuderia) {
        this.escuderia = escuderia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Integer getDorsal(){
        return dorsal;
    }

    public void setDorsal(Integer dorsal){
        this.dorsal = dorsal;
    }

    @Override
    public String toString() {
        return nombre + "\t" + puntos + "pts\t" + escuderia.verEscuderiaClasificacionPilotos() +"]" +"\n";
    }
}