package lib;

public class Circuito {
	private String nombre;
    private String pais;
    private int numeroCircuito;
    private int numeroVueltas;
    
    public Circuito(String nombre, String pais, int numeroCircuito, int numeroVueltas, int posicionCalendario) {
        this.nombre = nombre;
        this.pais = pais;
        this.numeroCircuito = numeroCircuito;
        this.numeroVueltas = numeroVueltas;
    }
    
    public Circuito(String nombre, String pais, int numeroVueltas) {
        this.nombre = nombre;
        this.pais = pais;
        this.numeroVueltas = numeroVueltas;
    }
    
    public Circuito(String nombre) {
        this.nombre = nombre;
    }
    
    public Circuito(String nombre, int vueltas) {
        this.nombre = nombre;
        this.numeroVueltas = vueltas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumeroCircuito() {
        return numeroCircuito;
    }

    public void setNumeroCircuito(int numeroCircuito) {
        this.numeroCircuito = numeroCircuito;
    }

    public int getNumeroVueltas() {
		return numeroVueltas;
	}

	public void setNumeroVueltas(int numeroVueltas) {
		this.numeroVueltas = numeroVueltas;
	}
}
