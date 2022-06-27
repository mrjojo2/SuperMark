import java.util.Scanner;

public class Registro extends Cliente  {

public Registro(String nombre, String apellido, String domicilio,
			String telefono, String email, int dni) {
		super(nombre, apellido, domicilio, telefono, email, dni);
		
		registro();
	}

//realizar metodo de registro
	
	public void registro (){
		Scanner leerScanner=new Scanner(System.in);
		String nombre=" ";
		String apellido=" ";
		String domicilio=" ";
		String email=" ";
		int dni=0;
		String telefono=" ";
		String clave="";
		
		Cliente nuevoCliente;
		Usuario usuario;
		
		System.out.println("Ingrese");
		
	    while(nombre.equalsIgnoreCase(" ")) {
			System.out.print("Nombre:");
			nombre=leerScanner.nextLine();
			System.out.println("el nombre ingresado es: " + nombre);
			}
			if(nombre.equalsIgnoreCase(" ")) {
				System.out.println("no ingreso un nombre válido");
			}
		
		while(apellido.equalsIgnoreCase(" ")) {
			System.out.println("Apellido: ");
			apellido=leerScanner.nextLine();
			System.out.println("el Apellido ingresado es: " + apellido);
		}
			if(apellido.equalsIgnoreCase(" ")) {
				System.out.println("no ingreso un Apellido válido");;
		}
		
		    while(domicilio.equalsIgnoreCase(" ")) {
				System.out.print("Domicilio: ");
				domicilio=leerScanner.nextLine();
				System.out.println("el Domicilio ingresado es: " + domicilio);
				}
				if(domicilio.equalsIgnoreCase(" ")) {
				System.out.println("no ingreso una Direccion valida");
				}
			
		while(email.equalsIgnoreCase(" ")) {
				System.out.print("eMail:");
				nombre=leerScanner.nextLine();
				System.out.println("el nombre ingresado es: " + nombre);
		}
				if(email.equalsIgnoreCase(" ")) {
					System.out.println("no ingreso un email valido");
		        }
			
		while(dni == 0) {
				System.out.print("DNI: ");
				dni=leerScanner.nextInt();
				System.out.println("el DNI ingresado es: " + dni);
				}
				if(dni == 0) {
					System.out.println("no ingreso un DNI valido");
		}
		
		while(telefono.equalsIgnoreCase(" ")) {
		        System.out.print("Telefono: ");
			    telefono=leerScanner.nextLine();
				System.out.println("el Telefono ingresado es: " + telefono);
				}
				if(telefono.equalsIgnoreCase(" ")) {
					System.out.println("no ingreso un Telefono válido");
				}
				
		while(clave.equalsIgnoreCase(" ")) {
					System.out.print("Clave: ");
					clave=leerScanner.nextLine();
					System.out.println("La Clave ingresado es: " + clave);
					}
					if(clave.equalsIgnoreCase(" ")) {
						System.out.println("no ingreso una clave valida");;
					}
			
						
		nuevoCliente=new Cliente(nombre, apellido, domicilio, telefono, email, dni);
		usuario=new Usuario(email, clave);
		
	/*	Conexion db
		db.conectar;
		db.insert(nombreTabla,columnas,);
		db.insert()
		db.cerrar;
		
		return  true;
	}
	
	// generar Query String Consulta a la Base de Datos
	*/
	
	}
} // cierre clase


