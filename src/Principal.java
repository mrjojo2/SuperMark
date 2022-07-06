
import java.util.Scanner;

public class Principal {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		menuAdminProducto();
		//ModificarProducto actualizarPro=new ModificarProducto();
		//actualizarPro.modificarForm();
		//AltaProducto alta=new AltaProducto();
		//alta.resgitrarProducto();
	}
	
	public static void menuAdminProducto() {
		Scanner entrada=new Scanner(System.in);
		int op;
		do {
			
			do {
				System.out.println("---Menu Administracion Stock---");
				System.out.println("1)- Alta Producto");
				System.out.println("2)- Modificar Producto");
				System.out.println("3)- Baja Producto");
				System.out.println("0)- Salir");
				op=entrada.nextInt();
			}while(op<0 || op>3);
			
			switch(op) {
			case 1:
				AltaProducto alta=new AltaProducto();
				if(alta.resgitrarProducto()) {
					System.out.println("Registro exitoso");
				}else {
					System.out.println("No se pudo realizar el alta");
				}
				break;
			case 2:
				ModificarProducto actualizarPro=new ModificarProducto();
				actualizarPro.modificarForm();
				break;
			case 3:
				System.out.println("Baja Producto");
				break;
			case 0:
				System.out.println("Saliendo del Formulario");
				break;
				
			}
			
		}while(op!=0);
		
		//entrada.close();
		
	}

}
