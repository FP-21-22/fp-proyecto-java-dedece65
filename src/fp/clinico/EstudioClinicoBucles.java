package fp.clinico;


import fp.utiles.Checkers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class EstudioClinicoBucles implements EstudioClinico {

	protected final List<PacienteEstudio> listaPacientes;

	public EstudioClinicoBucles() {
		listaPacientes = new ArrayList<>();
	}

	public EstudioClinicoBucles(List<PacienteEstudio> pacientes) { this.listaPacientes = pacientes;
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
		return new EstudioClinicoBucles(pacientes);
	}

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

	// Método auxiliar

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
		boolean res = true;
		for(PacienteEstudio p : this.listaPacientes){
			if (!p.tipoResidencia().equals(tipo)) {
				res = false;
				break;
			}
		}
		return res;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		//
		boolean res = false;
		for (PacienteEstudio p : this.listaPacientes) {
			if (p.tipoResidencia().equals(tipo)) {
				res = true;
				break;
			}
		}
		return res;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		//
		int res = 0;
		for (PacienteEstudio p : this.listaPacientes) {
			if (p.factorDeRiesgo()) {
				res++;
			}
		}
		return res;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		//
		double sumEdad = 0;
		int numEdades = 0;
		for (PacienteEstudio p : this.listaPacientes) {
			if (p.factorDeRiesgo()) {
				sumEdad = sumEdad + p.edad();
				numEdades++;
			}
		}
		return sumEdad / numEdades;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		//
		List<PacienteEstudio> res = new ArrayList<>();
		for (PacienteEstudio p : this.listaPacientes) {
			if(p.edad().equals(edad)){
				res.add(p);
			}
		}
		return res;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		//
		Map<String, List<PacienteEstudio>> res = new HashMap<>();
		for (PacienteEstudio p : this.listaPacientes) {
			if (p.edad() > edad) {
				if (!res.containsKey(p.genero())) {
					List<PacienteEstudio> l = new ArrayList<>();
					l.add(p);
					res.put(p.genero(), l);
				}else{
					res.get(p.genero()).add(p);
				}
			}
		}
		return res;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		//
		Map<String, Long> res = new HashMap<>();
		for(PacienteEstudio p : this.listaPacientes){
			String clave = p.genero();
			if (!res.containsKey(clave)) {
				//Primera vez
				res.put(clave, 1L);
			}else{
				res.put(clave, res.get(clave) + 1);
			}
		}
		return res;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		//{Male=41.45878042397276, Female=42.47969699735326, Other=7.5}
		Map<String, Double> res = new HashMap<>();
		for(PacienteEstudio p : this.listaPacientes){
			res.put(p.genero(), mediaEdadSegunGenero(p.genero()));
		}
		return res;
	}

	private double mediaEdadSegunGenero(String genero) {
		double sumEdad = 0.;
		int cont = 0;
		for (PacienteEstudio p : this.listaPacientes) {
			if (p.genero().equals(genero)) {
				sumEdad = sumEdad + p.edad();
				cont++;
			}
		}
		return sumEdad / cont;
	}

}
