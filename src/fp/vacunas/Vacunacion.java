package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna,
		Integer astrazeneca, Integer janssen, Integer numeroPersonas) implements Comparable<Vacunacion>{
	//
	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroPersonas) {
		//Restricciones
		//---------------------
		LocalDate now = LocalDate.now();
		Checkers.check("La fecha debe ser posterior al 01/02/2021", now.isAfter(LocalDate.of(2021, 2, 1)));
		//---------------------
		Vacunacion res = new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
		return res;
	}
	
	// Metodo parse
	public static Vacunacion parse(String cadena) {
		//
		Checkers.checkNoNull("Linea vacia", cadena);
		String[] vacuna = cadena.split(";");
		Checkers.check("Error parametros", vacuna.length == 7);
		String fechaVacuna= vacuna[0].strip();
		String comunidad = vacuna[1];
		Integer pfizer = Integer.parseInt(vacuna[2]);
		Integer moderna = Integer.parseInt(vacuna[3]);
		Integer astrazeneca = Integer.parseInt(vacuna[4]);
		Integer janssen = Integer.parseInt(vacuna[5]);
		Integer numeroPersonas = Integer.parseInt(vacuna[6]);
		LocalDate fecha = LocalDate.parse(fechaVacuna, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return Vacunacion.of(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
	}
		
	//Metodos derivados
	public Integer numeroTotal() {
		//
		Integer res = this.pfizer() + this.moderna() + this.astrazeneca() + this.janssen();
		return res;
	}
	
	// Criterio de igualdad - (equals & hashCode)
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacunacion other = (Vacunacion) obj;
		return Objects.equals(astrazeneca, other.astrazeneca) && Objects.equals(comunidad, other.comunidad)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(janssen, other.janssen)
				&& Objects.equals(moderna, other.moderna) && Objects.equals(numeroPersonas, other.numeroPersonas)
				&& Objects.equals(pfizer, other.pfizer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(astrazeneca, comunidad, fecha, janssen, moderna, numeroPersonas, pfizer);
	}
	
	// Representacion como cadena
	
	@Override
	public String toString() {
		return "Vacunacion [fecha=" + fecha + ", comunidad=" + comunidad + ", pfizer=" + pfizer + ", moderna=" + moderna
				+ ", astrazeneca=" + astrazeneca + ", janssen=" + janssen + ", numeroPersonas=" + numeroPersonas + "]";
	}
	
	// Orden natural
	
	public int compareTo(Vacunacion v) {
		int res = this.comunidad().compareTo(v.comunidad());
		if (res == 0) {
			res = this.fecha().compareTo(v.fecha());
		}
		return res;
	}
	
	// Metodo main
	
	public static void main(String[] args) {
		Vacunacion v1 = Vacunacion.parse("06/05/2023;Cadiz;1;1;1;1;4");
		System.out.println(v1);
	}
	
}
