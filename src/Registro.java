import java.util.Scanner;

public class Registro {

//realizar metodo de registro
	
	public boolean registro (){
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
		
	//	while(nombre.equalsIgnoreCase(" ")) {
			System.out.print("Nombre:");
			nombre=leerScanner.nextLine();
		//}
			
			if(nombre.equalsIgnoreCase(" ")) {
				return false;
			}
		
		while(nombre.equalsIgnoreCase(" ")) {
			System.out.println("Apellido");
			apellido=leerScanner.nextLine();
		}
		
		nuevoCliente=new Cliente(nombre, apellido, domicilio, telefono, email, dni);
		usuario=new Usuario(email, clave);
		
		Conexion db
		db.conectar;
		db.insert(nombreTabla,columnas,);
		db.insert()
		db.cerrar;
		
		return  true;
	}
	
	// generar Query String Consulta a la Base de Datos
	
	
	
} // cierre clase


