
import java.util.ArrayList;

public class Carrito {
	private ArrayList <ProductoCarrito> productos;
	private double total;
	private String fecha;
	private int codigo;
	
	public Carrito() {
		this.fecha="";
		this.total=0;
		this.codigo=0;
		productos=new ArrayList<ProductoCarrito>();
	}
	public Carrito(String fecha, int codigo) {
		this.productos = new ArrayList<ProductoCarrito>();
		this.total = 0;
		this.fecha = fecha;
		this.codigo = codigo;
	}

	public ArrayList<ProductoCarrito> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoCarrito> productos) {
		this.productos = productos;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
// metodos :	realizar pedido boleean
	
	
	public void agregarProducto(ProductoCarrito nuevo) {
		if(this.productos.size()<=30) {
			this.productos.add(nuevo);
		}else {
			System.out.println("Se ha llegado al limite de compra 30 articulos");
		}
	}
	
	public void quitarProducto(int pos) {
		if(pos>0 && pos <= this.productos.size()) {
			this.productos.remove(pos);
		}else {
			System.out.println("Posicion invalida");
		}
	}
	
// metodo mostrar 
	
	public void mostrar() {
		if(this.productos.size()!=0) {
			System.out.println("------Mi Carrito------");
			for(int i=0;i<this.productos.size();i++) {
				System.out.println(":::::::::::::::: N° Producto"+(i+1)+" ::::::::::::::");
				this.productos.get(i).mostrar();
				System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
				System.out.println();
			}
			System.out.println("Total : $"+this.total);
		}else {
			System.out.println("No hay Productos en el carrito");
		}
	}
	
	public void confirmar(int idUsuario) {
		if(this.productos.size()!=0) {
			
		}
	}
	
	
} // cierre de clase

	
	
	

