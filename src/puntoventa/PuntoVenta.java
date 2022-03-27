package puntoventa;

import java.util.Scanner;
import java.util.ArrayList;

public class PuntoVenta {
	
	//Va a almacenar elementos de clase Producto
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	
	
	//Las seis son constantes porque llevan final, son escritas en mayusc y separadas con anpersan
	public final static int OPCION_MENU_SALIR = 6;
	public final static int OPCION_MENU_PAGAR = 5;
	public final static int OPCION_MENU_CARRO = 4;
	public final static int OPCION_MENU_ELIMINAR = 3;
	public final static int OPCION_MENU_PRODUCTOS = 2;
	public final static int OPCION_MENU_CREAR = 1;

	
	
	public static void main(String[] args) {
		int opcionSeleccionada;
		do {
			opcionSeleccionada = menu();
			switch(opcionSeleccionada) {
			case OPCION_MENU_CREAR:
				crearProducto();
				break;
			case OPCION_MENU_PRODUCTOS:
				verProductos();
				break;
			case OPCION_MENU_ELIMINAR:
				eliminarProducto();
				break;
			case OPCION_MENU_CARRO:
				agregarProductoAlCarro();
				break;
			case OPCION_MENU_PAGAR:
				pagar();
				break;
			}
		} while (opcionSeleccionada != OPCION_MENU_SALIR);
	}

	
	
	private static void crearProducto() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Por favor ingrese un código para su producto:");
		String codigoProducto = scanner.nextLine();
		
		System.out.println("Por favor ingrese un nombre para su producto:");
		String nombreProducto = scanner.nextLine();
		
		System.out.println("Por favor ingrese un precio a su producto:");
		int precioProducto = scanner.nextInt();
		
		Producto prodcutoNuevo = new Producto(codigoProducto, nombreProducto, precioProducto);
		
		//Con esta linea agregamos los productos al array productos.
		productos.add(prodcutoNuevo);
		
		
	}

	private static void verProductos() {
		
		System.out.println("\nProductos agregados: \n**********************************");
		for (Producto producto : productos) {
			System.out.printf("Codigo: %s Producto: %s Precio: %d %n"
					, producto.getCodigo()
					, producto.getNombre()
					, producto.getPrecio());
		}
		System.out.println("\n**********************************");
	}

	private static void eliminarProducto() {
		// TODO Auto-generated method stub
		
	}

	private static void agregarProductoAlCarro() {
		// TODO Auto-generated method stub
		
	}

	private static void pagar() {
		// TODO Auto-generated method stub
		
	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("\nMENU PUNTO DE VENTA \n==================\n");
		System.out.println("1. Crear Producto");
		System.out.println("2. Ver Productos");
		System.out.println("3. Eliminar Producto");
		System.out.println("4. Agregra Producto al Carro");
		System.out.println("5. Pagar");
		System.out.println("6. SALIR");
		
		System.out.println("\nPor favor digite la opción deseada: ");
		Scanner scanner = new Scanner( System.in );
		int opcionSeleccionada = scanner.nextInt();
		return opcionSeleccionada;
	}
}
