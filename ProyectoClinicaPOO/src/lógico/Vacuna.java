package lógico;

import java.util.Date;

public class Vacuna {
    private String nombre;
    private Date fechaAplicacion;
    private int dosisNecesarias;
    private int dosisAplicadas;
    private int minEdad;
    private int maxEdad;

    public Vacuna(String nombre, Date fechaAplicacion, int dosisNecesarias, int dosisAplicadas, int minEdad, int maxEdad) {
        this.nombre = nombre;
        this.fechaAplicacion = fechaAplicacion;
        this.dosisNecesarias = dosisNecesarias;
        this.dosisAplicadas = dosisAplicadas;
        this.minEdad = minEdad;
        this.maxEdad = maxEdad;
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
