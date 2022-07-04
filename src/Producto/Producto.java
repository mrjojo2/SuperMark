package Producto;

public class Producto {
	private String nombre;
	private String descripcion;
	private String marca;
	private String categoria;
	private int cantidad;
	private float precio;
	
	public Producto(String nombre, String descripcion, String marca,
			String categoria, int cantidad, float precio) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
		
} // cierre de clase
