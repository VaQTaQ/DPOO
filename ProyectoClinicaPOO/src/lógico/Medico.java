package lógico;

public class Medico extends Persona {
    private String especialidad;


    public Medico(String cedula, String nombre, String apellido, int edad, String sexo, String direccion, String especialidad) {
        super(cedula, nombre, apellido, edad, sexo, direccion);
        this.especialidad = especialidad;
    }

 
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
