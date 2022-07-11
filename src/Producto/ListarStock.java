package Producto;
import java.util.ArrayList;

import Conexion_BD.ConexionBD;

public class ListarStock {
	//Esta clase sirve para listar los productos
	private ArrayList<ProductoStock> productos;
	
	
	public ListarStock() {
		this.productos=new ArrayList<ProductoStock>();	
	}
	
	public int getSize() {
		return this.productos.size();
	}
	
	
	
	public ArrayList<ProductoStock> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoStock> productos) {
		this.productos = productos;
	}

	public void Todo() {
		ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
		
		String consulta="Select * from producto;";
		if(con.abrirConecion()) {
			
			String resultado=con.selectBD(consulta);
			if(resultado.equalsIgnoreCase("")==false) {
				String[] registro=resultado.split(";");
				for(int i=0;i<registro.length;i++) {
					String[] campos=registro[i].split(",");
					this.productos.add(new ProductoStock(Integer.parseInt(campos[0]),campos[1],campos[2],campos[3],campos[4],Integer.parseInt(campos[5]),Double.parseDouble(campos[6]),Double.parseDouble(campos[7])));
				}
			}
		}else {
			System.out.println("error de conexion");
		}
		con.cerrarConexion();
	}
	
	public void stockCliente() {
		ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
		
		String consulta="Select * from producto where stock>0;";
		if(con.abrirConecion()) {
			
			String resultado=con.selectBD(consulta);
			if(resultado.equalsIgnoreCase("")==false) {
				String[] registro=resultado.split(";");
				for(int i=0;i<registro.length;i++) {
					String[] campos=registro[i].split(",");
					this.productos.add(new ProductoStock(Integer.parseInt(campos[0]),campos[1],campos[2],campos[3],campos[4],Integer.parseInt(campos[5]),Double.parseDouble(campos[6]),Double.parseDouble(campos[7])));
				}
			}
		}else {
			System.out.println("error de conexion");
		}
		con.cerrarConexion();
	}
	
	public void mostrar() {
		Todo();
		System.out.println("***FORMULARIO PRODUCTO STOCK***");
		System.out.println("---Ver Stock---");
		if(this.productos.size()!=0) {
			
			for (int i=0;i<this.productos.size();i++) {
				System.out.println("--------------"+(i+1)+"---------------");
				this.productos.get(i).mostrarProducto();
				System.out.println("__________________________________");
				System.out.println();
			}
		}else {
			System.out.println("No hay nada que mostrar.");
		}
	}
	
	public void mostrarProdCliente() {
		stockCliente();
		System.out.println("***FORMULARIO PRODUCTO STOCK***");
		System.out.println("---Ver Stock---");
		if(this.productos.size()!=0) {
			
			for (int i=0;i<this.productos.size();i++) {
				System.out.println("-------------- N° Producto "+(i+1)+" ---------------");
				this.productos.get(i).mostrarProductoCliente();
				System.out.println("____________________________________________________");
				System.out.println();
			}
		}else {
			System.out.println("No hay nada que mostrar.");
		}
	}
	
}
