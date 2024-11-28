package lógico;

import java.util.Date;

public class Cita {
    private int idCita;
    private Persona posiblePaciente;
    private String pacienteID;
    private String doctorID;
    private int prioridad;
    private boolean active;
    private Date fecha; 

    
    public Cita(int idCita, Persona posiblePaciente, String pacienteID, String doctorID, int prioridad, boolean active, Date fecha) {
        this.idCita = idCita;
        this.posiblePaciente = posiblePaciente;
        this.pacienteID = pacienteID;
        this.doctorID = doctorID;
        this.prioridad = prioridad;
        this.active = active;
        this.fecha = fecha;
    }

    public int getIdCita() {
        return idCita;
    }

    public Persona getPosiblePaciente() {
        return posiblePaciente;
    }

    public void setPosiblePaciente(Persona posiblePaciente) {
        this.posiblePaciente = posiblePaciente;
    }

    public String getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(String pacienteID) {
        this.pacienteID = pacienteID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
