import java.util.Scanner;

public class BajaProducto {
	final ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
//	hacer metodo quitar
	
	public void bajaProducto() {
		Scanner entrada=new Scanner(System.in);
		int id;
		System.out.println("***FORMULARIO PRODUCTO STOCK***");
		System.out.println("---Eliminar Producto---");
		System.out.println("Ingrese el id del producto a eliminar.");
		id=entrada.nextInt();
		entrada.nextLine();
		if(ProductoStock.buscarProducto(id)!=null) {
			ProductoStock pr=new ProductoStock(ProductoStock.buscarProducto(id));
			String rta;
			System.out.println("¿Seguro que desea eliminar el siguiente producto?");
			pr.mostrarProducto();
			System.out.println("Ingrese S(si) para confirmar");
			System.out.println("Ingrese N(no) para cancelar");
			rta=entrada.nextLine();
			if(rta.equalsIgnoreCase("S")) {
				con.conectar();
				con.realizarUpdate(pr.bajaProducto());
				con.cerrarConexion();
				System.out.println("Se ha eliminado el producto de la base de datos.");
			}else if (rta.equalsIgnoreCase("N")){
				System.out.println("Baja cancelada");
			}
		}else {
			System.out.println("El Produco con id "+id+" no existe en la base de datos");
		}
		//entrada.close();
	}
} // cierre clase
