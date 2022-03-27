package puntoventa;

//se crea la clase y sus propiedades
public class Producto {

	private String codigo;
	private String nombre;
	private int precio;
	
	//se crea constructor en blanco
	public Producto() {
		
	}

	//constructor con propiedades
	public Producto(String codigo, String nombre, int precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	//getters y setters de todas las propiedades
	
	//getters y setters codigo
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	//getters y setters nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//getters y setters precio
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	//todos estos pasos constituyen la practica POJO
	
	
	
	
}
