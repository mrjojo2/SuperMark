package Producto;

import java.util.ArrayList;
import java.util.Scanner;

import Conexion_BD.Conexion;



public class AltaProducto {
	public boolean registrar() {
		boolean rta=true;
		
		String [] campos= {"Nombre *:","Marca *:","Categoria *:","Descripcion *:","Stock *:","Costo *:","Precio de Venta *:"};
		String [] datos=new String[7];
		Scanner leerScanner=new Scanner(System.in);
		
		System.out.println("Formulario de Registro de un Nuevo Producto");
		
		for(int i=0;i<campos.length;i++) {
			System.out.print(campos[i]);
			datos[i]=leerScanner.nextLine();
			//System.out.println();
		}
		
		ProductoStock nuevoProductoStock=new ProductoStock(datos[0], datos[1], datos[2], datos[3],Double.parseDouble(datos[6]), Integer.parseInt(datos[4]), Double.parseDouble(datos[5]));
		Conexion conn=new Conexion("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark" ,"root","jochis");
		
		if(conn.conectar()) {
			
			String string=conn.select("select producto_id, nombre,marca,categoria,descripcion,precio_venta from Productos;");
			
			if(string.equalsIgnoreCase("")==false) {
				
				//System.out.println("Pasoooo");
				String [] registros=string.split(";");
				ArrayList< Producto> productoStocks=new ArrayList<Producto>();
				
				
				
				for(int i=0;i<registros.length;i++) {
					String [] registro=registros[i].split(",");
					productoStocks.add(new Producto(Integer.parseInt(registro[0]), registro[1].trim(), registro[2].trim(), registro[3].trim(), registro[4].trim(),Double.parseDouble(registro[5])));
				
				}
				
				for(int i=0;i<registros.length;i++) {
					productoStocks.get(i).mostrar();
				}
				
				int i=0;
				while(i<productoStocks.size() && nuevoProductoStock.iguales(productoStocks.get(i))==false) {
					i++;
				}
				System.out.println(i);
				if(i<productoStocks.size()) {
					System.out.println("El producto ya se ecnuentra registrado el codigo es "+productoStocks.get(i).getId());
					rta=false;
				}
				else {
					
					if(conn.insert(nuevoProductoStock.crearQueryInsert())==false) {
						rta=false;
					}
						
				}
				
				
			}
			else {
				
				if(conn.insert(nuevoProductoStock.crearQueryInsert())==false) {
					rta=false;
				}
					
			}
			
			
			
		}
		else {
				rta=false;
				System.out.println("Error en la conexion");
		}
		
		return rta;
	}
	
}