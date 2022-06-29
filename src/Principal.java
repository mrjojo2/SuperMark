import java.sql.ResultSet;
import java.util.Scanner;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*AltaProducto nuevoProducto=new AltaProducto();
		
		System.out.println(nuevoProducto.existenciaProducto("DETERGENTE","ALA"));*/
		
		
		
		
		/*ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
		con.conectar();
		ResultSet resultado=con.consultar("Select * from producto where nombre='Harina' and marca='favorita';");
		int cont=0;
		try {
			while(resultado.next()) {
				int id=resultado.getInt("idProducto");
				String nombreString=resultado.getString("nombre");
				String marcaString=resultado.getString("Marca");
				
				System.out.print(" Codigo:"+id);
				System.out.print(" Nombre:"+nombreString);
				System.out.print(" Marca:"+marcaString);
				System.out.println();
				cont++;
			}
			System.out.println(cont);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		con.cerrarConexion();*/
		
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
