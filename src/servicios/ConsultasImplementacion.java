package servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase encargada de toda la lógica sobre las consultas
 */
public class ConsultasImplementacion implements ConsultasInterfaz {

    Scanner sc = new Scanner(System.in);

    /**
     * Método que comprueba el departamento y la fecha que introduce el usuario
     * para mostrar la consulta
     * 
     * @param especialidad
     * @return
     */
    public boolean mostrarConsulta(int especialidad) {

        System.out.println("Introduce la fecha de la cita (dd-MM-yyyy): ");
        String fecha = sc.next();

        String especialidadSeleccionada = "";
        switch (especialidad) {
            case 1:
                especialidadSeleccionada = "Psicología";
                break;
            case 2:
                especialidadSeleccionada = "Traumatología";
                break;
            case 3:
                especialidadSeleccionada = "Fisioterapia";
                break;
            default:
                System.out.println("Especialidad no válida.");
                return false;
        }

        boolean hayCitas = false;
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/citas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 5) {
                    String especialidadCita = datos[3];
                    String fechaCita = datos[4].split(" ")[0];

                    if (especialidadCita.equals(especialidadSeleccionada) && fechaCita.equals(fecha)) {
                        hayCitas = true;
                        System.out.println("DNI: " + datos[0] + ", Nombre: " + datos[1] + " " + datos[2] + ", Fecha y hora: " + datos[4] + ", Confirmada: " + (datos.length > 5 ? datos[5] : "No especificado"));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }

        if (!hayCitas) {
            System.out.println("No hay citas para la especialidad seleccionada en la fecha indicada.");
        }

        return hayCitas;
    }
    
    /**
     * Método que comprueba el departamento y la fecha que introduce el usuario
     * para imprimir en un archivo la consulta
     * 
     * @param especialidad
     * @return
     */
    public boolean imprimirConsulta(int especialidad) {
        System.out.println("Introduce la fecha de la cita (dd-MM-yyyy): ");
        String fecha = sc.next();

        String especialidadSeleccionada = "";
        switch (especialidad) {
            case 1:
                especialidadSeleccionada = "Psicología";
                break;
            case 2:
                especialidadSeleccionada = "Traumatología";
                break;
            case 3:
                especialidadSeleccionada = "Fisioterapia";
                break;
            default:
                System.out.println("Especialidad no válida.");
                return false;
        }

        boolean hayCitas = false;
        String nombreArchivo = "src/data/citasConAsistencia-" + fecha.replace("-", "") + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader("src/data/citas.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 6) {
                    String especialidadCita = datos[3];
                    String fechaCita = datos[4].split(" ")[0];
                    String asistencia = datos[5];

                    if (especialidadCita.equals(especialidadSeleccionada) && fechaCita.equals(fecha) && asistencia.equals("true")) {
                        hayCitas = true;
                        bw.write("DNI: " + datos[0] + ", Nombre: " + datos[1] + " " + datos[2] + ", Fecha y hora: " + datos[4] + ", Confirmada: " + asistencia);
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
            return false;
        }

        if (hayCitas) {
            System.out.println("Citas con asistencia guardadas en: " + nombreArchivo);
        } else {
            System.out.println("No hay citas confirmadas para la especialidad seleccionada en la fecha indicada.");
        }

        return hayCitas;
    }
}