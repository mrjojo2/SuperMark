package SupermarK;


import java.util.Scanner; 

import Conexion_BD.Conexion;



public class Registro {
	static Scanner leerSc = new Scanner (System.in);
	
	public boolean Registrarme(){
	boolean rta=true;
			
	 String nombre;
	 String apellido;
	 String dni;
	 String telefono;
	 String domicilio;
	 String email;
	 String clave;
	
 
	 
 System.out.println("--Formulario de Registro--");
 System.out.println(" * Campos Obligatorios");
 System.out.println("-------------------------");
			 
 System.out.print("Nombre *:");
 nombre= leerSc.nextLine();
 String nom = validarNombre(nombre);
 nombre = nom;
 System.out.println("El nombre ingresado es: " + nombre);
 System.out.println();
 
 System.out.print("Apellido *:");
 apellido= leerSc.nextLine();
 String ape = validarApellido(apellido);
 apellido = ape;
 System.out.println("El apellido ingresado es: " + apellido);
 System.out.println();
 
 System.out.print("DNI *:");
 dni= leerSc.nextLine();
 String doc = validardni(dni);
 dni = doc;
 System.out.println("El DNI ingresado es: " + dni);
 System.out.println(); 
			
 System.out.print("Telefono *:");
 telefono = leerSc.nextLine();
 String phone = validarTel(telefono);
 telefono = phone;
 System.out.println("El telefono ingresado es: " + telefono);
 System.out.println(); 

 System.out.print("Domicilio *:");
 domicilio = leerSc.nextLine();
 String domic = validarDom(domicilio);
 domicilio = domic;
 System.out.println("El Domicilio ingresado es: " + domicilio);
 System.out.println(); 

 
 System.out.print("E-Mail *:");
 email= leerSc.nextLine();
 String mail = validarMail(email);
 email = mail;
 System.out.println("El email ingresado es: " + email);
 System.out.println();
 
 System.out.print("Clave *:");
 clave = leerSc.nextLine();
 String pass = validarClave(clave);
 clave = pass;
 System.out.println("La Calve ingresada es: " + clave);
 System.out.println();
 
 					 			 
			Conexion conn = new Conexion("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermark","root","jochis"); 

							
				 if (conn.conectar()){
					 String resultado= conn.select("select email from Clientes where email='"+email+"';");
					 if (resultado.equalsIgnoreCase("")){
					 Cliente nuevoCliente = new Cliente (nombre, apellido, dni, telefono, domicilio, email);
					 Usuario nuevoUsuario = new Usuario(email, clave, null); //ojo null al tipo ver..
					 if (conn.insert(nuevoCliente.creaQueryInsert())){
						 conn.insert(nuevoUsuario.creaQueryInsert());
						 System.out.println("Felicidades usted ya es un nuevo cliente de Supermark...");
						 System.out.println("Vuelva a ingresar con su e-mail");
						 conn.cerrar();
					 }
					 else System.out.println("Error al intentar registrarse. Intente mas tarde...");	 
				 }
					 else System.out.println("El email ingresado ya se encuentra registrado");
				 
		 }
				 else System.out.println("ERROR EN LA CONEXION.. INTENTE MAS TARDE");
			 
			 
			return rta;
				
		}

		
	
	private String validarNombre(String nombre){	// metodo para validar el nombre
		String nom = nombre;
	while((nom.equalsIgnoreCase("")) || (nom.matches("^[A-Za-z ]*$")==false)) {
		System.out.println("Ingrese un nombre valido");
		System.out.print("Nombre*: ");
		nom=leerSc.nextLine();
		
    }return nombre = nom;
  }

    private String validarApellido(String apellido){	// metodo para validar el apellido
    	String ape = apellido;
    	while((ape.equalsIgnoreCase("")) || (ape.matches("^[A-Za-z ]*$")==false)) {
    		System.out.println("Ingrese un apellido valido");
    		System.out.print("Apellido*: ");
    		ape=leerSc.nextLine();
          		
        }return apellido = ape;
	}   		

    private String validardni(String dni){  //metodo para validar DNI
    	String doc = dni;
    	while((doc.equalsIgnoreCase("")) || (doc.matches("[0-9]{8}")==false)) {
    		System.out.println("Ingrese un DNI de 8 digitos");
    		System.out.print("DNI*: ");
    		doc =leerSc.nextLine();
    		    		
        }return dni = doc;
	}   		
  
    public String validarTel(String telefono){  //metodo para validar DNI
    	String telef = telefono;
    	while((telef.equalsIgnoreCase("")) || (telef.matches("[0-9]{6,10}")==false)) {
    		System.out.println("Ingrese un Telefono - solo numero-");
    		System.out.print("Telefono*: ");
    		telef =leerSc.nextLine();
    		    		
        }return telefono = telef;
	}   		
  
    private String validarDom(String domicilio) {	// metodo para validar el nombre
		String domic = domicilio;
	while(domic.equalsIgnoreCase("")) {
		System.out.println("Ingrese un domicilio");
		System.out.print("Domicilio*: ");
		domic=leerSc.nextLine();
		
    }return domicilio = domic;
  }
    
    public String validarMail(String email){	// metodo para validar e-mail
		String mail = email;
	while((mail.equalsIgnoreCase("")) || (mail.matches("^[\\w]+(\\.[\\w]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})*$")==false)) {
		System.out.println("Ingrese un mail valido");
		System.out.print("Email*: ");
		mail=leerSc.nextLine();
		
    }return email = mail;
  }
    	 
    public String validarClave (String clave){ // metodo para validar la clave
	  	String pass = clave;
		while(pass.equalsIgnoreCase("")) {
			System.out.println("Ingrese una Clave");
			System.out.print("Clave*: ");
			pass=leerSc.nextLine();
			
	    }return clave = pass;
  }

} // cierra 



