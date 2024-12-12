package servicios;

import java.util.Scanner;

/**
 * Clase encargada de la navegación y la logica de los menús
 */
public class MenuImplementacion implements MenuInterfaz {
	
	Scanner sc = new Scanner(System.in);
	LlegadaImplementacion li = new LlegadaImplementacion();
	
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
				System.out.println("Todo correcto!");
				
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
