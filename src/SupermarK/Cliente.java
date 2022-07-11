package SupermarK;

public class Cliente {

	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String domicilio;
	private String email;
	public Cliente(String nombre, String apellido, String dni, String telefono,String domicilio, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
	}

	
	public Cliente(int id, String nombre, String apellido, String dni, String telefono,String domicilio, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
	}


	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void mostrar() {
		System.out.println("ID:"+this.id);
		System.out.println("Nombre:"+this.nombre);
		System.out.println("Apellido:"+this.apellido);
		System.out.println("DNI:"+this.dni);
		System.out.println("Telefono:"+this.telefono);
		System.out.println("Domicilio:"+this.domicilio);
		System.out.println("Email:"+this.email);
	}
	
	public String creaQueryInsert() {
		return "insert into Clientes (fecha,nombre,apellido,dni,telefono,domicilio,email) values (Now(),'"+this.nombre+"','"+this.apellido+"','"+this.dni+"','"+this.telefono+"','"+this.domicilio+"','"+this.email+"');";
	}
	
	

}

