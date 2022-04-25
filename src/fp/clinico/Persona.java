package fp.clinico;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Persona(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) implements Comparable<Persona>{
	//
    // Metodos auxiliares - (comprobacion si una cadena son digitos)
	public static Boolean sonDigitos(String cadena) {
		Boolean res = true;
		for(int i=0; i<cadena.length();i++) {
			res = Character.isDigit(cadena.charAt(i));
			if(!res) {
				break;
			}
		}
		return res;
	}
	
	// Factoria
	
	public static Persona of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
		//Restricciones
		//----------------------
		Character ultimoNumero = dni.charAt(dni.length()-1);
		Boolean esLetra = Character.isLetter(ultimoNumero);
		LocalDate now = LocalDate.now();
		Checkers.check("La fecha de nacimiento no puede ser en el futuro", !fechaNacimiento.isAfter(now));
		Checkers.check("El dni debe ser una cadena de 8 digitos seguidos de una letra", dni.length()==9 && esLetra && sonDigitos(dni.substring(0, dni.length()-1)));
		//----------------------
		Persona res = new Persona(nombre, apellidos, dni, fechaNacimiento);
		return res;
	}
	public static Persona parse(String cadena) {
		//Ejemplo de cadena: “Juan, García Rodríguez, 12755078Z, 20/03/1965”
		//
		Checkers.checkNoNull("Linea vacia", cadena);
		String[] persona = cadena.split(",");
		Checkers.check("Error parametros", persona.length == 4);
		String nombre= persona[0];
		String apellidos = persona[1];
		String dni = persona[2];
		String fecha = persona[3].strip();
		LocalDate fechaNacimiento = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return Persona.of(nombre, apellidos, dni, fechaNacimiento);
	}
	
	//Orden natural - (por dni)
	
	public int compareTo(Persona p) {
		//
		int res = this.dni().compareTo(p.dni());
		return res;
	}
	
	//Metodos derivados
	public Integer edad() {
		//
		LocalDate hoy = LocalDate.now();
		Integer res = Period.between(this.fechaNacimiento, hoy).getYears();
		return res;
	}
	
	// Metodo main
	
	public static void main(String[] args) {
		//
		Persona p1 = Persona.parse("Daniel,del Castillo,11111111Z,06/05/2003");
		System.out.println(p1);
	}

}
