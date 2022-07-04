package SupermarK;

import java.util.Scanner;



public class Login {

	public boolean loguearme(){
		boolean rta=true;
		
		String email;
		String clave;
		
		
		Scanner sc =new Scanner (System.in);
		
		System.out.println("SUPERMARK");
		System.out.println("Iniciar Sesion");
		
		System.out.print("Email: ");
		email = sc.nextLine();
		System.out.println();
		System.out.print("Clave :");
		clave=sc.nextLine();
		System.out.println();
		
		
		CRUD crud = new CRUD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark","root","jochis");
		if (crud.conectar()){
				String resultado= crud.select("select clave from Usuarios where email='"+email+"';");
		if (resultado.equalsIgnoreCase("")){
			 System.out.println("Ud. no esta registrado. Registrese");
			 System.out.println(resultado);
		} else
		System.out.println("Mostrando Menu de Productos");
			 
}	 
		 crud.cerrar();
	

			return rta;
	}
}	
	
		

