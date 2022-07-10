import java.util.ArrayList;
import java.util.Scanner;

public class GestionCliente {
	final ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
	
	private double total;
	
	public double getTotal() {
		return total;
	}
	
	public void confirmarCompra(Integer idCliente,Carrito carrito){
		int tam=carrito.getProductos().size();
		if(tam!=0) {
			if(con.abrirConecion()) {
				if(con.realizarUpdate("Insert into ventas (fecha,cliente_id) values (NOW(),"+idCliente+");")) {
					String string=con.selectBD("SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'supermarket' AND   TABLE_NAME   = 'ventas';");
					int idVenta=Integer.parseInt(string.substring(0,string.length()-1))-1;
					carrito.setCodigo(idVenta);
					for(int i=0;i<tam;i++) {
						int idProducto=carrito.getProductos().get(i).getId();
						int cantidad=carrito.getProductos().get(i).getCantidad();
						con.realizarUpdate("insert into detalle_ventas (id_venta,id_producto,cantidad) values ("+carrito.getCodigo()+","+idProducto+","+cantidad+")");
						con.realizarUpdate("Update producto set stock=stock-"+cantidad+" where id_producto="+idProducto+";");
					}
					System.out.println("Gracias por comprar en supermarket");
					con.cerrarConexion();
				}else {
					System.out.println("Error de conexion");
					con.cerrarConexion();
				}
				
			}else {
				System.out.println("Error en la conexion intente nuevamente mas tarde");
			}
			
		}else {
			System.out.println("No hay productos en el carrito");
		}
	}
	
	public ArrayList<ProductoCarrito> llenarCarrito(Carrito nuevo) {
		
		Scanner entrada=new Scanner(System.in);
		int numero;
		int cantidad;
		String rta="";
		do {
			ListarStock lt=new ListarStock();
			lt.mostrarProdCliente();
			do {
				System.out.println("Ingrese el numero del producto seleccionado");
				numero=entrada.nextInt();
				entrada.nextLine();
				if(numero<0 || numero>lt.getSize()) {
					System.out.println("Ingrese una opcion válida");
				}
			}while(numero<0 || numero>lt.getSize());
			int id=lt.getProductos().get(numero-1).getId();
			String nombre=lt.getProductos().get(numero-1).getNombre();
			String descripcion=lt.getProductos().get(numero-1).getDescripcion();
			String marca=lt.getProductos().get(numero-1).getMarca();
			String categoria=lt.getProductos().get(numero-1).getCategoria();
			int stock=lt.getProductos().get(numero-1).getStock();
			double precio=lt.getProductos().get(numero-1).getPrecio();
			ProductoCarrito pn=new ProductoCarrito(id,nombre,descripcion,marca,categoria,precio,0);
			do {
				System.out.println("Ingrese la cantidad deseada");
				cantidad=entrada.nextInt();
				entrada.nextLine();
				if(cantidad>stock || cantidad<1) {
					System.out.println("Ingrese una opcion válida");
				}
			}while(cantidad>stock || cantidad<1);
			pn.setCantidad(cantidad);
			nuevo.agregarProducto(pn);
			do {
				System.out.println("¿Desea agregar un nuevo producto?[S/N]");
				rta=entrada.nextLine();
				if(rta.equalsIgnoreCase("S")==false && rta.equalsIgnoreCase("N")==false) {
					System.out.println("Ingrese una repuesta valida");
				}
			}while(rta.equalsIgnoreCase("S")==false && rta.equalsIgnoreCase("N")==false);
			
			this.total=this.total+(precio*cantidad);
		}while(rta.equalsIgnoreCase("S") && nuevo.getProductos().size()<=30);
		
		return nuevo.getProductos();
	}
	
	
}
