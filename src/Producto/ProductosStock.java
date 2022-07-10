package Producto;


import java.util.ArrayList;

import Conexion_BD.Conexion;

public class ProductosStock {
private ArrayList<ProductoStock> productos;
	
	public ProductosStock() {
		this.productos=new ArrayList<ProductoStock>();
		obtener();
	}
	
	public ArrayList<ProductoStock> getProductosStock() {
		return this.productos;
	}
	
	private void obtener() {
		
		Conexion conn =new Conexion("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark" ,"root","jochis");
		
		if(conn.conectar()) {
			
			String string=conn.select("select producto_id,nombre,marca,categoria,descripcion,precio_venta,stock,costo from Productos where stock>0;");
			if(string.equalsIgnoreCase("")==false) {
				String [] registros=string.split(";"); // dividimos el resultado en el punto y coma (x tuplas)
				
				
				for(int i=0;i<registros.length;i++) {   
					String [] registro=registros[i].split(","); // separamos la tupla en la coma y nos queda los campos
					productos.add(new ProductoStock(Integer.parseInt(registro[0]), registro[1], registro[2], registro[3], registro[4],Double.parseDouble(registro[5]),Integer.parseInt(registro[6]),Double.parseDouble(registro[7])));
				
				}
				
			}
			
			
		}
		else System.out.println("Error en la conexion. Intente mas tarde...");
		
		conn.cerrar();
	}
	
	public int size() {
		return this.productos.size();
	}
	
	public void mostrar() {
		if(this.productos.size()!=0) {
			for(int i=0;i<this.productos.size();i++) {
				System.out.println("_______________________________________");
				System.out.println("                  "+i+"                ");
				this.productos.get(i).mostrar();
				System.out.println("_______________________________________");
			}
		}
		else System.out.println("Nada para mostrar");
		
	}
	
	public boolean borrar(int pos) {
		Conexion conn=new Conexion("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark" ,"root","jochis");
		if(conn.conectar()) {
			if(conn.insert("delete from Productos where producto_id="+this.productos.get(pos).getId())) {
				this.productos.remove(pos);
				conn.cerrar();
				return true;
			}
			else {
					conn.cerrar();
					return false;
			}
			
		}
		else return false;
		
	}
	
}
