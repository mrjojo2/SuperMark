package SupermarK;

public class Usuario {

	private String email;
	private String clave;
	
	public Usuario(String email, String clave) {
		super();
		this.email = email;
		this.clave = clave;
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
	
	public String creaQueryInsert(){
		return "insert INTO Usuarios (email, clave) values ('"+this.email+"','"+this.clave+"');";
	}
	
	
	// hacer validacion con Expreciones Regulare	
}
