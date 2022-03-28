package puntoventa;

import java.util.ArrayList;
import java.util.Calendar;

public class Venta {

	//Propiedad de clase
	private Calendar fecha = Calendar.getInstance();
	private ArrayList<LineaDetalle> lineasDetalle = new ArrayList<>();
	
	
	//Constructor en blanco
	public Venta() {
		
	}
	
	
	public void agregarLineaDeDetalle(LineaDetalle lineaDetalle) {
		this.lineasDetalle.add(lineaDetalle);
		
	}

	//Constructor con propiedades
	public Venta(Calendar fecha, ArrayList<LineaDetalle> lineasDetalle) {
		this.fecha = fecha;
		this.lineasDetalle = lineasDetalle;
	}
	
	
	//Getters y Setters
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public ArrayList<LineaDetalle> getLineasDetalle() {
		return lineasDetalle;
	}

	public void setLineasDetalle(ArrayList<LineaDetalle> lineasDetalle) {
		this.lineasDetalle = lineasDetalle;
	}
	
	
	
	
	
}
