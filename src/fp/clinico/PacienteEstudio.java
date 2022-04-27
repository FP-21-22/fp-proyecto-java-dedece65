package fp.clinico;

import java.util.Objects;

import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension,
		Boolean enfermedadCorazon, TipoResidencia tipoResidencia, Double nivelMedioGlucosa) implements Comparable<PacienteEstudio> {
	//
	public static PacienteEstudio of(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadCorazon, TipoResidencia tipoResidencia, Double nivelMedioGlucosa) {
		// Restricciones
		// ----------------------------------
		Checkers.check("La edad debe estar entre 0 y 130", edad >= 0 && edad <= 130);
		Checkers.check("El nivel medio de glucosa debe ser mayor o igual que 0", nivelMedioGlucosa >= 0);
		// ----------------------------------
		return new PacienteEstudio(id, genero, edad, hipertension, enfermedadCorazon, tipoResidencia, nivelMedioGlucosa);
	}
	public static PacienteEstudio parse(String cadena) {
		// Ejemplo Cadena - �6306;Male;80;false;false;URBANA;83.84�
		//
		Checkers.checkNoNull("Linea vacia", cadena);
		String[] pacienteEstudio = cadena.split(";");
		Checkers.check("Error parametros", pacienteEstudio.length == 7);
		String id= pacienteEstudio[0];
		String genero = pacienteEstudio[1];
		Double edad = Double.parseDouble(pacienteEstudio[2]);
		Boolean hipertension = Boolean.parseBoolean(pacienteEstudio[3]);
		Boolean enfermedadCorazon = Boolean.parseBoolean(pacienteEstudio[4]);
		TipoResidencia tipoResidencia = TipoResidencia.valueOf(pacienteEstudio[5]);
		Double nivelMedioGlucosa = Double.parseDouble(pacienteEstudio[6]);
		return PacienteEstudio.of(id, genero, edad, hipertension, enfermedadCorazon, tipoResidencia, nivelMedioGlucosa);
	}

	// Metodo derivado - (factorDeRiesgo --> true si tiene hipertensi�n y mas de 40 a�os)
	public Boolean factorDeRiesgo() {
		//
		boolean riesgo;
		riesgo = hipertension && edad > 40;
		return riesgo;
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
		PacienteEstudio other = (PacienteEstudio) obj;
		return Objects.equals(edad, other.edad) && Objects.equals(enfermedadCorazon, other.enfermedadCorazon)
				&& Objects.equals(genero, other.genero) && Objects.equals(hipertension, other.hipertension)
				&& Objects.equals(id, other.id) && Objects.equals(nivelMedioGlucosa, other.nivelMedioGlucosa)
				&& tipoResidencia == other.tipoResidencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, enfermedadCorazon, genero, hipertension, id, nivelMedioGlucosa, tipoResidencia);
	}

	// Representacion como cadena
	public String representacionCadena() {
		return this.id()+","+this.edad();
	}
	
	@Override
	public String toString() {
		return "PacienteEstudio [id=" + id + ", genero=" + genero + ", edad=" + edad + ", hipertension=" + hipertension
				+ ", enfermedadCorazon=" + enfermedadCorazon + ", tipoResidencia=" + tipoResidencia
				+ ", nivelMedioGlucosa=" + nivelMedioGlucosa + "]";
	}

	// Criterio de orden - (Segun la edad y el id)

	public int compareTo(PacienteEstudio p) {
		//
		return this.edad().compareTo(p.edad());
	}
	public int compareTo1(PacienteEstudio p) {
		return this.id().compareTo(p.id());
	}

	// Metodo main

	public static void main(String[] args) {
		//
		PacienteEstudio p1 = PacienteEstudio.parse("6306;Male;80;false;false;URBANA;83.84");
		System.out.println(p1);
	}
}
