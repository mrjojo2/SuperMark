import java.sql.ResultSet;
import java.util.Scanner;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//AltaProducto otroProducto=new AltaProducto();
		
		//System.out.println(otroProducto.existenciaProducto("Harina","favorita","1kg"));
		
		
		
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
			System.out.println("Registro exitoso");
		}else {
			System.out.println("No se a podido realizar el registro");
		}
		
		/*
		String string=nuevoProducto.queryBuscar("Harina", "favorita", "1kg");
		
		if (string.equalsIgnoreCase("")) {
			System.out.println("Na hay datos que mostrar");
		}else {
			System.out.println("se encontraron registros");
			String[] registros=string.split(";");
			for(int i=0;i<registros.length;i++) {
				String[] campos=registros[i].split(",");
				System.out.println("Cnatidad de campos: "+campos.length);
				System.out.println("Id: "+campos[0]);
				System.out.println("nombre: "+campos[1]);
				System.out.println("descripcion: "+campos[2]);
				System.out.println("marca: "+campos[3]);
				System.out.println("categoria: "+campos[4]);
				System.out.println("stock: "+campos[5]);
				System.out.println("costo: "+campos[6]);
				System.out.println("precio: "+campos[7]);
			}
		}*/
		
		
		
		/*if(nuevoProducto.resgitrarProducto()) {
			System.out.println("Inserccion exitosa");
		//}else {
			System.out.println("Error al ingresar los campos");
		//}*/
		
		
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
