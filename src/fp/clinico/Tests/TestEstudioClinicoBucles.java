package fp.clinico.Tests;

import fp.clinico.EstudioClinico;
import fp.clinico.EstudioClinicoBucles;
import fp.clinico.PacienteEstudio;

import java.util.List;

import static fp.clinico.TipoResidencia.URBANA;

public class TestEstudioClinicoBucles {
    public static void main(String[] args) {
        EstudioClinico estudio = new EstudioClinicoBucles();
        String ruta = "data/estudio_clinico.csv";
        List<PacienteEstudio> lista = estudio.leeFichero(ruta);
        estudio.incluyePacientes(lista);
//        for(PacienteEstudio p : lista){
//            System.out.println(p);
//        }
        System.out.println(estudio.estaPaciente(new PacienteEstudio("36306", "Male", Double.parseDouble("80"), false,
                false, URBANA, 83.84)));
    }
}
