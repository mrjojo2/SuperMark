package Controlador;


import java.util.ArrayList; 
import java.util.Scanner;

import Conexion_BD.Conexion;
import Producto.AltaProducto;
import Producto.ProductoCarrito;
import Producto.ProductoStock;
import Producto.ProductosStock;
import SupermarK.Cliente;
import SupermarK.Login;
import SupermarK.MiCuenta;
import SupermarK.Registro;
import SupermarK.Usuario;



public class Principal {

	static Scanner leer= new Scanner (System.in);
	public static void main(String[] args) {

		System.out.println("****............BIENVENIDOS A SUPERMARK................*****");
		System.out.println("****....A CONINUACION ELIGA UNA OPCION...(1) - (2) - (3)****");
		System.out.println("************************************************************");
		System.out.println("************************************************************");
	
	Conexion conn = new Conexion("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark","root","jochis"); 
		
		switch (menu()) {
		case 1:
			Login login=new Login();
			Usuario u=login.loguearme();
						
			if(u!=null) {
				if(u.getTipo().equalsIgnoreCase("c")) {
					MiCuenta mc=new MiCuenta(u);
					
					switch(menuMiCuenta()) {
						case 1:
							mc.mostrarUsuario();
							
						break;
						case 2:
							mc.mostrarCarrito();
						break;
						case 3:
							mc.mostrarHistorial();
						break;
						case 4:
							ProductosStock p=new ProductosStock();
				
							
							do {
								args=new String [1];
								System.out.println("PRODUCTOS");
								do {
									p.mostrar();
									System.out.print("Ingrese el numero del producto:");
									args[0]=leer.nextLine();
									System.out.println(args[0]);
									
									if(Integer.parseInt(args[0])<0 && Integer.parseInt(args[0])<=p.getProductosStock().size()) {
										System.out.println("Ingrese una opcion Valida...");
									}
									
									
								}while(Integer.parseInt(args[0])<0 && Integer.parseInt(args[0])<=p.getProductosStock().size());
								ProductoStock producto=p.getProductosStock().get(Integer.parseInt(args[0]));
								
								do {
									System.out.print("Cantidad:");
									args[0]=leer.nextLine();
									
									
									if(Integer.parseInt(args[0])>producto.getStock()|| Integer.parseInt(args[0])<0) {
										System.out.println("La cantidad ingresada no es valida...");
									}
									
									
								}while(Integer.parseInt(args[0])>producto.getStock()|| Integer.parseInt(args[0])<0);
								
								System.out.println("El producto fue agregado con exito");
								mc.getCarrito().agregar(new ProductoCarrito(producto.getId(),producto.getNombre(),producto.getMarca(),producto.getCategoria(),producto.getDescripcion(),producto.getPrecio(),Integer.parseInt(args[0])));
								System.out.println("�Desea seguir agregando?[s/n]");
								args[0]=leer.nextLine();
								
							}while(args[0].equalsIgnoreCase("s"));
							
							System.out.println("1. Ver Carrito");
							System.out.println("2. Finalizar Compra");
							System.out.println("0. Salir");
							System.out.print("Ingrese opcion:");
							args[0]=leer.nextLine();
							
							switch(Integer.parseInt(args[0])) {
								case 1:
									mc.mostrarCarrito();
								break;
								case 2:
									mc.mostrarCarrito();
									if(mc.comprar()) {
										System.out.println("La Compra se realizo con exito");
									}
									else System.out.println("Error no se pudo concretar la compra");
								break;
								

							}
							
						break;
							
						default:
							System.out.println("Saliendo de Supermark");
						
					
					}
					
				/*	System.out.println("Presionar cualquier tecla para continuar...");
					leer.nextLine();
					menuMiCuenta();*/
				}
				else {
						
						switch(menuAdministracion()) {
							case 1:
								
								System.out.println("Productos");
								ProductosStock p=new ProductosStock();
								//p.mostrar();
								
								switch(subMenuAdministacion()) {
									case 1:
										AltaProducto rp=new AltaProducto();
										String rta="";
											do {
												if(rp.registrar()) {
													limpiarPantalla();
													System.out.println("¡Registro Exitoso!");
													System.out.println("Desea seguir ingresando?[s(si)/n(no)]");
													rta=leer.nextLine();
												}
												else {
														System.out.println("Se produjo un error");
														rta="n";
												}
												
											}while(rta.equalsIgnoreCase("s"));
										
									break;
									case 2:
										
										do {
											limpiarPantalla();
											p.mostrar();
											do {
												System.out.print("Ingrese el numero del producto que desea modificar:");
												rta=leer.nextLine();
												if(Integer.parseInt(rta)<0 || Integer.parseInt(rta)>p.size()) {
													System.out.println("Ingrese una opcion valida...");
												}
												
											}while(Integer.parseInt(rta)<0 || Integer.parseInt(rta)>p.size());
											
											
											limpiarPantalla();
											p.getProductosStock().get(Integer.parseInt(rta)).mostrar();
											String rta2="";
											
											do {
												System.out.println("1. Nombre");
												System.out.println("2. Marca");
												System.out.println("3. Categoria");
												System.out.println("4. Descripcion");
												System.out.println("5. Precio");
												System.out.println("6. Costo");
												System.out.println("7. Stock");
												System.out.println("0. Cancelar");
												System.out.print("Ingrese una opcion:");
												
											}while(Integer.parseInt(rta)<0 || Integer.parseInt(rta)>7);
											
											
											
										}while(rta.equalsIgnoreCase("s"));
										
										
										
									break;
									case 3:
										
										
										do {
											limpiarPantalla();
											p.mostrar();
											do {
												System.out.print("Ingrese el numero del producto que desea eliminar:");
												rta=leer.nextLine();
												if(Integer.parseInt(rta)<0 || Integer.parseInt(rta)>p.size()) {
													System.out.println("Ingrese una opcion valida...");
												}
												
											}while(Integer.parseInt(rta)<0 || Integer.parseInt(rta)>p.size());
											
											
											if(p.borrar(Integer.parseInt(rta))) {	
												System.out.println("¡Eliminacion Exitosa!");
												System.out.println("Desea seguir eliminando?[s(si)/n(no)]");
												rta=leer.nextLine();
											}
											else {
													System.out.println("Se produjo un error");
													rta="n";
											}
											
										}while(rta.equalsIgnoreCase("s"));
										
									break;
								}
							break;
							case 2:
								System.out.println("Clientes");
								
								conn.conectar(); //conexion a la base de datos
								
								String [] registros=conn.select("select * from Clientes;").split(";");
								String [] registro;
								ArrayList <Cliente> clientes=new ArrayList<Cliente>();
								
								for(int i=0;i<registros.length;i++) {
									registro=registros[i].split(",");
									clientes.add(new Cliente(Integer.parseInt(registro[0]),registro[1],registro[2],registro[3],registro[4],registro[5],registro[6]));
								}
								
								if(clientes.size()!=0) {
									for(int i=0;i<clientes.size();i++) {
										clientes.get(i).mostrar();
									}
								}
								else System.out.println("No hay nada para mostrar");
								
							break;
							case 3:
								System.out.println("Ventas");
								
								conn.conectar();
								String [] rs=conn.select("select clientes.cliente_id,clientes.nombre,clientes.apellido,ventas.venta_id,ventas.fecha,productos.nombre,productos.marca,productos.categoria,productos.descripcion,productos.precio_venta,detalle_venta.cantidad from Clientes \r\n"
										+ "inner join Ventas using(cliente_id) \r\n"
										+ "inner join detalle_venta using(venta_id) \r\n"
										+ "inner join productos using(producto_id)\r\n"
										+ "order by 1;").split(";");
								String [] r;
								ArrayList <Cliente> cs =new ArrayList<Cliente>();
								
								for(int i=0;i<rs.length;i++) {
									
								}
								
							break;
						}
						System.out.println("Presionar cualquier tecla para continuar...");
						//leer.nextLine();
						//menuAdministracion();
				}
				
			}
			
			
			
		break;
		case 2:
			System.out.println("Iniciando Registro...");
			Registro registro = new Registro();
			registro.Registrarme();
			
		break;
		default:
			System.out.println("Usted esta saliendo de SuperMark...");
			
		}
				
	} // cierre de metodo main

