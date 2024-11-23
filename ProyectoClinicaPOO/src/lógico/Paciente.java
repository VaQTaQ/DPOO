package lógico;

import java.util.ArrayList;

public class Paciente extends Persona{
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Enfermedad> enfermedades;
	private Reporte historiaClinica;
	
	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}
	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	public ArrayList<Enfermedad> getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}
	public Reporte getHistoriaClinica() {
		return historiaClinica;
	}
	public void setHistoriaClinica(Reporte historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
}
