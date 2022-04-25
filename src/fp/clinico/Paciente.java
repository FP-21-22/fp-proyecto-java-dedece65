package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import fp.utiles.Checkers;

public record Paciente(Persona persona, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
	//
	public static Paciente of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
		//RESTRICCIONES
		//--------------------
		LocalDateTime now = LocalDateTime.now();
		Checkers.check("La fecha y hora de ingreso debe ser anterior a la de hoy", !fechaHoraIngreso.isAfter(now));
		//--------------------
		Persona persona = Persona.of(nombre, apellidos, dni, fechaNacimiento);
		return new Paciente(persona, codigoIngreso, fechaHoraIngreso);
	}
	public static Paciente of(Persona persona, String codigoIngreso, LocalDateTime fechaHoraIngreso) {
		//RESTRICCIONES
		//--------------------
		LocalDateTime now = LocalDateTime.now();
		Checkers.check("La fecha y hora de ingreso debe ser anterior a la de hoy", !fechaHoraIngreso.isAfter(now));
		//--------------------
		return new Paciente(persona, codigoIngreso, fechaHoraIngreso);
	}
	
	// Metodos derivados
	
	public LocalDate fechaIngreso() {
		return LocalDate.of(fechaHoraIngreso.getYear(), fechaHoraIngreso.getMonth(), fechaHoraIngreso.getDayOfMonth());
	}
	public String horaIngreso() {
		return fechaHoraIngreso.getHour() + ":" + fechaHoraIngreso.getMinute();
	}
	
	//	Criterio de igualdad - (equals & hashCode)
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(codigoIngreso, other.codigoIngreso)
				&& Objects.equals(fechaHoraIngreso, other.fechaHoraIngreso) && Objects.equals(persona, other.persona);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoIngreso, fechaHoraIngreso, persona);
	}
	
	// Representacion como cadena
	
	@Override
	public String toString() {
		return "Paciente [persona=" + persona + ", codigoIngreso=" + codigoIngreso + ", fechaHoraIngreso="
				+ fechaHoraIngreso + "]";
	}

}
