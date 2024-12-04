package lógico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reporte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idHistorial; 
	private Paciente paciente; 
	private ArrayList<String> antecedentesMedicos; 
	private ArrayList<Cita> citasMedicas; 
	private ArrayList<String> diagnosticos; 


	public Reporte(String idHistorial, Paciente paciente) {
		this.idHistorial = idHistorial;
		this.paciente = paciente;
		this.antecedentesMedicos = new ArrayList<>();
		this.citasMedicas = new ArrayList<>();
		this.diagnosticos = new ArrayList<>();
	}


	public void agregarAntecedente(String antecedente) {
		antecedentesMedicos.add(antecedente);
	}

	public void agregarCita(Cita cita) {
		citasMedicas.add(cita);
	}
	
	

	public void agregarDiagnostico(String diagnostico) {
		diagnosticos.add(diagnostico);
	}


	public String getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(String idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<String> getAntecedentesMedicos() {
		return antecedentesMedicos;
	}

	public List<Cita> getCitasMedicas() {
		return citasMedicas;
	}

	public List<String> getDiagnosticos() {
		return diagnosticos;
	}


	public String generarResumen() {
		StringBuilder resumen = new StringBuilder();
		resumen.append("Resumen de Reporte Clínico\n");
		resumen.append("Paciente: ").append(paciente.getNombre()).append(" ").append(paciente.getApellido()).append("\n");
		resumen.append("Cedula: ").append(paciente.getCedula()).append("\n");
		resumen.append("Antecedentes Médicos: ").append(String.join(", ", antecedentesMedicos)).append("\n");
		resumen.append("Diagnósticos: ").append(String.join(", ", diagnosticos)).append("\n");
		resumen.append("Total de Citas: ").append(citasMedicas.size()).append("\n");
		return resumen.toString();
	}
}
