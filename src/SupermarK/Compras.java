package SupermarK;
import java.util.ArrayList;

import Conexion_BD.ConexionBD;
import Producto.ProductoCarrito;
public class Compras {
	private ArrayList<Carrito> compras;
	final ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
	public Compras(int idCliente) {
		compras=new ArrayList<Carrito>();
		obtenerCompras(idCliente);
	}
	
	public void obtenerCompras(int idCliente) {
		Carrito nuevo=new Carrito();
		if(con.abrirConecion()) {
			String Ventas=con.selectBD("Select id_venta, fecha from ventas where cliente_id="+idCliente+";");
			if(Ventas.equalsIgnoreCase("")==false) {
				String[] registroVenta=Ventas.split(";");
				for(int i=0;i<registroVenta.length;i++) {
					String[]camposV=registroVenta[i].split(",");
					int idV=Integer.parseInt(camposV[0]);
					String fecha=camposV[1];
					double costoT=0;
					nuevo.setCodigo(idV);
					nuevo.setFecha(fecha);
					
					String productos=con.selectBD("Select producto.nombre,producto.descripcion,producto.marca,producto.categoria,producto.precio,detalle_ventas.cantidad from ventas inner join detalle_ventas using (id_venta) inner join producto using (id_producto) where id_venta="+idV+";");
					String[] regProd=productos.split(";");
					for(int j=0;j<regProd.length;j++) {
						String[] camposP=regProd[j].split(",");
						ProductoCarrito nuevoP=new ProductoCarrito(camposP[0],camposP[1],camposP[2],camposP[3],Double.parseDouble(camposP[4]),Integer.parseInt(camposP[5]));
						nuevo.agregarProducto(nuevoP);
						costoT=costoT+Double.parseDouble(camposP[4]);
					}
					nuevo.setTotal(costoT);
					this.compras.add(nuevo);
				}
			}
		}
		
		
	}
	
	public void mostrarCompras() {
		if(this.compras.size()!=0) {
			for(int i=0;i<this.compras.size();i++) {
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::");
				System.out.println("CODIGO: "+this.compras.get(i).getCodigo());
				System.out.println("FECHA: "+this.compras.get(i).getFecha());
				System.out.println("___________________________________________");
				for(int j=0;i<this.compras.get(i).getProductos().size();j++) {
					this.compras.get(i).getProductos().get(j).mostrar();
					System.out.println();
				}
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::");
			}
		}
	}
		
} // cierre de clases
