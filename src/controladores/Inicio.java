package controladores;

import servicios.MenuImplementacion;

public class Inicio {
	
	/**
	 * Clase encargada de mostrar el menu
	 * @param args
	 */
	public static void main(String[] args) {
		
		MenuImplementacion mi = new MenuImplementacion();
		
		int opcionMenuPrincipal;
		boolean salir = false;
		
		do {
			
			opcionMenuPrincipal = mi.mostrarMenuPrincipal();
			
			switch (opcionMenuPrincipal) {
			
				case 0:
					salir = true;
					break;
				case 1:
					mi.registroLlegada();
					break;
				case 2:
					mi.navListadoConsulta();
					break;
				default:
					System.out.println("No has seleccionado una opción válida");
					break;
			}
			
		} while (!salir);

	}

}
