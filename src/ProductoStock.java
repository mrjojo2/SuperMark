
public class ProductoStock extends Producto{
	private int stock;
	private double costo;
	private double Precio;

	public ProductoStock(String nombre, String descripcion, String marca,String categoria, int stock, double costo,double precio) {
		super(nombre,descripcion,marca,categoria);
		this.stock = stock;
		this.costo = costo;
		this.Precio=precio;
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

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	// Crear metodo generar Query insertar String
	
	public String generarInsertQuery() {
		String sql="insert into producto (nombre,descripcion,marca,categoria,stock,costo,precio) values ('"+
					this.getNombre()+"','"+
					this.getDescripcion()+"','"+
					this.getMarca()+"','"+
					this.getCategoria()+"',"+
					this.getStock()+","+
					this.getCosto()+","+
					this.getPrecio()+")";
		return sql;
	}
	//metodos genera query para actualizar por tipo de campo y un id de producto
	public String generarModificar(String campo,String valor) {
		String actualizar="Update from producto set "+campo+"='"+valor+"' where idProducto="+super.getId();
		return actualizar;
	}
	public String generarModificar(String campo,int valor) {
		String actualizar="Update from producto set "+campo+"="+valor+" where idProducto="+super.getId();
		return actualizar;
	}
	public String generarModificar(String campo, double valor) {
		String actualizar="Update from producto set "+campo+"="+valor+" where idProducto="+super.getId();
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
		System.out.println("Stock: "+stock);
		System.out.println("Costo: "+costo);
		System.out.println("Precio de venta: "+Precio);
	}

	
	
	}// cierre clase

