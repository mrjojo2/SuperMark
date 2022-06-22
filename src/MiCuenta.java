
public class MiCuenta {
	private Usuario usuario;
	private Carrito carrito;
	private Compras compras;
	//private Producto acomprar;

	public MiCuenta(Usuario usuario, Carrito carrito, Compras compra) {
		this.usuario = usuario;
		this.carrito = carrito;
		this.compras = compra;
	}

	
	public void mostrarUsuario (){
		
	}
	
	public void mostrarCompras (){
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Compras getCompras() {
		return compras;
	}

	public void setCompra(Compras compra) {
		this.compra = compra;
	}
	
	
}// cierre de clase
