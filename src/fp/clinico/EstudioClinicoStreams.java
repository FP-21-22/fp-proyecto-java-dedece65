package fp.clinico;

import fp.utiles.Checkers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class EstudioClinicoStreams implements EstudioClinico {

	// ENTREGA DESDE AQUÍ

	private final List<PacienteEstudio> listaPacientes;

	public EstudioClinicoStreams(List<PacienteEstudio> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public EstudioClinicoStreams() {
		listaPacientes = new ArrayList<>();
	}

	@Override
	public Integer numeroPacientes() {
		//
		return this.listaPacientes.size();
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		//
		this.listaPacientes.add(paciente);
	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		//
		this.listaPacientes.addAll(pacientes);
	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		//
		this.listaPacientes.remove(paciente);
	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		//
		return this.listaPacientes.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		//
		this.listaPacientes.clear();
	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		//
		List<PacienteEstudio> pacientes = leeFichero(nombreFichero);
		return new EstudioClinicoStreams(pacientes);
	}

	// HASTA AQUÍ

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		//36306;Male;80;false;false;URBANA;83.84
		List<PacienteEstudio> res = new ArrayList<>();
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert aux != null;
		for(String e:aux) {
			PacienteEstudio p = parseaLinea(e);
			res.add(p);
		}
		return res;
	}

	private static PacienteEstudio parseaLinea(String cadena) {
		//[id=16770, genero=Female, edad=38.0, hipertension=false,
		// enfermedadCorazon=false, tipoResidencia=RURAL, nivelMedioGlucosa=91.23]
		Checkers.checkNoNull("Cadena vacia", cadena);
		String[] aux = cadena.split(";");
		Checkers.check("Error parametros", aux.length == 7);
		//
		String id = aux[0].trim();
		String genero = aux[1].trim();
		Double edad = Double.parseDouble(aux[2]);
		Boolean hipertension = Boolean.parseBoolean(aux[3]);
		Boolean enfermedadCorazon = Boolean.parseBoolean(aux[4]);
		TipoResidencia tipoResidencia = TipoResidencia.valueOf(aux[5]);
		Double nivelMedioGlucosa = Double.parseDouble(aux[6]);
		//
		return new PacienteEstudio(id, genero, edad, hipertension, enfermedadCorazon, tipoResidencia, nivelMedioGlucosa);
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		//
		return this.listaPacientes.stream()
				.allMatch(pacienteEstudio -> pacienteEstudio.tipoResidencia().equals(tipo));
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		//
		return this.listaPacientes.stream()
				.anyMatch(pacienteEstudio -> pacienteEstudio.tipoResidencia().equals(tipo));
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		//
		return (int)this.listaPacientes.stream()
				.filter(PacienteEstudio::factorDeRiesgo)
				.count();
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		//
		List<PacienteEstudio> pacientesRiesgo = this.listaPacientes.stream()
				.filter(PacienteEstudio::factorDeRiesgo)
				.toList();
		double edadTotal = 0;
		for (PacienteEstudio p : pacientesRiesgo) {
			edadTotal = edadTotal + p.edad();
		}
		return edadTotal / numeroPacientesFactorRiesgo();
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		//
		return this.listaPacientes.stream()
				.filter(pacienteEstudio -> pacienteEstudio.edad().equals(edad))
				.collect(Collectors.toList());
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		//
		return this.listaPacientes.stream()
				.filter(x->x.edad()>edad)
				.collect(Collectors.groupingBy(PacienteEstudio::genero));
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		//
		return this.listaPacientes.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.counting()));
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		//
		return this.listaPacientes.stream()
				.collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.averagingDouble(PacienteEstudio::edad)));
	}

}
