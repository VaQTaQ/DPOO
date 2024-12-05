package lógico;

import java.io.Serializable;
import java.util.Date;

public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accion;
    private String detalle;
    private Date fecha;

    public Historial(String accion, String detalle, Date fecha) {
        this.accion = accion;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
