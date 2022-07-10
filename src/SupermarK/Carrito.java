package SupermarK;

import java.util.ArrayList;

import Producto.Producto;
import Producto.ProductoCarrito;

public class Carrito {
	private String fecha;
	private int id;
	private ArrayList <ProductoCarrito> productos;
	
	public Carrito () {
		this.id=0;
		this.productos=new ArrayList<ProductoCarrito>();
	}
	
	public Carrito(String fecha,int id) {
		this.fecha=fecha;
		this.id=id;
		this.productos=new ArrayList<ProductoCarrito>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void agregar(ProductoCarrito nuevo) {
		
		if(this.productos.size()<30) {
			this.productos.add(nuevo);
		}
		else System.out.println("No se pueden agregar mas productos. Realice otra compra");
		
	}
	
	public Producto buscar(int pos) {
		
		if(pos>0 && pos<this.productos.size()) {
			return this.productos.get(pos);
		}
		else return null;
		
	}
	
	public void quitar(int pos) {

		if(pos>0 && pos<this.productos.size()) {
			this.productos.remove(pos);
		}
		else System.err.println("Error");;
		
	}
	
	public void mostrar() {
		double total=0;
		System.out.println("Fecha:"+this.fecha);
		if(this.productos.size()!=0) {
			for(int i=0;i<this.productos.size();i++) {
				this.productos.get(i).mostrar();
				total=total+this.productos.get(i).getCantidad()*this.productos.get(i).getPrecio();
			}
			System.out.println("Total:"+total);
		}
		else System.out.println("Carrito vacio");
		
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ArrayList<ProductoCarrito> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoCarrito> productos) {
		this.productos = productos;
	}
	
	
	
} // cierre de clase

