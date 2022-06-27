
public class ProductoStock extends Producto{
	private int stock;
	private float costo;

	public ProductoStock(String nombre, String descripcion, String marca,String categoria, int stock, float costo) {
		super(nombre,descripcion,marca,categoria);
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
	
	public String generarInsertQuery() {
		String sql="insert into producto (nombre,descripcion,marca,categoria,stock,costo) values ('"+
					this.getNombre()+"','"+
					this.getDescripcion()+"','"+
					this.getMarca()+"','"+
					this.getCategoria()+"',"+this.getStock()+","+this.getCosto()+")";
		return sql;
	}
	 

	@Override
	public String toString() {
		return "ProductoStock [stock=" + stock + ", costo=" + costo + ", getNombre()=" + getNombre()
				+ ", getDescripcion()=" + getDescripcion() + ", getMarca()=" + getMarca() + ", getCategoria()="
				+ getCategoria() + "]";
	}

	
	// Crear metodo mostrar
	
	
	}// cierre clase

