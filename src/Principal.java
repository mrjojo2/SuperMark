import java.sql.ResultSet;
import java.util.Scanner;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ConexionBD con=new ConexionBD();
		
		Scanner teclado=new Scanner(System.in);
		
		String nombreProducto="";
		String descProducto="";
		String marcaProducto="";
		String categProducto="";
		int stockProducto=0;
		float costoProducto=0;
		
		
		System.out.println("Ingrese el Nombre del Producto: ");
		nombreProducto=teclado.nextLine();
		
		System.out.println("Ingrese la descricion del Producto: ");
		descProducto=teclado.nextLine();
		
		System.out.println("Ingrese la marca del Producto: ");
		marcaProducto=teclado.nextLine();
		
		System.out.println("Ingrese la categoria del Producto: ");
		categProducto=teclado.nextLine();
		
		System.out.println("Ingrese el stock del Producto: ");
		stockProducto=teclado.nextInt();
		
		System.out.println("Ingrese el costo del Producto: ");
		costoProducto=teclado.nextFloat();
		
		ProductoStock nuevoProducto=new ProductoStock(nombreProducto,descProducto,marcaProducto,categProducto,stockProducto,costoProducto);
		
		System.out.println(nuevoProducto.generarInsertQuery());
		
		System.out.println(nuevoProducto.toString());
		
		con.conectar();
		con.realizarUpdate(nuevoProducto.generarInsertQuery());
		ResultSet =con.consultar("select stock from producto where nombre="+"'leche'"+";");
		con.cerrarConexion();
			
	}
	
	public void menu() {
		
		System.out.println("1. Loguearse");
		System.out.println("2. Registrarse");
		System.out.println("0. Salir");
		System.out.println("Ingrese opcion:");
		//leen respuesta
		Scanner teclado=new Scanner(System.in);
		int op=teclado.nextInt();
		
		/*switch (op) {
		case 1: 
			Login login=new Login();
			
			if(login.loguearme()==0) {
				System.out.println("Error al loguearse intente mas tarde...");
			}
			
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}*/
	}

}
