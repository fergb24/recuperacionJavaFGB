package servicios;

import java.util.Scanner;

/**
 * Clase encargada de la navegación y la logica de los menús
 */
public class MenuImplementacion implements MenuInterfaz {
	
	Scanner sc = new Scanner(System.in);
	LlegadaImplementacion li = new LlegadaImplementacion();
	ConsultasImplementacion ci = new ConsultasImplementacion();
	
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
	 * Este método sirve para comprobar si el DNI que introduce el usuario es correcto y si coincide con 
	 * algun DNI que haya en el archivo citas.txt
	 * 
	 * @return Devuelve un número con la opción requerida
	 */
	public void registroLlegada() {
		
		System.out.println("Introduzca su DNI: ");
		String dniPaciente = sc.next();
		
		//Comprobamos que el DNI tenga 9 digitos
		if (dniPaciente.length() != 9) {
			System.out.println("El DNI que has introducido es erroneo, vuelve a introducirlo");
			registroLlegada();
		} else {
			
			if(li.comprobarDni(dniPaciente, "src/data/citas.txt")) {
				
			} else {
				System.out.println("El DNI que has introducido es inválido. Por favor, introduce uno que sea correcto");
				//Reseteamos el buffer del scanner
				sc.nextLine();
				registroLlegada();
			}
		}
		
	}
	
	/**
	 * Este método se encarga de mostrar el menú de listado de consultas
	 * @return Devuelve un número entero con la opción requerida
	 */
	public int mostrarListadoConsulta() {
		
		int opcionListadoConsulta = 5;
		
		try {
			System.out.println("****************************************************");
			System.out.println("*                                                  *");
			System.out.println("*            Menú listado de consultas             *");
			System.out.println("*                                                  *");
			System.out.println("* 0. Volver al menú principal                      *");
			System.out.println("* 1. Mostrar consultas                             *");
			System.out.println("* 2. Imprimir consultas                            *");
			System.out.println("*                                                  *");
			System.out.println("****************************************************");
			System.out.println();
			System.out.print("Selecciona una opción: ");
			
			opcionListadoConsulta = sc.nextInt();
			
		} catch (Exception e) {
			//Si ocurre un error, se mostrará un mensaje de error y el menú de nuevo
			System.out.println("Algo no ha salido bien, vuelve a intentarlo");
			mostrarListadoConsulta();
		}
		
		return opcionListadoConsulta;
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
				navSubMenu(1);
				break;
			case 2:
				navSubMenu(2);
				break;
			default:
				System.out.println("No has seleccionado una opción válida");
				navListadoConsulta();
				break;
		
		}
		
	}
	
	/**
	 * Este método se encarga de mostrar el menú de listado de tipos de consultas
	 * @return Devuelve un número entero con la opción requerida
	 */
	public int mostrarSubMenuConsultas() {
		
		int opcionSubMenu = 5;
		
		try {
			System.out.println("****************************************************");
			System.out.println("*                                                  *");
			System.out.println("* 0. Volver al menú principal                      *");
			System.out.println("* 1. Psicología                                    *");
			System.out.println("* 2. Traumatología                                 *");
			System.out.println("* 3. Fisioterapia                                  *");
			System.out.println("*                                                  *");
			System.out.println("****************************************************");
			System.out.println();
			System.out.print("Selecciona una opción: ");
			
			opcionSubMenu = sc.nextInt();
			
		} catch (Exception e) {
			//Si ocurre un error, se mostrará un mensaje de error y el menú de nuevo
			System.out.println("Algo no ha salido bien, vuelve a intentarlo");
			mostrarSubMenuConsultas();
		}
		
		return opcionSubMenu;
	}
	
	/**
	 * Este método se encarga de la lógica del submenu de tipos de consultas
	 */
	public void navSubMenu(int opcion) {
		
		int opcionSubMenu;
		
		opcionSubMenu = mostrarSubMenuConsultas();
			
		switch(opcionSubMenu) {
			case 0:
				break;
			case 1:
				if (opcion == 1) {
					ci.mostrarConsulta(1);
					
				} else {
					ci.imprimirConsulta(1);
				}
				break;
			case 2:
				if (opcion == 1) {
					ci.mostrarConsulta(2);
					
				} else {
					ci.imprimirConsulta(2);
				}
				break;
			case 3:
				if (opcion == 1) {
					ci.mostrarConsulta(3);
				} else {
					ci.imprimirConsulta(3);
				}
				break;
			default:
				System.out.println("No has seleccionado una opción válida");
				navSubMenu(opcion);
				break;
		
		}
		
	}

}
