package Controlador;


import java.util.Scanner;

import SupermarK.Login;
import SupermarK.Registro;



public class Principal {

	static Scanner leer= new Scanner (System.in);
	public static void main(String[] args) {

		System.out.println("****............BIENVENIDOS A SUPERMARK................*****");
		System.out.println("****....A CONINUACION ELIGA UNA OPCION...(1) - (2) - (3)****");
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		
		
		switch (menu()) {
		case 1:
			System.out.println("Iniciando Menu Loging...");
			Login login = new Login();
			login.loguearme();
			
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
