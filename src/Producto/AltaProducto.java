package Producto;


import java.sql.ResultSet;

import java.util.Scanner;

import Conexion_BD.ConexionBD;

public class AltaProducto {
	final ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");

	// hacer metodo registrar producto
	public boolean resgitrarProducto() {
		//ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
		
		Scanner teclado=new Scanner(System.in);
		boolean rta=false;
		
		String nombre="";
		String descripcion="";
		String marca="";
		String categoria="";
		String stock="";
		String costo="";
		String precio="";
		
		//pido al usuario ingrese los datos del producto
		System.out.println("***FORMULARIO PRODUCTO STOCK***");
		
		System.out.println("---ALTA PRODUCTO---");
		
		System.out.println("Complete los datos del nuevo producto");
		
		System.out.println("Ingrese el Nombre del Producto: ");
		nombre=teclado.nextLine();
		
		System.out.println("Ingrese la descricion del Producto: ");
		descripcion=teclado.nextLine();
		
		System.out.println("Ingrese la marca del Producto: ");
		marca=teclado.nextLine();
		
		System.out.println("Ingrese la categoria del Producto: ");
		categoria=teclado.nextLine();
		
		System.out.println("Ingrese el stock del Producto: ");
		stock=teclado.nextLine();
		
		System.out.println("Ingrese el costo del Producto: ");
		costo=teclado.nextLine();
		
		System.out.println("Ingrese el precio del Producto: ");
		precio=teclado.nextLine();
		
		//teclado.close();
		
		//valido los datos ingresados
		
		if(validarCampos(nombre,descripcion,marca,categoria,stock,costo,precio)==true) {
			String string=queryBuscar(nombre,marca,descripcion);
			if(string.equalsIgnoreCase("")) {
				ProductoStock nuevoProducto=new ProductoStock(nombre,descripcion,marca,categoria,Integer.parseInt(stock),Double.parseDouble(costo),Double.parseDouble(precio));
				con.conectar();
				if(con.realizarUpdate(nuevoProducto.generarInsertQuery())) {
					rta=true;
				}else rta=false;
				con.cerrarConexion();
			}else {
				System.out.println("El producto ya existe");
				rta=false;
			}	
		}else {
			System.out.println("Los valores ingresados son invalidos");
		}
		return rta;
		
	}
	
	//metodo para validar campos
	public boolean validarCampos(String nombre,String desc,String marca,String categ,String stock,String costo,String precio) {
		if(nombre.equalsIgnoreCase("")==false && desc.equalsIgnoreCase("")==false && marca.equalsIgnoreCase("")==false && validarNumeroInt(stock)==true && validarNumeroDouble(costo)==true && validarNumeroDouble(precio)==true) {
			return true;
		}else  {
			return false;
		}
	}
	
	//metodo para validar un string que es ingresado como numero
	public boolean validarNumeroInt(String num) {
		
		try {
			Integer.parseInt(num);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public boolean validarNumeroDouble(String num) {
		
		try {
			Double.parseDouble(num);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public boolean existenciaProducto(String nombre, String marca, String descripcion) {
		
		con.conectar();
		ResultSet resultado=con.consultar("Select * from producto where nombre='"+nombre+"' and marca='"+marca+"' and descripcion='"+descripcion+"';");
		int cont=0;
		try {
			while(resultado.next()) {
				cont++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		con.cerrarConexion();
		if(cont==0) {
			return false;
		}else {
			return true;
		}
	}
	
	public String queryBuscar(String nombre, String marca,String descripcion) {
		con.conectar();
		String registros=con.selectBD("Select * from producto where nombre='"+nombre+"' and marca='"+marca+"' and descripcion='"+descripcion+"';");
		con.cerrarConexion();
		return registros;
	}
	
} // cierre de clase

