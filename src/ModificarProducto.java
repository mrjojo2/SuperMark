
import java.util.Scanner;

public class ModificarProducto {
	Scanner teclado=new Scanner(System.in);
	
	final ConexionBD conexion=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
	
	// hacer metodo modificar producto
	public void modificarForm() {
		
		int idBuscado;
		//Scanner entrada=new Scanner(System.in);
		System.out.println("---FORMULARIO STOCK---");
		System.out.println("Modificar Producto");
		 
		System.out.println("Ingrese id del producto a modificar");
		idBuscado=teclado.nextInt();
		//teclado.close();
		
		modificado(ProductoStock.buscarProducto(idBuscado));
		
		
		
		
	}
	
	public int opcionCampo() {
		
		//Scanner teclado=new Scanner(System.in);
		int op=0;
		boolean condicion=false;
		do {
			System.out.println("Seleccione el campo a modificar");
			System.out.println("1-Nombre.");
			System.out.println("2-Descripcion.");
			System.out.println("3-Marca.");
			System.out.println("4-Categoría.");
			System.out.println("5-Stock.");
			System.out.println("6-Costo.");
			System.out.println("7-Precio venta.");
			System.out.println("0-Salir.");
			op=teclado.nextInt();
			if(op<=7 && op>=0) {
				condicion=true;
			}else System.out.println("Opcion invalida");
		}while(condicion==false);
		//teclado.close();
		return op;
	}
	
	public void modificado(ProductoStock producto) {
		Scanner teclado=new Scanner(System.in);
		String nuevoValor="";
		String rta="";
		boolean seguir=true;
		producto.mostrarProducto();
		do {
			switch(opcionCampo()) {
				case 1:
					System.out.println("Ingrese el nuevo valor para el campo nombre.");
					nuevoValor=teclado.nextLine();
					producto.setNombre(nuevoValor);
					conexion.conectar();
					conexion.realizarUpdate(producto.modificarCampo("nombre", producto.getNombre()));
					conexion.cerrarConexion();
					break;
				case 2:
					System.out.println("Ingrese la nueva descripcion.");
					nuevoValor=teclado.nextLine();
					producto.setDescripcion(nuevoValor);
					conexion.conectar();
					conexion.realizarUpdate(producto.modificarCampo("descripcion", producto.getDescripcion()));
					conexion.cerrarConexion();
					break;
				case 3:
					System.out.println("Ingrese el nuevo valor para el campo marca.");
					nuevoValor=teclado.nextLine();
					producto.setMarca(nuevoValor);
					conexion.conectar();
					conexion.realizarUpdate(producto.modificarCampo("marca", producto.getMarca()));
					conexion.cerrarConexion();
					break;
				case 4:
					System.out.println("Ingrese el nuevo valor para el campo categoría.");
					nuevoValor=teclado.nextLine();
					producto.setCategoria(nuevoValor);
					conexion.conectar();
					conexion.realizarUpdate(producto.modificarCampo("categoria", producto.getCategoria()));
					conexion.cerrarConexion();
					break;
				case 5:
					System.out.println("Actualizar Stock.");
					nuevoValor=teclado.nextLine();
					if(validarNumeroInt(nuevoValor)) {
						producto.setStock(Integer.parseInt(nuevoValor));
						conexion.conectar();
						conexion.realizarUpdate(producto.modificarCampo("stock", producto.getStock()));
						conexion.cerrarConexion();
					}
					break;
				case 6:
					System.out.println("Actualizar Costo.");
					nuevoValor=teclado.nextLine();
					if(validarNumeroDouble(nuevoValor)) {
						producto.setCosto(Double.parseDouble(nuevoValor));
						conexion.conectar();
						conexion.realizarUpdate(producto.modificarCampo("costo", producto.getCosto()));
						conexion.cerrarConexion();
					}
					break;
				case 7:{
					System.out.println("Actualizar Precio.");
					nuevoValor=teclado.nextLine();
					if(validarNumeroDouble(nuevoValor)) {
						producto.setPrecio(Double.parseDouble(nuevoValor));
						conexion.conectar();
						conexion.realizarUpdate(producto.modificarCampo("precio", producto.getPrecio()));
						conexion.cerrarConexion();
					}
				}
					
					break;
				case 0:
					System.out.println("fin de modificacion");
					
			}
			System.out.println("¿Desea modificar otro campo? SI/NO");
			rta=teclado.nextLine();
			if(rta.equalsIgnoreCase("SI")) {
				seguir=true;
			}else {
				seguir=false;
			}
		}while(seguir);
		
		//teclado.close();
	}
	
	public void modificar(ProductoStock producto) {
		//Scanner teclado=new Scanner(System.in);
		System.out.println("Valores actuales del Producto: ");
		producto.mostrarProducto();
		producto.mostrarProducto();
		String[] campos= {"Nombre","Descripción","Marca","Categoría","Stock","Costo","Precio"};
		String[] valores= {producto.getNombre(),producto.getDescripcion(),producto.getMarca(),producto.getCategoria(),Integer.toString(producto.getStock()),Double.toString(producto.getCosto()),Double.toString(producto.getPrecio())};
		
		for(int i=0;i<7;i++) {
			String nuevoValor="";
			int conf=0;
			do {
				System.out.println("Desea modificar el campo "+campos[i]+": "+valores[i]);
				System.out.println("1-SI");
				System.out.println("2-NO");
				conf=teclado.nextInt();
				if(conf!=1 || conf!=2) {
					System.out.println("Selecciones la opcion correcta 1 o 2");
				}
			}while(conf!=1 || conf!=2);
			if(conf==1) {
				if(campos[i].equalsIgnoreCase("Stock")) {
					do {
						System.out.println("Ingrese el nuevo valor para el campo "+campos[i]);
						nuevoValor=teclado.nextLine();
						if(validarNumeroInt(nuevoValor)) {
							valores[i]=nuevoValor;
						}else {
							System.out.println("ingrese un valor de tipo entero");
						}
					}while(validarNumeroInt(nuevoValor));
				}else {
					if(campos[i].equalsIgnoreCase("Costo") || campos[i].equalsIgnoreCase("Precio")) {
						do {
							System.out.println("Ingrese el nuevo valor para el campo "+campos[i]);
							nuevoValor=teclado.nextLine();
							if(validarNumeroDouble(nuevoValor)) {
								valores[i]=nuevoValor;
							}else {
								System.out.println("ingrese un valor de tipo decimal");
							}
						}while(validarNumeroDouble(nuevoValor));
					}else {
						System.out.println("Ingrese el nuevo valor para el campo "+campos[i]);
						valores[i]=teclado.nextLine();
					}	
				}
			}
		}
		//teclado.close();
		producto.setNombre(valores[0]);
		producto.setDescripcion(valores[1]);
		producto.setMarca(valores[2]);
		producto.setCategoria(valores[3]);
		producto.setStock(Integer.parseInt(valores[4]));
		producto.setCosto(Double.parseDouble(valores[5]));
		producto.setPrecio(Double.parseDouble(valores[6]));
		
	}
	
	public boolean validarCampos(String nombre,String desc,String marca,String categ,String stock,String costo,String precio) {
		if(nombre.equalsIgnoreCase("")==false && desc.equalsIgnoreCase("")==false && marca.equalsIgnoreCase("")==false && validarNumeroInt(stock)==true && validarNumeroDouble(costo)==true && validarNumeroDouble(precio)) {
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
	
}
