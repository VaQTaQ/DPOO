package lógico;

import java.util.Date;

public class Vacuna  extends VacunaDisponible{
    
    private Date fechaAplicacion;
    private int dosisNecesarias;
    private int dosisAplicadas;
    

    public Vacuna(String nombre, Date fechaAplicacion, int dosisNecesarias, int dosisAplicadas, int minEdad, int maxEdad) {
        super(nombre, minEdad, maxEdad);
        this.fechaAplicacion = fechaAplicacion;
        this.dosisNecesarias = dosisNecesarias;
        this.dosisAplicadas = dosisAplicadas;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public int getDosisNecesarias() {
        return dosisNecesarias;
    }

    public void setDosisNecesarias(int dosisNecesarias) {
        this.dosisNecesarias = dosisNecesarias;
    }

    public int getDosisAplicadas() {
        return dosisAplicadas;
    }

    public void setDosisAplicadas(int dosisAplicadas) {
        this.dosisAplicadas = dosisAplicadas;
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
