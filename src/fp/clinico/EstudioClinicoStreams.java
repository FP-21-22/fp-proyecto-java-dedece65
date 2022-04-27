package fp.clinico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
		// TODO Auto-generated method stub
		return null;
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
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
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
