package dtos;

import java.time.LocalDateTime;

/**
 * Clase encargada de recoger la información de los pacientes
 */
public class PacienteDto {
	
	int idPaciente;
	String dniPaciente, nombrePaciente, apellidosPaciente, especialidadPaciente;
	LocalDateTime fechaCitaPaciente;
	boolean asistenciaPaciente;
	
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getDniPaciente() {
		return dniPaciente;
	}
	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getApellidosPaciente() {
		return apellidosPaciente;
	}
	public void setApellidosPaciente(String apellidosPaciente) {
		this.apellidosPaciente = apellidosPaciente;
	}
	public String getEspecialidadPaciente() {
		return especialidadPaciente;
	}
	public void setEspecialidadPaciente(String especialidadPaciente) {
		this.especialidadPaciente = especialidadPaciente;
	}
	public LocalDateTime getFechaCitaPaciente() {
		return fechaCitaPaciente;
	}
	public void setFechaCitaPaciente(LocalDateTime fechaCitaPaciente) {
		this.fechaCitaPaciente = fechaCitaPaciente;
	}
	public boolean isAsistenciaPaciente() {
		return asistenciaPaciente;
	}
	public void setAsistenciaPaciente(boolean asistenciaPaciente) {
		this.asistenciaPaciente = asistenciaPaciente;
	}

}
