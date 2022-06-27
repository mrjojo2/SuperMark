
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

		
} // cierre de clase
