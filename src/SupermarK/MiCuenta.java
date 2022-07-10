package SupermarK;

import java.util.ArrayList;

import Conexion_BD.Conexion;
import Producto.ProductoCarrito;

public class MiCuenta {
	private Usuario usuario;
	private Carrito carrito;
	private ArrayList <Carrito> historial;

	public MiCuenta(Usuario usuario) {
		super();
		this.usuario = usuario;
		this.carrito = new Carrito();
		this.historial=null;
		obtenerHistorial();
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	public void mostrarUsuario() {
		System.out.println("Usuario:"+this.usuario.getEmail());
	}
	
	public void mostrarCarrito() {
		this.carrito.mostrar();
	}
	
	private void obtenerHistorial() {
		Conexion conn=new Conexion("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark" ,"root","jochis");
		String provisorio;
		
		if(conn.conectar()) {
			provisorio=conn.select("select cliente_id from clientes where email='"+this.usuario.getEmail()+"';");
			provisorio=provisorio.substring(0, provisorio.length()-1);
			
			String tabla=conn.select("select ventas.fecha,ventas.venta_id,productos.nombre,productos.marca,productos.categoria,productos.descripcion,productos.precio_venta,detalle_venta.cantidad from ventas inner join detalle_venta using(venta_id)\r\n"
					+ "inner join Productos using (producto_id) where cliente_id="+provisorio+ " order by 1;");
			
			
			if(tabla.equalsIgnoreCase("")==false) {
				this.historial=new ArrayList<Carrito>();
				String [] registros=tabla.split(";");
				String [] registro;
				
				int i=0;
				boolean band=true;
				
				while(i<registros.length) {
					registro=registros[i].split(",");
					if(band==true) {
						//(String nombre, String marca, String categoria, String descripcion, int cantidad,
							//	double precio)
						this.historial.add(new Carrito(registro[0],Integer.parseInt(registro[1])));
						this.historial.get(this.historial.size()-1).agregar(new ProductoCarrito(registro[2],registro[3],registro[4],registro[5],Integer.parseInt(registro[7]),Double.parseDouble(registro[6])));
						band=false;
						i++;
					}
					else {
						if(Integer.parseInt(registro[1])==this.historial.get(this.historial.size()-1).getId()) {
							this.historial.get(this.historial.size()-1).agregar(new ProductoCarrito(registro[2],registro[3],registro[4],registro[5],Integer.parseInt(registro[7]),Double.parseDouble(registro[6])));
							i++;
						}
						else band=true;
					}
					
				}
			}
			conn.cerrar();
		}
	}
	
	public void mostrarHistorial() {
		if(this.historial!=null) {
			for(int i=0;i<this.historial.size();i++) {
				this.historial.get(i).mostrar();
			}
		}
		else System.out.println("Nada para mostrar");
	}
	
	public boolean comprar() {
		if(this.carrito.getProductos().size()>0) {
			CRUD crud=new CRUD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark" ,"root","154199jt");
			if(crud.conectar()) {
				String cliente=crud.select("select cliente_id from Clientes where email='"+this.usuario.getEmail()+"';");
				
				cliente=cliente.substring(0,cliente.length()-1);
				if(crud.insert("insert into Ventas (fecha,cliente_id) values (now(),"+cliente+");")) {
					cliente=crud.select("SELECT `AUTO_INCREMENT`\r\n"
							+ "FROM  INFORMATION_SCHEMA.TABLES\r\n"
							+ "WHERE TABLE_SCHEMA = 'supermark'\r\n"
							+ "AND   TABLE_NAME   = 'ventas';");
					//System.out.println(cliente);
					cliente=cliente.substring(0, cliente.length()-1);
					this.carrito.setId(Integer.parseInt(cliente)-1);
					for(int i=0;i<this.carrito.getProductos().size();i++) {
						crud.insert("insert into detalle_venta values ("+this.carrito.getId()+","+this.carrito.getProductos().get(i).getId()+","+this.carrito.getProductos().get(i).getCantidad()+");");
						crud.insert("update Productos set stock=stock-"+this.carrito.getProductos().get(i).getCantidad()+";");
					}
					crud.cerrar();
					return true;
				}
				else {
					System.out.println("Error la compra no se puede realizar");
					crud.cerrar();
					return false;
				}
			}
			else {
				System.out.println("Error en la conexion");
				return false;
				
			}
			
		}
		else {
				System.out.println("Carrito vacio");
				return false;
		}
	}
} // cierra clase
