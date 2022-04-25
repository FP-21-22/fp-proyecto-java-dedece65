package fp.clinico;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EstudioClinico {
	// Propiedades de lista
	Integer numeroPacientes();

	void incluyePaciente(PacienteEstudio paciente);

	void incluyePacientes(Collection<PacienteEstudio> pacientes);

	void eliminaPaciente(PacienteEstudio paciente);

	Boolean estaPaciente(PacienteEstudio paciente);

	void borraEstudio();

	//
	// Método de factoria
	EstudioClinico of(String nombreFichero);

	List<PacienteEstudio> leeFichero(String nombreFichero);

	// Tratamientos secuenciales: implementacion funcional vs. imperativa
	// existe, paraTodo
	Boolean todosPacienteSonDelTipo(TipoResidencia tipo);

	Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo);

	// contador, suma, media
	Integer numeroPacientesFactorRiesgo();

	Double edadMediaPacientesConFactorRiesgo();

	// filtrado
	List<PacienteEstudio> filtraPacientesPorEdad(Double edad);

	// devuelve Map que agrupa
	Map<String, List<Paciente>> agruparPacientesEdadMayorQuePorGenero(Double edad);

	// devuelve Map que realiza un calculo
	Map<String, Long> numeroPacientesPorGenero();

	Map<String, Double> edadMediaPacientesPorPorGenero();
}
