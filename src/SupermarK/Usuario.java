package SupermarK;

public class Usuario {

	private String email;
	private String clave;
	private String tipo;
	
	public Usuario(String email, String clave, String tipo) {
		super();
		this.email = email;
		this.clave = clave;
		this.tipo= tipo;
		
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String creaQueryInsert(){
	//	return "insert INTO Usuarios (email, clave, tipo) values ('"+this.email+"','"+this.clave+"','"+this.tipo+"');";
		return "insert into Usuarios values ('"+this.email+"','"+this.clave+"','"+this.tipo+"');";
		
		
	}
	
	
}