	public static int menu(){
		String rta;
		
		
		
		do {
			System.out.println("1. Iniciar sesion");
			System.out.println("2. Iniciar Registro");
			System.out.println("0. Salir");
			rta = leer.nextLine();
						
			if(rta.equalsIgnoreCase("0")==false && rta.equalsIgnoreCase("1")==false && rta.equalsIgnoreCase("2")==false){
				System.out.println("ingrese de verdad un opcion valida...");
			}
			
		} while (rta.equalsIgnoreCase("0")==false && rta.equalsIgnoreCase("1")==false && rta.equalsIgnoreCase("2")==false);
		 
		
		return Integer.parseInt(rta);
				
	}
	
	
	public static int menuMiCuenta() {
		String rta;
		
		do {
			limpiarPantalla();
			System.out.println("---------------------------------");
			System.out.println("1. Ver Usuario");
			System.out.println("2. Ver Carrito");
			System.out.println("3. Ver Historial de Compras");
			System.out.println("4. Comprar");
			System.out.println("0. Salir");
			System.out.print("Ingrese una opcion:");
			rta=leer.nextLine();
			
			if(rta.equalsIgnoreCase("0")==false && rta.equalsIgnoreCase("1")==false && rta.equalsIgnoreCase("2")==false && rta.equalsIgnoreCase("3")==false && rta.equalsIgnoreCase("4")==false) {
				System.out.println("Ingrese una opcion Valida...");
			}
			
		}while(rta.equalsIgnoreCase("0")==false && rta.equalsIgnoreCase("1")==false && rta.equalsIgnoreCase("2")==false && rta.equalsIgnoreCase("3")==false && rta.equalsIgnoreCase("4")==false);
		
		return Integer.parseInt(rta);
	}
	
