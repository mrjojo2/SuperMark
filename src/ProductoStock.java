
public class ProductoStock extends Producto{
	private int stock;
	private double costo;

	public ProductoStock(int id,String nombre, String descripcion, String marca,String categoria, int stock, double costo,double precio) {
		super(id,nombre,descripcion,marca,categoria,precio);
		this.stock = stock;
		this.costo = costo;
	}

	public ProductoStock(String nombre, String descripcion, String marca, String categoria, int stock, double costo,double precio) {
		super(nombre, descripcion, marca, categoria, precio);
		this.stock=stock;
		this.costo=costo;
		// TODO Auto-generated constructor stub
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	// Crear metodo generar Query insertar String
	
	public String generarInsertQuery() {
		String sql="insert into producto (nombre,descripcion,marca,categoria,stock,costo,precio) values ('"+
					super.getNombre()+"','"+
					super.getDescripcion()+"','"+
					super.getMarca()+"','"+
					super.getCategoria()+"',"+
					this.getStock()+","+
					this.getCosto()+","+
					super.getPrecio()+");";
		return sql;
	}
	//metodos genera query para actualizar por tipo de campo y un id de producto
	public String modificarCampo(String campo,String valor) {
		String actualizar="Update producto set "+campo+"='"+valor+"' where idProducto="+super.getId()+";";
		return actualizar;
	}
	public String modificarCampo(String campo,int valor) {
		String actualizar="Update producto set "+campo+"="+valor+" where idProducto="+super.getId()+";";
		return actualizar;
	}
	public String modificarCampo(String campo, double valor) {
		String actualizar="Update producto set "+campo+"="+valor+" where idProducto="+super.getId()+";";
		return actualizar;
	}
	
	
	
	
	public boolean iguales(ProductoStock aComparar) {
		if(super.getNombre().compareToIgnoreCase(aComparar.getNombre())==0) {
			if(super.getMarca().compareToIgnoreCase(aComparar.getMarca())==0) {
				if(super.getDescripcion().compareToIgnoreCase(aComparar.getDescripcion())==0) {
					return true;
				}else return false;
			}else return false;
		}else return false;
	}
	
	
	//muestra info producto
	
	public void mostrarProducto() {
		super.mostrar();
		System.out.println("Stock: "+this.stock);
		System.out.println("Costo: "+this.costo);
	}

	public static ProductoStock buscarProducto(int idProducto) {
		ConexionBD conexion=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
		conexion.conectar();
		String consulta=conexion.selectBD("Select * from producto where idProducto="+idProducto+";");
		conexion.cerrarConexion();
		
		if(consulta.equalsIgnoreCase("")==false) {
			String[] registros=consulta.split(";");
			if(registros.length==1) {
				String[] campos=registros[0].split(",");
				ProductoStock producto=new ProductoStock(Integer.parseInt(campos[0]),campos[1],campos[2],campos[3],campos[4],Integer.parseInt(campos[5]),Double.parseDouble(campos[6]),Double.parseDouble(campos[7]));
				return producto;
			}else {
				return null;
			}
		}else return null;
		
	}

	
	}// cierre clase

