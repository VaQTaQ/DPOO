package lógico;

import java.util.ArrayList;
import java.util.Date;

public class Historial {
	//Idea de Ian y Charls
	private String Accion;
	private Date Fecha;
	private String Detalle;
	
	//idea de Hugo
	private ArrayList<Object> Acciones; //incluira todo lo que se haga en la clinica(ejemplo: se pone la vacuna a un paciente ese objeto Vacuna iria dentro de ese arrayLis)
	private ArrayList<String> reportes;//Aqui iran los reportes de todo lo que se haga que se generaran de forma automatica con funciones
	
}