	public static int menuAdministracion() {
		String rta;
		
		do {
			limpiarPantalla();
			System.out.println("1. Operar con Productos");
			System.out.println("2. Listar Clientes");
			System.out.println("3. Ventas");
			System.out.println("0. Salir");
			System.out.print("Ingrese una opcion:");
			rta=leer.nextLine();
			
			if(rta.equalsIgnoreCase("0")==false && rta.equalsIgnoreCase("1")==false && rta.equalsIgnoreCase("2")==false && rta.equalsIgnoreCase("3")==false) {
				System.out.println("Ingrese una opcion Valida...");
			}
			
		}while(rta.equalsIgnoreCase("0")==false && rta.equalsIgnoreCase("1")==false && rta.equalsIgnoreCase("2")==false && rta.equalsIgnoreCase("3")==false);
		
		
		
		return Integer.parseInt(rta);
	}
	
	public static int subMenuAdministacion() {
		
		String rta;
		
		do {
			
			System.out.println("1. Agregar Producto");
			System.out.println("2. Actualizar Producto");
			System.out.println("3. Eliminar Producto");
			System.out.println("0. Salir");
			System.out.print("Ingrese una opcion:");
			rta=leer.nextLine();
			
			if(rta.equalsIgnoreCase("0")==false && rta.equalsIgnoreCase("1")==false && rta.equalsIgnoreCase("2")==false && rta.equalsIgnoreCase("3")==false) {
				System.out.println("Ingrese una opcion Valida...");
			}
			
		}while(rta.equalsIgnoreCase("0")==false && rta.equalsIgnoreCase("1")==false && rta.equalsIgnoreCase("2")==false && rta.equalsIgnoreCase("3")==false);
		
		
		return Integer.parseInt(rta);
		
	}

	
	public String validarNombre (String nombre){
		
		while(nombre.equalsIgnoreCase("")){
		    System.out.print("Ingrese un Nombre*: ");
			nombre=leer.nextLine();
			if (!nombre.matches("^[A-Za-z ]*$")){
				nombre="";
		} 
								
	}return nombre;
	
	
	}

	public static void limpiarPantalla() {
		 System.out.print("\033[H\033[2J");
	     System.out.flush();
	}
} // cierre de la clase
