import java.sql.ResultSet;
import java.util.Scanner;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AltaProducto nuevoProducto=new AltaProducto();
		
		if(nuevoProducto.resgitrarProducto()) {
			System.out.println("Inserccion exitosa");
		}else {
			System.out.println("Error al ingresar los campos");
		}
		
		
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
