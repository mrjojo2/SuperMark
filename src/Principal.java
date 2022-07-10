
import java.util.Scanner;

public class Principal {

	
	public static void main(String[] args) {
		
		//menuAdminProducto();
		Scanner leer=new Scanner(System.in);
		Carrito miCarrito=new Carrito();
		GestionCliente gc=new GestionCliente();
		String rta="";
		miCarrito.setProductos(gc.llenarCarrito(miCarrito));
		miCarrito.setTotal(gc.getTotal());
		miCarrito.mostrar();
		System.out.println("¿Desea Confirmar la compra?[Y/N]");
		rta=leer.nextLine();
		if(rta.equalsIgnoreCase("y")) {
			gc.confirmarCompra(2, miCarrito);
		}else {
			System.out.println("Compra Cancelada");
		}
		
		//Compras miCompra=new Compras(1);
		//miCompra.mostrarCompras();
	}
	
	public static void menuAdminProducto() {
		Scanner entrada=new Scanner(System.in);
		int op;
		do {
			
			do {
				System.out.println("---Menu Administracion Stock---");
				System.out.println("1)- Alta Producto");
				System.out.println("2)- Modificar Producto");
				System.out.println("3)- Baja Producto");
				System.out.println("4)- Ver Stock");
				System.out.println("0)- Salir");
				op=entrada.nextInt();
				entrada.nextLine();
			}while(op<0 || op>4);
			
			switch(op) {
			case 1:
				AltaProducto alta=new AltaProducto();
				if(alta.resgitrarProducto()) {
					System.out.println("Registro exitoso");
				}else {
					System.out.println("No se pudo realizar el alta");
				}
				break;
			case 2:
				ModificarProducto actualizarPro=new ModificarProducto();
				actualizarPro.modificarForm();
				break;
			case 3:
				BajaProducto baja=new BajaProducto();
				
				baja.bajaProducto();
				break;
			case 0:
				System.out.println("Saliendo del Formulario");
				break;
			case 4:
				System.out.println("Ver Stock");
				ListarStock productos=new ListarStock();
				productos.mostrar();
				break;
			}
			System.out.println("Presione enter para continuar");
			entrada.nextLine();
		}while(op!=0);
		
		entrada.close();
		
	}
	public static void verStock() {
		System.out.println("***FORMULARIO PRODUCTO STOCK***");
		System.out.println("---Ver Stock---");
		Scanner entrada=new Scanner(System.in);
		int op;
		do {
			
			do {
				System.out.println("1)- Listar por categoria");
				System.out.println("2)- Listar por nombre");
				System.out.println("3)- Listar por marca");
				System.out.println("4)- Listar todos los productos");
				System.out.println("0)- Salir");
				op=entrada.nextInt();
				entrada.nextLine();
			}while(op<0 || op>4);
			
			switch(op) {
			case 1:
				AltaProducto alta=new AltaProducto();
				if(alta.resgitrarProducto()) {
					System.out.println("Registro exitoso");
				}else {
					System.out.println("No se pudo realizar el alta");
				}
				break;
			case 2:
				ModificarProducto actualizarPro=new ModificarProducto();
				actualizarPro.modificarForm();
				break;
			case 3:
				BajaProducto baja=new BajaProducto();
				
				baja.bajaProducto();
				break;
			case 0:
				System.out.println("Saliendo del Formulario");
				break;
			case 4:
				System.out.println("Ver Stock");
				ListarStock productos=new ListarStock();
				productos.mostrar();
				break;
			}
			
		}while(op!=0);
		
		entrada.close();
	}

}
