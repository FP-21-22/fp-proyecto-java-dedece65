package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EstudioClinicoBucles implements EstudioClinico {

	private List<PacienteEstudio> Pacientes;

	public EstudioClinicoBucles() {
	}

	public EstudioClinicoBucles(List<PacienteEstudio> pacientes) {
		this.Pacientes = pacientes;
	}

	@Override
	public Integer numeroPacientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borraEstudio() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Paciente>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}
