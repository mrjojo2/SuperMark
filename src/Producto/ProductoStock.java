package Producto;



public class ProductoStock extends Producto {
	
	private int stock;
	private double costo;
	
	public ProductoStock(String nombre, String marca, String categoria, String descripcion, double precio, int stock,
			double costo) {
		super(nombre, marca, categoria, descripcion, precio);
		this.stock = stock;
		this.costo = costo;
	
	}

	public ProductoStock(int id, String nombre, String marca, String categoria, String descripcion, double precio,
			int stock, double costo) {
		super(id, nombre, marca, categoria, descripcion, precio);
		this.stock = stock;
		this.costo = costo;
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

	public void mostrar() {
		super.mostrar();
		System.out.println("Stock:"+this.stock);
		System.out.println("Costo:"+this.costo);
		
	}
	
	public String crearQueryInsert() {
		return "insert into Productos (fecha,nombre,marca,categoria,descripcion,stock,costo,precio_venta) values (now(),'"+super.getNombre()+"','"+super.getMarca()+"','"+super.getCategoria()+"','"+super.getDescripcion()+"',"+this.stock+","+this.costo+","+super.getPrecio()+");";
	}
	

}
