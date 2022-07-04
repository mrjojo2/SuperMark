package Producto;
import java.sql.ResultSet;
import java.util.Scanner;

import ConexionBD.ConexionBD;

public class AltaProducto {
	final ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark","root","jochis");

	// hacer metodo registrar producto
	public boolean resgitrarProducto() {
		ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
		//ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");

		Scanner teclado=new Scanner(System.in);

@@ -40,27 +42,31 @@ public boolean resgitrarProducto() {

		//valido los datos ingresados
		if(validarCampos(nombre,descripcion,marca,categoria,stock,costo)==true) {
			ProductoStock nuevoProducto=new ProductoStock(nombre,descripcion,marca,categoria,Integer.parseInt(stock),Float.parseFloat(costo));
			con.conectar();//abro conexion
			con.realizarUpdate(nuevoProducto.generarInsertQuery());//realizo un insert
			con.cerrarConexion();
			return true;
			if(existenciaProducto(nombre,marca)==false) {
				ProductoStock nuevoProducto=new ProductoStock(nombre,descripcion,marca,categoria,Integer.parseInt(stock),Float.parseFloat(costo));
				con.conectar();//abro conexion
				con.realizarUpdate(nuevoProducto.generarInsertQuery());//realizo un insert
				con.cerrarConexion();
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	//metodo para validar campos
	public boolean validarCampos(String nombre,String desc,String marca,String categ,String stock,String costo) {
		if(nombre.equalsIgnoreCase("")==false && desc.equalsIgnoreCase("")==false && marca.equalsIgnoreCase("")==false && validarNumero(stock)==true && validarNumero(costo)==true) {
		if(nombre.equalsIgnoreCase("")==false && desc.equalsIgnoreCase("")==false && marca.equalsIgnoreCase("")==false && validarNumeroInt(stock)==true && validarNumeroFloat(costo)==true) {
			return true;
		}else  {
			return false;
		}
	}

	//metodo para validar un string que es ingresado como numero
	public boolean validarNumero(String num) {
	public boolean validarNumeroInt(String num) {

		try {
			Integer.parseInt(num);
@@ -69,6 +75,42 @@ public boolean validarNumero(String num) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean validarNumeroFloat(String num) {

		try {
			Float.parseFloat(num);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean existenciaProducto(String nombre, String marca) {

		con.conectar();
		ResultSet resultado=con.consultar("Select * from producto where nombre='"+nombre+"' and marca='"+marca+"';");
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

} // cierre de clase