package servicios;

public class LlegadaImplementacion implements LlegadaInterfaz {
	
	final char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	
	public boolean comprobarDni(String dni) {
		//Separamos el usuario en numeros y letra
		String numeros = dni.substring(0, 8);
        char letraUsuario = dni.charAt(8);
		
		
		return false;
	}

}
