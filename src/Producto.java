import java.sql.Date;

public class Producto {
	//declracion de Variables
	private int id;
	private String nombre;
	private String descripcion;
	private String marca;
	private String categoria;
	
	
	//constructor
	public Producto(String nombre, String descripcion, String marca,
			String categoria) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
		
	}
	
	public Producto(int id,String nombre, String descripcion, String marca,
			String categoria) {
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
		
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
		System.out.println("Id producto: "+id);
		System.out.println("Nombre: "+nombre);
		System.out.println("Descripción: "+descripcion);
		System.out.println("Marca: "+marca);
		System.out.println("Categoría: "+categoria);
	}
		
} // cierre de clase
