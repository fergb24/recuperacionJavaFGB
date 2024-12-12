package servicios;

/**
 * Clase encargada de la lógica del apartado de registro de llegadas
 */
public class LlegadaImplementacion implements LlegadaInterfaz {
	
	final char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	
	public boolean comprobarDni(String dni) {
		
		//Separamos el usuario en numeros y letra
		String numeros = dni.substring(0, 8);
        char letraUsuario = dni.charAt(8);
        
        //Se calcula la letra correspondiente
        try {
            int numeroDni = Integer.parseInt(numeros);
            char letraCalculada = letras[numeroDni % 23];

            // Comparar la letra calculada con la letra proporcionada por el usuario
            if (letraCalculada != letraUsuario) {
                return false;
            }
            
            return true;
        } catch (NumberFormatException e) {
            return false; // Si no se puede convertir a número, el DNI es inválido
        }
	}

}
