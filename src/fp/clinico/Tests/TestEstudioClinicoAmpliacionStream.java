package fp.clinico.Tests;

import fp.clinico.EstudioClinicoAmpliacionStream;
import fp.clinico.PacienteEstudio;

import java.util.List;

public class TestEstudioClinicoAmpliacionStream {
    public static void main(String[] args) {
        EstudioClinicoAmpliacionStream estudio = new EstudioClinicoAmpliacionStream();
        List<PacienteEstudio> lista = estudio.leeFichero("data/estudio_clinico.csv");
        estudio.incluyePacientes(lista);
        System.out.println(estudio.edadMaximaPacientesPorGenero());
    }
}
