package fp.clinico.Tests;

import fp.clinico.EstudioClinicoStreams;
import fp.clinico.PacienteEstudio;

import java.util.List;

public class TestEstudioClinicoStreams {
    public static void main(String[] args) {
        EstudioClinicoStreams estudio = new EstudioClinicoStreams();
        String ruta = "data/estudio_clinico.csv";
        List<PacienteEstudio> lista = estudio.leeFichero(ruta);
        estudio.incluyePacientes(lista);
        System.out.println(estudio.edadMediaPacientesPorPorGenero());
    }
}
