import java.sql.ResultSet;
import java.util.Scanner;

public class AltaProducto {
	final ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");

	// hacer metodo registrar producto
	public boolean resgitrarProducto() {
		//ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
		
		Scanner teclado=new Scanner(System.in);
		
		String nombre="";
		String descripcion="";
		String marca="";
		String categoria="";
		String stock="";
		String costo="";
		
		//pido al usuario ingrese los datos del producto
		System.out.println("***FORMULARIO PRODUCTO***");
		
		System.out.println("Ingrese el Nombre del Producto: ");
		nombre=teclado.nextLine();
		
		System.out.println("Ingrese la descricion del Producto: ");
		descripcion=teclado.nextLine();
		
		System.out.println("Ingrese la marca del Producto: ");
		marca=teclado.nextLine();
		
		System.out.println("Ingrese la categoria del Producto: ");
		categoria=teclado.nextLine();
		
		System.out.println("Ingrese el stock del Producto: ");
		stock=teclado.nextLine();
		
		System.out.println("Ingrese el costo del Producto: ");
		costo=teclado.nextLine();
		
		teclado.close();
		
		//valido los datos ingresados
		if(validarCampos(nombre,descripcion,marca,categoria,stock,costo)==true) {
			if(existenciaProducto(nombre,marca)==false) {
				ProductoStock nuevoProducto=new ProductoStock(nombre,descripcion,marca,categoria,Integer.parseInt(stock),Float.parseFloat(costo));
				con.conectar();//abro conexion
				con.realizarUpdate(nuevoProducto.generarInsertQuery());//realizo un insert
				con.cerrarConexion();
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	//metodo para validar campos
	public boolean validarCampos(String nombre,String desc,String marca,String categ,String stock,String costo) {
		if(nombre.equalsIgnoreCase("")==false && desc.equalsIgnoreCase("")==false && marca.equalsIgnoreCase("")==false && validarNumeroInt(stock)==true && validarNumeroFloat(costo)==true) {
			return true;
		}else  {
			return false;
		}
	}
	
	//metodo para validar un string que es ingresado como numero
	public boolean validarNumeroInt(String num) {
		
		try {
			Integer.parseInt(num);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public boolean validarNumeroFloat(String num) {
		
		try {
			Float.parseFloat(num);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public boolean existenciaProducto(String nombre, String marca) {
		
		con.conectar();
		ResultSet resultado=con.consultar("Select * from producto where nombre='"+nombre+"' and marca='"+marca+"';");
		int cont=0;
		try {
			while(resultado.next()) {
				cont++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		con.cerrarConexion();
		if(cont==0) {
			return false;
		}else {
			return true;
		}
	}
	
} // cierre de clase

