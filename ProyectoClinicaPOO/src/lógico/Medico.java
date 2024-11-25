package lógico;

import java.util.List;
import java.util.ArrayList;

public class Medico extends Persona {
    private String especialidad;
    private String codigoMedico;
    private ArrayList<Consulta> consultas;

    public Medico(String cedula, String nombre, String apellido, 
                  String especialidad, String codigoMedico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.codigoMedico = codigoMedico;
        this.consultas = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public void agregarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}