package lógico;

import java.util.Date;

public class Consulta {
	private int idConsulta;
	private Paciente paciente;        
	private Medico medico;            
	private Date fecha;               
	private String diagnostico;       
	private Enfermedad enfermedad;    
	private String tratamiento;       
	private boolean tratado;          
	private boolean importante;       

	
	public Consulta(int idConsulta,Paciente paciente, Medico medico, Date fecha, String diagnostico, 
			Enfermedad enfermedad, String tratamiento, boolean tratado, boolean importante) {
		this.idConsulta = idConsulta;
		this.paciente = paciente;
		this.medico = medico;
		this.fecha = fecha;
		this.diagnostico = diagnostico;
		this.enfermedad = enfermedad;
		this.tratamiento = tratamiento;
		this.tratado = tratado;
		this.importante = importante;
	}

	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public boolean isTratado() {
		return tratado;
	}

	public void setTratado(boolean tratado) {
		this.tratado = tratado;
	}

	public boolean isImportante() {
		return importante;
	}

	public void setImportante(boolean importante) {
		this.importante = importante;
	}

	
	public String generarResumen() {
		StringBuilder resumen = new StringBuilder();
		resumen.append("Resumen de Consulta\n");
		resumen.append("Paciente: ").append(paciente.getNombre()).append(" ").append(paciente.getApellido()).append("\n");
		resumen.append("Médico: ").append(medico.getNombre()).append(" ").append(medico.getApellido()).append("\n");
		resumen.append("Fecha: ").append(fecha).append("\n");
		resumen.append("Diagnóstico: ").append(diagnostico).append("\n");
		resumen.append("Enfermedad: ").append(enfermedad.getNombre()).append("\n");
		resumen.append("Tratamiento: ").append(tratamiento).append("\n");
		resumen.append("Tratado: ").append(tratado ? "Sí" : "No").append("\n");
		resumen.append("Importante: ").append(importante ? "Sí" : "No").append("\n");
		return resumen.toString();
	}


	public int getIdConsulta() {
		return idConsulta;
	}


	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
}
