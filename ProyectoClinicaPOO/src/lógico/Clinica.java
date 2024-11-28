package lógico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clinica {
	private String nombre;
	private String direccion;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Cita> citas;
	private ArrayList<Consulta> consultas;
	private ArrayList<Vacuna> vacunasPuestas;
	private ArrayList<String> especialidades;
	public static int idMedico;
	public static int idCita;
	public static int idPaciente;

	private static Clinica estado;

	private Clinica(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.pacientes = new ArrayList<>();
		this.medicos = new ArrayList<>();
		this.citas = new ArrayList<>();
		this.consultas = new ArrayList<>();
		idMedico = 0;
		idCita = 0;
		idPaciente = 0;
	}

	public static Clinica getInstance(String nombreClinica, String dirClinica) {
		if (estado == null) {
			estado = new Clinica(nombreClinica, dirClinica);
		}
		return estado;
	}

	public void registrarPaciente(Paciente paciente) {
		pacientes.add(paciente);
		idPaciente++;
	}

	public Paciente buscarPacientePorCedula(String cedula) {
		for (Paciente paciente : pacientes) {
			if (paciente.getCedula().equals(cedula)) {
				return paciente;
			}
		}
		return null;
	}

	public void actualizarPaciente(Paciente paciente) {
		Paciente pacienteExistente = buscarPacientePorCedula(paciente.getCedula());
		if (pacienteExistente != null) {
			pacienteExistente.setNombre(paciente.getNombre());
			pacienteExistente.setApellido(paciente.getApellido());
			pacienteExistente.setEdad(paciente.getEdad());
			pacienteExistente.setSexo(paciente.getSexo());
			pacienteExistente.setDireccion(paciente.getDireccion());
			pacienteExistente.setMisVacunas(paciente.getMisVacunas());
			pacienteExistente.setEnfermedades(paciente.getEnfermedades());
			pacienteExistente.setHistoriaClinica(paciente.getHistoriaClinica());
		}
	}

	public void eliminarPaciente(String cedula) {
		Paciente paciente = buscarPacientePorCedula(cedula);
		if (paciente != null) {
			pacientes.remove(paciente);
		}
	}

	public void registrarMedico(Medico medico) {
		medicos.add(medico);
		idMedico++;
		registrarEspecialidad(medico.getEspecialidad());
	}

	private void registrarEspecialidad(String especialidad) {
		for(String temp : especialidades)
		{
			if (temp.equalsIgnoreCase(especialidad))
				return;
		}
		especialidades.add(especialidad);
	}

	public Medico buscarMedicoPorCedula(String cedula) {
		for (Medico medico : medicos) {
			if (medico.getCedula().equalsIgnoreCase(cedula)) {
				return medico;
			}
		}
		return null;
	}

	public Medico buscarDoctorById(String medicoId) {
		for (Medico doctor : medicos) {
			if (doctor.getCodigoMedico().equalsIgnoreCase(medicoId)) {
				return doctor;
			}
		}
		return null;
	}

	public void actualizarMedico(Medico medico) {
		Medico medicoExistente = buscarMedicoPorCedula(medico.getCedula());
		if (medicoExistente != null) {
			medicoExistente.setNombre(medico.getNombre());
			medicoExistente.setApellido(medico.getApellido());
			medicoExistente.setEdad(medico.getEdad());
			medicoExistente.setSexo(medico.getSexo());
			medicoExistente.setDireccion(medico.getDireccion());
			medicoExistente.setEspecialidad(medico.getEspecialidad());
			medicoExistente.setCodigoMedico(medico.getCodigoMedico());
		}
	}

	public void eliminarMedico(String cedula) {
		Medico medico = buscarMedicoPorCedula(cedula);
		if (medico != null) {
			medicos.remove(medico);
		}
		
		eliminarEspecialidad(medico.getEspecialidad());
	}

	private void eliminarEspecialidad(String especialidad) {
		
		for(Medico medico: medicos) {
			if(medico.getEspecialidad().equalsIgnoreCase(especialidad));
			return;
		}
		
		for(String temp : especialidades)
		{
			if (temp.equalsIgnoreCase(especialidad))
				especialidades.remove(especialidad);
		}
		
	}

	public void registrarCita(Cita cita) {
		citas.add(cita);
		idCita++;
	}

	public Cita buscarCitaPorId(int idCita) {
		for (Cita cita : citas) {
			if (cita.getIdCita() == idCita) {
				return cita;
			}
		}
		return null;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void registrarConsulta(Consulta consulta) {
		consultas.add(consulta);
	}

	public void registrarVacuna(Vacuna vacuna) {
		for(Vacuna temp : vacunasPuestas) {
			if(vacuna.equals(temp))
				return;
		}
		vacunasPuestas.add(vacuna);
	}

	public String generarReporteGeneral() {
		StringBuilder reporte = new StringBuilder();
		reporte.append("Reporte General\n");
		reporte.append("Total de Pacientes: ").append(pacientes.size()).append("\n");
		reporte.append("Total de Médicos: ").append(medicos.size()).append("\n");
		reporte.append("Total de Citas: ").append(citas.size()).append("\n");
		reporte.append("Total de Consultas: ").append(consultas.size()).append("\n");
		return reporte.toString();
	}

	public String generarReportePacientes() {
		StringBuilder reporte = new StringBuilder();
		reporte.append("Reporte de Pacientes\n");
		for (Paciente paciente : pacientes) {
			reporte.append("Paciente: ").append(paciente.getNombre()).append(" ").append(paciente.getApellido()).append("\n");
			reporte.append("Cédula: ").append(paciente.getCedula()).append("\n");
			reporte.append("Edad: ").append(paciente.getEdad()).append("\n");
			reporte.append("Dirección: ").append(paciente.getDireccion()).append("\n");
			reporte.append("-----\n");
		}
		return reporte.toString();
	}

	public String generarReporteMedicos() {
		StringBuilder reporte = new StringBuilder();
		reporte.append("Reporte de Médicos\n");
		for (Medico medico : medicos) {
			reporte.append("Médico: ").append(medico.getNombre()).append(" ").append(medico.getApellido()).append("\n");
			reporte.append("Cédula: ").append(medico.getCedula()).append("\n");
			reporte.append("Especialidad: ").append(medico.getEspecialidad()).append("\n");
			reporte.append("Código Médico: ").append(medico.getCodigoMedico()).append("\n");
			reporte.append("-----\n");
		}
		return reporte.toString();
	}

	public Paciente buscarPacienteById(String codigoPaciente) {
		for (Paciente paciente : pacientes) {
			if (paciente.getCodigoPaciente().equals(codigoPaciente)) {
				return paciente; 
			}
		}
		return null; 
	}


	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public ArrayList<String> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(ArrayList<String> especialidades) {
		this.especialidades = especialidades;
	}

	public ArrayList<Vacuna> getVacunas() {
		return vacunasPuestas;
	}

	public void setVacunas(ArrayList<Vacuna> vacunasPuestas) {
		this.vacunasPuestas = vacunasPuestas;
	}
}
