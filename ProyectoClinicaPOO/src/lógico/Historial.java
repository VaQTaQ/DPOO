package lógico;

import java.util.ArrayList;
import java.util.Date;

public class Historial {
	//Idea de Ian y Charls
	private String Accion;
	private Date Fecha;
	private String Detalle;
	
	public Historial(){//constructor con ambas ideas implementadas(si se elije la de hugo se deberia eliminar detalles y accionn)
		super();//sino los arrayList
		
		this.Accion = new String();
		this.Fecha = new Date();
		this.Detalle = new String();
		this.Acciones = new ArrayList<Object>();
		this.reportes = new ArrayList<String>();
	}

	
	//idea de Hugo
	private ArrayList<Object> Acciones; //incluira todo lo que se haga en la clinica(ejemplo: se pone la vacuna a un paciente ese objeto Vacuna iria dentro de ese arrayLis)
	private ArrayList<String> reportes;//Aqui iran los reportes de todo lo que se haga que se generaran de forma automatica con funciones
	public String getAccion() {
		return Accion;
	}
	public void setAccion(String accion) {
		Accion = accion;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	public ArrayList<Object> getAcciones() {
		return Acciones;
	}
	public void setAcciones(ArrayList<Object> acciones) {
		Acciones = acciones;
	}
	public ArrayList<String> getReportes() {
		return reportes;
	}
	public void setReportes(ArrayList<String> reportes) {
		this.reportes = reportes;
	}
	
	//Metodos para las acciones
	
	public void registrarAccion(Object accion) {
	    Acciones.add(accion);
	}
	
	public void generarReporte() {
	    StringBuilder reporte = new StringBuilder();
	    reporte.append("Reporte generado el: ").append(new Date()).append("\n");
	    for (Object accion : Acciones) {
	        reporte.append("Acción: ").append(accion.toString()).append("\n");
	    }
	    reportes.add(reporte.toString());
	}
	
	public String obtenerReporte(int indice) {
	    if (indice >= 0 && indice < reportes.size()) {
	        return reportes.get(indice);
	    }
	    return "Reporte no encontrado.";
	}
	
	public ArrayList<Object> buscarAcciones(String criterio) {
	    ArrayList<Object> resultados = new ArrayList<>();
	    for (Object accion : Acciones) {
	        if (accion.toString().contains(criterio)) {
	            resultados.add(accion);
	        }
	    }
	    return resultados;
	}

	
}
