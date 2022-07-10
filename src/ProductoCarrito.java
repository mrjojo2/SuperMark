
public class ProductoCarrito extends Producto {
	private int cantidad;

	public ProductoCarrito(String nombre,String descripcion, String marca, String categoria, double precio, int cantidad) {
		super(nombre,descripcion,marca,categoria,precio);
		this.cantidad = cantidad;
	}
	
	public ProductoCarrito(int id,String nombre,String descripcion, String marca, String categoria, double precio, int cantidad) {
		super(id,nombre,descripcion,marca,categoria,precio);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	// metodo generar Query String
	
	// metodo mostar
	public void mostrar() {
		super.mostrar();
		System.out.println("Cantidad: "+this.cantidad);
	}
	
}// cierre clase


