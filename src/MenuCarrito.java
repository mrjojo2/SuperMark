import java.util.Scanner;

public class MenuCarrito {
	private Carrito miCarrito;
	
	
	public int opcion() {
		Scanner entrada=new Scanner(System.in);
		boolean ban=true;
		int op=0;
		do {
			System.out.println("Elija una tarea a realizar");
			System.out.println("1) LLenar carrito.");
			System.out.println("2) Ver carrito.");
			System.out.println("3) Modificar carrito.");
			System.out.println("4) Confirmar compra.");
			System.out.println("0) Cancelar operacion");
			op=entrada.nextInt();
			entrada.nextLine();
			if(op>=0 && op<=4) {
				ban=false;
			}
		}while(ban==true);
		entrada.close();
		return op;
	}
	
	public void menu() {
		Scanner entrada=new Scanner(System.in);
		switch(opcion()) {
		case 1:
			System.out.println("Selecciones los productos que desea");
			miCarrito=new Carrito();
			boolean bandera=true;
			do {
				System.out.println("Ingrese el codigo del producto");
			}while(bandera==true);
			
		}
	}
	
	
}
