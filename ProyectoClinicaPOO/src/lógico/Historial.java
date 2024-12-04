package lógico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Historial implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Idea de Ian y Charls
	
	private Date Fecha;
	private String Detalle;
	//idea de Hugo
	private ArrayList<Object> Acciones; //incluira todo lo que se haga en la clinica(ejemplo: se pone la vacuna a un paciente ese objeto Vacuna iria dentro de ese arrayLis)
	private ArrayList<String> reportes;//Aqui iran los reportes de todo lo que se haga que se generaran de forma automatica con funciones
	

	public Historial(){//constructor con ambas ideas implementadas(si se elije la de hugo se deberia eliminar detalles y accionn)
		super();//sino los arrayList

		this.Fecha = new Date();
		this.Detalle = new String();
		this.Acciones = new ArrayList<Object>();
		this.reportes = new ArrayList<String>();
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

	public boolean eliminarAccion(Object accion) {
		return Acciones.remove(accion);
	}

	public void limpiarHistorial() {
		Acciones.clear();
		reportes.clear();
	}

	public String generarResumen() {
		return "Total de acciones registradas: " + Acciones.size() + "\nTotal de reportes generados: " + reportes.size();
	}
}
