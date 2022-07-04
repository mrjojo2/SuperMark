package SupermarK;


import java.util.Scanner;


public class Registro {

	public boolean Registrarme(){
	boolean rta=true;
			
	 String nombre;
	 String apellido;
	 String dni;
	 String telefono;
	 String domicilio;
	 String email;
	 String clave;
	
 Scanner leerSc = new Scanner (System.in);
	 
 System.out.println("--Formulario de Registro--");
 System.out.println(" * Campos Obligatorios");
 System.out.println("-------------------------");
			 
 System.out.print("Nombre *:");
 nombre= leerSc.nextLine();
 System.out.println();
			 
 System.out.print("Apellido *:");
 apellido=leerSc.nextLine();
 System.out.println();		 
			
 System.out.print("DNI *:");
 dni=leerSc.nextLine();
 System.out.println();
			 
System.out.print("Telefono *:");
telefono=leerSc.nextLine();
System.out.println();
			 
 System.out.print("Domicilio *:");
 domicilio=leerSc.nextLine();
 System.out.println();
			 
 System.out.print("E-Mail *:");
 email=leerSc.nextLine();
 System.out.println();
			 
 System.out.print("Clave *:");
 clave=leerSc.nextLine();
 System.out.println();
			 
		//	 if (validarCampos(nombre, apellido, dni, telefono, domicilio, email, clave))  // = true (exprecion regular)
				 			 
				CRUD crud = new CRUD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark","root","jochis"); 

				 if (crud.conectar()){
					 String resultado= crud.select("select email from Clientes where email="+email);
					 if (resultado.equalsIgnoreCase("")){
					 Cliente nuevoCliente = new Cliente (nombre, apellido, dni, telefono, domicilio, email);
					 Usuario nuevoUsuario = new Usuario(email, clave);
					 if (crud.insert(nuevoCliente.creaQueryInsert())){
						 crud.insert(nuevoUsuario.creaQueryInsert());
						 System.out.println("Felicidades usted ya es un nuevo cliente de Supermark...");
						 System.out.println("Vuelva a ingresar con su e-mail");
						 crud.cerrar();
					 }
					 else System.out.println("Error al intentar registrarse. Intente mas tarde...");	 
				 }
					 else System.out.println("El email ingresado ya se encuentra registrado");
				 
		 }
				 else System.out.println("ERROR EN LA CONEXION.. INTENTE MAS TARDE");
			 
			 
			return rta;
				
		}
		
	/*	private boolean validarCampos (String nombre, String apellido, String dni, String telefono, String domicilio, String email, String clave){
		     boolean rta=true;
			 // falta completar este metodo con expreciones regulares
		     if(nombre.equalsIgnoreCase("")){
		     rta=false;
		     return rta;
			 }
		     return true;*/
	}   		




