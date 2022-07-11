package SupermarK;

import java.util.ArrayList;

import Conexion_BD.Conexion;
import Producto.ProductoCarrito;

public class MiCuenta {
	private Usuario usuario;
	private Carrito carrito;
	private ArrayList <Carrito> historial;

	public MiCuenta(Usuario usuario) {
		super();
		this.usuario = usuario;
		this.carrito = new Carrito();
		this.historial=null;
		//obtenerHistorial();
		
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
	
	public void mostrarUsuario() {
		System.out.println("Usuario:"+this.usuario.getEmail());
	}
	
	public void mostrarCarrito() {
		this.carrito.mostrar();
	}
	
	
} // cierra clase
