package lógico;

import java.util.ArrayList;
import java.util.Date;


public class Clinica {
	private String nombre;
	private String direccion;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Cita> citas;
	private ArrayList<Consulta> consultas;
	private ArrayList<Historial> historiales;
	private ArrayList<User> usuarios;

	private ArrayList<Vacuna> vacunasPuestas;
	private ArrayList<String> especialidades;
	private ArrayList<VacunaDisponible> vacunasDisponibles;
	

	public static int idMedico;
	public static int idCita;
	public static int idPaciente;
	public static int idConsulta;

	private static Clinica estado;

	private Clinica(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.pacientes = new ArrayList<>();
		this.medicos = new ArrayList<>();
		this.citas = new ArrayList<>();
		this.consultas = new ArrayList<>();
		this.vacunasDisponibles = new ArrayList<>();
		this.vacunasPuestas = new ArrayList<>();
		this.especialidades = new ArrayList<>();
		this.setHistoriales(new ArrayList<>());
		this.usuarios = new ArrayList<>();

		idMedico = 0;
		idCita = 0;
		idPaciente = 0;
		idConsulta = 0;
	}
	
	public static Clinica getInstance() {
		if (estado == null) {
			estado = new Clinica("Homs", "Autop. Juan Pablo Duarte Km. 28, Santiago de los Caballeros 51000");
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
	}

	public Medico buscarMedicoPorCedula(String cedula) {
		for (Medico medico : medicos) {
			if (medico.getCedula().equals(cedula)) {
				return medico;
			}
		}
		return null;
	}

	public Medico buscarDoctorById(String doctorId) {
		for (Medico doctor : medicos) {
			if (doctor.getCodigoMedico().equalsIgnoreCase(doctorId)) {
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

	public void registrarVacunaDisponible(VacunaDisponible vacuna) {
		for(VacunaDisponible temp : vacunasDisponibles) {
			if(vacuna.equals(temp))
				return;
		}
		vacunasDisponibles.add(vacuna);
	}

	public String generarReporteGeneral() {
		StringBuilder reporte = new StringBuilder();
		reporte.append("Reporte General\n");
		reporte.append("Total de Pacientes: ").append(pacientes.size()).append("\n");
		reporte.append("Total de Médicos: ").append(medicos.size()).append("\n");
		reporte.append("Total de Citas: ").append(citas.size()).append("\n");
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

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	public ArrayList<Cita> getCitas() {
		return citas;
	}
	
	public ArrayList<Consulta> getConsultas() {
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
	
	public ArrayList<VacunaDisponible> getVacunasDisponibles() {
		return vacunasDisponibles;
	}

	public void setVacunasDisponibles(ArrayList<VacunaDisponible> vacunasDisponibles) {
		this.vacunasDisponibles = vacunasDisponibles;
	}
	
	public ArrayList<Vacuna> getVacunasPuestas() {
		return vacunasPuestas;
	}

	public void setVacunasPuestas(ArrayList<Vacuna> vacunasPuestas) {
		this.vacunasPuestas = vacunasPuestas;
	}

	public static int getIdMedico() {
		return idMedico;
	}

	public static int getIdCita() {
		return idCita;
	}

	public static int getIdPaciente() {
		return idPaciente;
	}

	public static int getIdConsulta() {
		return idConsulta;
	}

	public static Clinica getEstado() {
		return estado;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}

	public void setCitas(ArrayList<Cita> citas) {
		this.citas = citas;
	}

	public void setConsultas(ArrayList<Consulta> consultas) {
		this.consultas = consultas;
	}

	public ArrayList<Historial> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(ArrayList<Historial> historiales) {
		this.historiales = historiales;
	}

	/**
	 * @return the usuarios
	 */
	public ArrayList<User> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(ArrayList<User> usuarios) {
		this.usuarios = usuarios;
	}
	
}
