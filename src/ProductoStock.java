
public class ProductoStock extends Producto{
	private int stock;
	private float costo;

	public ProductoStock(int id,String nombre, String descripcion, String marca,String categoria, int stock, float costo) {
		super(id,nombre,descripcion,marca,categoria);
		this.stock = stock;
		this.costo = costo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	// Crear metodo generar Query String
	// Crear metodo mostrar
	
	}// cierre clase

