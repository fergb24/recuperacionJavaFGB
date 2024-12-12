package servicios;

import java.util.Scanner;

/**
 * Clase encargada de la navegación y la logica de los menús
 */
public class MenuImplementacion implements MenuInterfaz {
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Este método sirve para mostrar el menú de navegación
	 * @return Devuelve un número entero indicando la opción requerida
	 */
	public int mostrarMenuPrincipal() {
		
		int opcionMenuPrincipal = 5;
		
		try {
			
			System.out.println("****************************************************");
			System.out.println("*                                                  *");
			System.out.println("*     Bienvenido al programa del centro médico     *");
			System.out.println("*                                                  *");
			System.out.println("* 0. Salir del programa                            *");
			System.out.println("* 1. Registro de llegada                           *");
			System.out.println("* 2. Listado de consultas                          *");
			System.out.println("*                                                  *");
			System.out.println("****************************************************");
			System.out.println();
			System.out.print("Selecciona una opción: ");
			
			opcionMenuPrincipal = sc.nextInt();
			
		} catch (Exception e) {
			//Si ocurre un error, se mostrará un mensaje de error y el menú de nuevo
			
			System.out.println("Algo no ha salido bien, vuelve a intentarlo");
			mostrarMenuPrincipal();
			
		}
		
		return opcionMenuPrincipal;
		
	}
	
	/**
	 * Este método sirve para mostrar el menu registro de llegada
	 * @return Devuelve un número con la opción requerida
	 */
	public int mostrarRegistroLlegada() {
		
		int opcionMenuEmpleado = 5;
		
		try {
			System.out.println("****************************************************");
			System.out.println("*                                                  *");
			System.out.println("*            Menú de registro de llegada           *");
			System.out.println("*                                                  *");
			System.out.println("* 0. Volver al menú principal                      *");
			System.out.println("* 1.                *");
			System.out.println("* 2.                    *");
			System.out.println("*                                                  *");
			System.out.println("****************************************************");
			System.out.println();
			System.out.print("Selecciona una opción: ");
			
			opcionMenuEmpleado = sc.nextInt();
			
		} catch (Exception e) {
			//Si ocurre un error, se mostrará un mensaje de error y el menú de nuevo
			
			System.out.println("Algo no ha salido bien, vuelve a intentarlo");
			mostrarRegistroLlegada();
		}
		
		return opcionMenuEmpleado;
		
	}
	
	/**
	 * Este método se encarga de la lógica del menú registro de llegada
	 */
	public void navRegistroLlegada() {
		
		int opcionRegistroLlegada;
			
		opcionRegistroLlegada = mostrarRegistroLlegada();
			
		switch(opcionRegistroLlegada) {
			case 0:
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			default:
				System.out.println("No has seleccionado una opción válida");
				navRegistroLlegada();
				break;
		
		}
	}
	
	/**
	 * Este método se encarga de mostrar el menú de listado de consultas
	 * @return Devuelve un número entero con la opción requerida
	 */
	public int mostrarListadoConsulta() {
		
		int opcionMenuGerencia = 5;
		
		try {
			System.out.println("****************************************************");
			System.out.println("*                                                  *");
			System.out.println("*            Menú listado de consultas             *");
			System.out.println("*                                                  *");
			System.out.println("* 0. Volver al menú principal                      *");
			System.out.println("* 1.                           *");
			System.out.println("*                                                  *");
			System.out.println("****************************************************");
			System.out.println();
			System.out.print("Selecciona una opción: ");
			
			opcionMenuGerencia = sc.nextInt();
			
		} catch (Exception e) {
			//Si ocurre un error, se mostrará un mensaje de error y el menú de nuevo
			
			System.out.println("Algo no ha salido bien, vuelve a intentarlo");
			mostrarListadoConsulta();
		}
		
		return opcionMenuGerencia;
	}
	
	/**
	 * Este método se encarga de la lógica del menu de listado de consultas
	 */
	public void navListadoConsulta() {
		
		int opcionListadoConsulta;
		
		opcionListadoConsulta = mostrarListadoConsulta();
			
		switch(opcionListadoConsulta) {
			case 0:
				break;
			case 1:
				
				break;
			default:
				System.out.println("No has seleccionado una opción válida");
				navListadoConsulta();
				break;
		
		}
	}

}
