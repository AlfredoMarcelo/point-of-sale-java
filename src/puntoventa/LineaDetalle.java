package puntoventa;

public class LineaDetalle {
	
	
	//propiedades
	private int cantidad;
	private Producto producto;
	
	//constructor en blanco
	public LineaDetalle() {
		
	}

	//constructor con propiedades
	public LineaDetalle(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}

	//Setters y Getters
	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
	

}
