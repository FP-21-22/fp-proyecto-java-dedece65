package fp.clinico;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class EstudioClinicoBucles implements EstudioClinico {

	private List<PacienteEstudio> listaPacientes;

	public EstudioClinicoBucles() {
	}

	public EstudioClinicoBucles(List<PacienteEstudio> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	@Override
	public Integer numeroPacientes() {
		//
		return listaPacientes.size();
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		//
		listaPacientes.add(paciente);
	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		//
		listaPacientes.addAll(pacientes);
	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		//
		listaPacientes.remove(paciente);
	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		//
		return listaPacientes.contains(paciente);
	}

	@Override
	public void borraEstudio() {
		//
		listaPacientes.clear();
	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		//
		List<PacienteEstudio> res = leeFichero(nombreFichero);
		return new EstudioClinicoBucles(res);
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
		// Hay que saltarse la primera línea
		int cont = 0;
		assert aux != null;
		for(String e:aux) {
			if(cont>0) {
				PacienteEstudio p = parseaLinea(e);
				res.add(p);
			}
			cont++;
		}		
		return res;
	}

	// Método auxiliar

	private static PacienteEstudio parseaLinea(String cadena) {
		//[id=16770, genero=Female, edad=38.0, hipertension=false,
		// enfermedadCorazon=false, tipoResidencia=RURAL, nivelMedioGlucosa=91.23]
		String[] aux = cadena.split(";");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
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
		List<Double> edades = new ArrayList<>();
		double media = 0;
		for (PacienteEstudio p : this.listaPacientes) {
			if(p.factorDeRiesgo()){
				edades.add(p.edad());
			}
		}
		for (Double num : edades) {
			media = media + num;
		}
		media = media / edades.size();
		return media;
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
	public Map<String, List<Paciente>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
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
		//
		Map<String, Double> res = new HashMap<>();
		List<Double> edadesMale = new ArrayList<>();
		List<Double> edadesFemale = new ArrayList<>();
		for (PacienteEstudio p : this.listaPacientes) {
			if (p.genero().equals("Male")) {
				edadesMale.add(p.edad());
			} else {
				edadesFemale.add(p.edad());
			}
		}
		double mediaMale = 0;
		double mediaFemale = 0;
		for(Double edad : edadesMale){
			mediaMale = mediaMale + edad;
		}
		for (Double edad : edadesFemale) {
			mediaFemale = mediaFemale + edad;
		}
		res.put("Male", mediaMale / edadesMale.size());
		res.put("Female", mediaFemale / edadesFemale.size());
		return res;
	}

}
