

public class Producto {
	//declracion de Variables
	private int id;
	private String nombre;
	private String descripcion;
	private String marca;
	private String categoria;
	private double precio;
	
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	//constructor
	
	public Producto(String nombre, String descripcion, String marca,
			String categoria,double precio) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
		this.precio=precio;
		
	}
	
	public Producto(int id,String nombre, String descripcion, String marca,
			String categoria,double precio) {
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
		this.precio=precio;
	}
	
	//metodos getters y setters
	public int getId() {
		return id;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void mostrar() {
		System.out.println("Id producto: "+this.id);
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Descripción: "+this.descripcion);
		System.out.println("Marca: "+this.marca);
		System.out.println("Categoría: "+this.categoria);
		System.out.println("Precio: "+this.precio);
	}
		
} // cierre de clase
