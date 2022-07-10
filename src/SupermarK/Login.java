package SupermarK;

import java.util.Scanner;

import Conexion_BD.Conexion;

public class Login {

	public Usuario loguearme() {
		
		String email;
		String clave;
		String subclave="";
		String subtipo="";
		Usuario usuario=null;
		Scanner leerScanner=new Scanner(System.in);
		
		
		System.out.println("Complete los campos");
		System.out.println("");
		System.out.print("Email:");   // no hace falta validar ya que de lo contrario no podria loguearse
		email=leerScanner.nextLine();
		System.out.println();

		System.out.print("Clave:");  // no hace falta validar ya que de lo contrario no podria loguearse
		clave=leerScanner.nextLine();
		System.out.println();
		
		Conexion conn =new Conexion("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark" ,"root","jochis");
		
		if(conn.conectar()==false) {
			System.out.println("Error en la conexion");
		}
		else {
			subclave=conn.select("select clave from Usuarios where email='"+email+"';");
						
			if(subclave.equalsIgnoreCase("")) {
				System.out.println("El usuario:"+email+" no se encuentra registrado. Registrese.");
			}
			else {
				
				subclave=subclave.substring(0, subclave.length()-1);  // le saco el punto y coma a la clave devuelta para poder compararla;
			
				if (subclave.equalsIgnoreCase(clave)){
					
					subtipo=conn.select("select tipo from Usuarios where email='"+email+"';");
										
					subtipo=subtipo.substring(0, subtipo.length()-1);
					
					System.out.println("Bienvenute a Supermakute");
					
					usuario = new Usuario(email, clave, subtipo);
					
						
			/*	String [] ct=subclave.split(",");	// transformo en vector lo devuelto
				
				
				if(ct[0].compareTo(clave)==0) {    // comparar  la posicion uno (clave devuleta) con la clave
				
									
					System.out.println("Bienvenute a Supermarkute");
					
				usuario =new Usuario(email,clave,ct[2]);  // Creo un usuario con email, clave y tipo */
				}
				else System.out.println("Error la contrseña no corresponde al usuario "+email);
				
			}
		}
		
		return usuario;
		
	}

}
