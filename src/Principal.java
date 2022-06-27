import java.util.Scanner;


public class Principal {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Bienvenidos a SUPERMARK");
		System.out.println("A continuación elije una opcion");
		System.out.println("*******************************************");
		System.out.println("1. Loguearse");
		System.out.println("2. Registrarse");
		System.out.println("3. Salir");
		System.out.println("Ingrese opcion:");
		int op = sc.nextInt();
		
		menu(op);
		

		
		
		
		
		
		
	}
	
	public static void menu(int a) {
				
	
		switch( a )
		{
		case 1:
		System.out.println("Ingresando a menu Log-in....");
		break;
		case 2:
		System.out.println("Ingresando a menu registro...");
		break;
		case 3:
		System.out.println("Gracias por visitar SUPERMARK... VUELVA PRONTO");
		break;
		default:
		System.out.println("Valor incorrecto... El valor debe ser entre 1 y 3.");
		}
				
	}		
		
		/*
		
		switch (op) {
		case 1: 
			Login login=new Login();
			
			if(login.loguearme()==0) {
				System.out.println("Error al loguearse intente mas tarde...");
			}
			
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);    */
	
}

