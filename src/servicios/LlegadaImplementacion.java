package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de la lógica del apartado de registro de llegadas
 */
public class LlegadaImplementacion implements LlegadaInterfaz {
	
	final char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	
	public boolean comprobarDni(String dni, String archivo) {
		
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
            
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;

                while ((linea = br.readLine()) != null) {
                    // Divide la línea en partes usando el punto y coma como separador
                    String[] partes = linea.split(";");

                    // Comprueba si el DNI coincide
                    if (partes[0].equals(dni)) {
                        // Devuelve el cuarto dato (índice 3, ya que los índices empiezan en 0)
                        System.out.println(partes[3]);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
            
            return true;
        } catch (NumberFormatException e) {
            return false; // Si no se puede convertir a número, el DNI es inválido
        }
	}

}
