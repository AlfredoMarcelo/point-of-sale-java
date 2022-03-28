package puntoventa;

import java.util.Scanner;
import java.util.ArrayList;

public class PuntoVenta {
	
	//ArrayList que va a almacenar elementos de clase Producto agregados con scanner
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	//En este ArrayList ventas se guardaran solo las ventas que se generen y paguen
	private static ArrayList<Venta> ventas = new ArrayList<Venta>();
	
	
	//Las seis son constantes porque llevan final, son escritas en mayusc y separadas con anpersan
	public final static int OPCION_MENU_SALIR = 7;
	public final static int OPCION_MENU_CARGA_PRODUCTOS = 6;
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
				agregarProductosAlCarro();
				break;
			case OPCION_MENU_CARGA_PRODUCTOS:
				agregarProductosPorDefecto();
				break;
			case OPCION_MENU_PAGAR:
				pagar();
				break;
			}
		} while (opcionSeleccionada != OPCION_MENU_SALIR);
	}

	
	public static void agregarProductosPorDefecto() {
		productos.add( new Producto( "ch1", "Chicle Menta", 200));
		productos.add( new Producto( "ch2", "Chicle Frutilla", 300));
		productos.add( new Producto( "bc1", "Coca cola ", 500));
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
			System.out.printf("Código: %s Producto: %s Precio: %d %n"
					, producto.getCodigo()
					, producto.getNombre()
					, producto.getPrecio());
		}
		System.out.println("\n**********************************");
	}

	private static void eliminarProducto() {
		
		System.out.println("\nSelecciona el código del producto que deseas eliminar: \n");
		Scanner scanner 	= new Scanner(System.in);
		String codigo	 	= scanner.nextLine();//nextLine es para guardar como string
		Producto producto 	= buscarProducto(codigo);
		
		if (producto != null) {
			productos.remove( producto);
			System.out.printf("Se ha eliminado correctamente el producto: %s %n%n", producto.getNombre());
		}else {
			System.out.printf("No se encontró ningún producto con el codigo: %s %n%n", codigo);
		}
		
		/*for(int i = 0; i < productos.size();i++) {
			System.out.println(productos.get(i));
		}*/
		
		/*for(Producto producto:productos) {
			System.out.printf("Codigo : %s Nombre: %s %n"
					,producto.getCodigo()
					,producto.getNombre());
		}*/
		
		//pienso que para eliminar, se debe usar un scanner para que el usuario ingrese el codigo
		//luego ese codigo guardarlo en una variable
		//por ultimo usar el contains con el valor de la variable anterior
		//utilizar el metodo remove con el valor del contains 
		
		System.out.println("\n************************************\n");
		
	}

	private static Producto buscarProducto(String codigo) {
		
		for(Producto producto:productos) {
			if(producto.getCodigo().equalsIgnoreCase(codigo)) {
				return producto;
			}
		}
		return null;
	}
	
	
	
	private static void agregarProductosAlCarro() {
		
		Venta venta = new Venta();
		boolean seguirAgregandoProductos = true;
		
		do {
			//Muestro todos los productos
			verProductos();
			//preguntar codigo de producto a comprar
			System.out.println("Escriba el codigo del producto que quiere comprar: ");
			Scanner scanner 	= new Scanner(System.in);
			String codigo 		= scanner.nextLine();
			Producto producto 	= buscarProducto(codigo);
			
			//cantidad a comprar
			System.out.println("Escriba la cantidad a comprar");
			int cantidad = scanner.nextInt();
			//Crear linea de detalle
			LineaDetalle lineaDetalle = new LineaDetalle(cantidad, producto);
			venta.agregarLineaDeDetalle(lineaDetalle);
			//pregunto al usuario si quiere agregar mas productos
			System.out.println("Dese agregar más productos al carro: [si/no]");
			//condicion con operador ternario
			seguirAgregandoProductos = scanner.nextLine().equalsIgnoreCase("SI") ? true : false;
		}while( seguirAgregandoProductos );
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿La venta fue pagada? [si/no]");
		boolean ventaPagada = scanner.nextLine().equalsIgnoreCase("SI") ? true : false;
		
		if (ventaPagada) {
			ventas.add( venta );
		}
		
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
		System.out.println("6. Agregar productos por defecto");
		System.out.println("7. SALIR");
		
		System.out.println("\nPor favor digite la opción deseada: ");
		Scanner scanner = new Scanner( System.in );
		int opcionSeleccionada = scanner.nextInt();
		return opcionSeleccionada;
	}
}
