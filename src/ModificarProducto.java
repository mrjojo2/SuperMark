import java.util.ArrayList;
import java.util.Scanner;

public class ModificarProducto {
	
	public ModificarProducto(ProductoStock producto) {
		
	}
	
	final ConexionBD conexion=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
	
	// hacer metodo modificar producto
	public void modificarForm() {
		
		int idBuscado;
		Scanner entrada=new Scanner(System.in);
		System.out.println("---FORMULARIO STOCK---");
		System.out.println("Modificar Producto");
		 
		System.out.println("Ingrese id del producto a modificar");
		idBuscado=entrada.nextInt();
		
		String query=conexion.selectBD("Select * from producto where idProducto="+idBuscado+";");
		ArrayList<ProductoStock> listaProd=new ArrayList<ProductoStock>();
		if(query.equalsIgnoreCase("")==false) {
			String[] registros=query.split(";");
			for(int i=0;i<registros.length;i++) {
				String[] campos=registros[i].split(",");
				ProductoStock buscado=new ProductoStock(campos[0],campos[1],campos[2],campos[3],Integer.parseInt(campos[4]),Double.parseDouble(campos[5]),Double.parseDouble(campos[6]));
				listaProd.add(buscado);
			}
		}
		if(listaProd.isEmpty()==false) {
			if(listaProd.size()==1) {
				listaProd.get(idBuscado).mostrarProducto();
			}
		}
	}
	
	public int opcionCampo() {
		
		Scanner teclado=new Scanner(System.in);
		String opString;
		int opInt=-1;
		boolean condicion=false;
		do {
			System.out.println("Seleccione el campo a modificar");
			System.out.println("1-Nombre.");
			System.out.println("2-Descripcion.");
			System.out.println("3-Marca.");
			System.out.println("4-Categoría.");
			System.out.println("5-Stock.");
			System.out.println("6-Costo.");
			System.out.println("7-Precio venta.");
			System.out.println("0-Cancelar.");
			opString=teclado.nextLine();
			try {
				opInt=Integer.parseInt(opString);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("formato invalido");
			}
			if(opInt<=7 && opInt>=0) {
				condicion=true;
			}else System.out.println("Opcion invalida");
		}while(condicion==false);
		teclado.close();
		return opInt;
	}
	
	public boolean modificar(ProductoStock producto) {
		Scanner entrada=new Scanner(System.in);
		String sentencia="";
		switch (opcionCampo()) {
		case 1:
			System.out.println("Ingrese el nuevo nombre");
			producto.setNombre(entrada.nextLine());
			sentencia=producto.generarModificar("nombre", producto.getNombre());
			conexion.conectar();
			if(conexion.realizarUpdate(sentencia)) {
				System.out.println();
			}
			conexion.cerrarConexion();
			break;
		case 2:
			System.out.println("Ingrese la descripcion");
			producto.setNombre(entrada.nextLine());
			sentencia=producto.generarModificar("nombre", producto.getNombre());
			conexion.conectar();
			conexion.realizarUpdate(sentencia);
			conexion.cerrarConexion();
			break;
		case 3:
			System.out.println("Ingrese el nuevo nombre");
			producto.setNombre(entrada.nextLine());
			sentencia=producto.generarModificar("nombre", producto.getNombre());
			conexion.conectar();
			conexion.realizarUpdate(sentencia);
			conexion.cerrarConexion();
			break;
		}
	}
	
}
