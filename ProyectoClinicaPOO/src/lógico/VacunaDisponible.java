package lógico;

import java.io.Serializable;

public class VacunaDisponible implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected int minEdad;
	protected int maxEdad;
	
    public VacunaDisponible(String nombre, int minEdad, int maxEdad) {
		super();
		this.nombre = nombre;
		this.minEdad = minEdad;
		this.maxEdad = maxEdad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMinEdad() {
		return minEdad;
	}

	public void setMinEdad(int minEdad) {
		this.minEdad = minEdad;
	}

	public int getMaxEdad() {
		return maxEdad;
	}

	public void setMaxEdad(int maxEdad) {
		this.maxEdad = maxEdad;
	}
    
    
}
