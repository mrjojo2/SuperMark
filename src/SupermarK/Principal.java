package SupermarK;


import java.util.Scanner;


public class Principal {

	static Scanner leer= new Scanner (System.in);
	public static void main(String[] args) {

		System.out.println("****............BIENVENIDOS A SUPERMARK................*****");
		System.out.println("****....A CONINUACION ELIGA UNA OPCION...(1) - (2) - (3)****");
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		switch (menu()) {
		case 1:
			System.out.println("Iniciando Sesion...");
			Login loguearme = new Login();
			loguearme.loguearme();
						
		break;
		case 2:
			System.out.println("Iniciando Registro...");
			Registro registro=new Registro();
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
	
	
	
} // cierre de la clase
