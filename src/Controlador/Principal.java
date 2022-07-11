package Controlador;

import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Scanner;
import Conexion_BD.Conexion;
import Conexion_BD.ConexionBD;
import Producto.ProductoCarrito;
import Producto.ProductoStock;
import Producto.*;
import SupermarK.Cliente;
import SupermarK.GestionCliente;
import SupermarK.Login;
import SupermarK.MiCuenta;
import SupermarK.Registro;
import SupermarK.Usuario;



public class Principal {
	static ConexionBD conn = new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","AYATA88");
	static Scanner leer= new Scanner (System.in);
	public static void main(String[] args) {

		System.out.println("****............BIENVENIDOS A SUPERMARK................*****");
		System.out.println("****....A CONINUACION ELIGA UNA OPCION...(1) - (2) - (3)****");
		System.out.println("************************************************************");
		System.out.println("************************************************************");
	
		 

		switch(menu()) {
		case 1:
			Login login=new Login();
			Usuario u=login.loguearme(); 
			
			if(u!=null) {                   // si el logueo funcion crea un usuario llamado u
				if(u.getTipo().equalsIgnoreCase("c")) {  // compara si la persona que ingresa es un Cliente o Adminstrado, si es Cliente continua laejecucion
					MiCuenta mc=new MiCuenta(u);
					switch(menuMiCuenta()) {
					case 1:
						mc.mostrarUsuario();  // muestra el usuario -  opicon (01) ver usuario
						
					break;
					case 2:
						mc.getCarrito().mostrar();  // muesta el carrito - opcion (02) ver carrito
					break;
					case 3:
						//mc.mostrarHistorial();   // muestra el historial de compras - opcion (03) - historial
					break;
					case 4:
						String rta="";
						GestionCliente gc=new GestionCliente();
						mc.getCarrito().setProductos(gc.llenarCarrito(mc.getCarrito()));
						
						mc.getCarrito().mostrar();
						System.out.println("¿Desea Confirmar la compra?[Y/N]");
						rta=leer.nextLine();
						if(rta.equalsIgnoreCase("y")) {
							gc.confirmarCompra(mc.getUsuario(), mc.getCarrito());
						}else {
							System.out.println("Compra Cancelada");
						}
						break;
					case 0:
						System.out.println("Saliendo del sistema");
						break;
					}
				
				}else {
					boolean ban=true;
					do {
						switch(menuAdministracion()) {
						case 1:
							menuAdminProducto();
							break;
						case 2:
							System.out.println("--------------Lista de Clientes-------------");
							listarClientes();
							break;
						case 3:
							System.out.println("********************Ventas********************");
							break;
						case 0:
							System.out.println("Saliendo del menu");
							break;
						}
						
						System.out.println("¿Desea realizar otra operacion?[S/N]");
						String r=leer.nextLine();
						if(r.equalsIgnoreCase("s")) {
							ban=true;
						}else ban=false;
					}while(ban==true);
				}
			}
			break;
		case 2:
			System.out.println("Iniciando Registro...");  
			Registro registro = new Registro(); // creo un objeto Registro
			registro.Registrarme();  // incia el registro
			break;
		case 0:
			System.out.println("Usted esta saliendo de SuperMark...");
			break;
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
			System.out.println("Bienvenido Administrador seleccione que desea realizar");
			System.out.println("---------------------------------");
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
	
	//CRISTIAN MENU PARA ADMINISTRAR PRODUCTO
	public static void menuAdminProducto() {
		Scanner entrada=new Scanner(System.in);
		int op;
		do {
			
			do {
				System.out.println("---Menu Administracion Stock---");
				System.out.println("1)- Alta Producto");
				System.out.println("2)- Modificar Producto");
				System.out.println("3)- Baja Producto");
				System.out.println("4)- Ver Stock");
				System.out.println("0)- Salir");
				op=entrada.nextInt();
				entrada.nextLine();
			}while(op<0 || op>4);
			
			switch(op) {
			case 1:
				AltaProducto alta=new AltaProducto();
				if(alta.resgitrarProducto()) {
					System.out.println("Registro exitoso");
				}else {
					System.out.println("No se pudo realizar el alta");
				}
				break;
			case 2:
				ModificarProducto actualizarPro=new ModificarProducto();
				actualizarPro.modificarForm();
				break;
			case 3:
				BajaProducto baja=new BajaProducto();
				
				baja.bajaProducto();
				break;
			case 0:
				System.out.println("Saliendo del Formulario");
				break;
			case 4:
				System.out.println("Ver Stock");
				ListarStock productos=new ListarStock();
				productos.mostrar();
				break;
			}
			System.out.println("Presione enter para continuar");
			entrada.nextLine();
		}while(op!=0);
		
		entrada.close();
		
	}
	public static void listarClientes() {
		
		if(conn.abrirConecion()) {
			String string=conn.selectBD("Select * from clientes;");
			if(string.equalsIgnoreCase("")==false) {
				String[] registros=string.split(";");
				ArrayList<Cliente> clientes=new ArrayList<Cliente>();
				for(int i=0;i<registros.length;i++) {
					String[] campos=registros[i].split(",");
					Cliente cl=new Cliente(Integer.parseInt(campos[0]),campos[2],campos[3],campos[4],campos[5],campos[6],campos[7]);
					clientes.add(cl);
				}
				for(int i=0;i<clientes.size();i++) {
					System.out.println("____________________________________");
					clientes.get(i).mostrar();
					System.out.println("____________________________________");
					System.out.println();
				}
				conn.cerrarConexion();
			}else {
				System.out.println("No hay Clientes para mostrar");
				conn.cerrarConexion();
			}
			
		}else {
			System.out.println("Error en la coneccion intente nuevamente mas tarde.");
		}
		
	}

} // cierre de la clase
