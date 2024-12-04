package lógico;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String pasword;
	private String type;
	private Persona vinculado;
	private boolean isAdmint;
	private boolean isMedic;
	private boolean isPaciente;
	
	public User(String nombre, String pasword, String type, Persona vinculado, boolean isAdmint, boolean isMedic,
			boolean isPaciente) {
		super();
		this.nombre = nombre;
		this.pasword = pasword;
		this.type = type;
		this.vinculado = vinculado;
		this.isAdmint = isAdmint;
		this.isMedic = isMedic;
		this.isPaciente = isPaciente;
	}	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAdmint() {
		return isAdmint;
	}
	public void setAdmint(boolean isAdmint) {
		this.isAdmint = isAdmint;
	}
	public boolean isMedic() {
		return isMedic;
	}
	public void setMedic(boolean isMedic) {
		this.isMedic = isMedic;
	}
	public boolean isPaciente() {
		return isPaciente;
	}
	public void setPaciente(boolean isPaciente) {
		this.isPaciente = isPaciente;
	}

	public Persona getVinculado() {
		return vinculado;
	}

	public void setVinculado(Persona vinculado) {
		this.vinculado = vinculado;
	}
	

}
