
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Usuario us1 = new Usuario("mjojo2", "password");
		   
		   System.out.println(us1);
		   
			System.out.println("*********************");	   
			
			us1.mostrar();
			
	}
	
	public void menu() {
		
		System.out.println("1. Loguearse");
		System.out.println("2. Registrarse");
		System.out.println("0. Salir");
		System.out.println("Ingrese opcion:");
		//leen respuesta
		
		switch (op) {
		case 1: 
			Login login=new Login();
			
			if(login.loguearme()==0) {
				System.out.println("Error al loguearse intente mas tarde...");
			}
			
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}

}
