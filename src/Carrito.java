import java.sql.Date;
import java.util.ArrayList;

public class Carrito {
	private ArrayList <ProductoCarrito> productos;
	private flota total;
	private Date fecha;
	private int codigo;

	public Carrito(ArrayList productos, flota total, Date fecha, int codigo) {
		this.productos = productos;
		this.total = total;
		this.fecha = fecha;
		this.codigo = codigo;
	}

	public ArrayList<ProductoCarrito> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoCarrito> productos) {
		this.productos = productos;
	}

	public flota getTotal() {
		return total;
	}

	public void setTotal(flota total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
// metodos :	realizar pedido boleean
	
// metodo :  	mostrar 
	
	
	
} // cierre de clase

	
	
	
}
