package fp.clinico.Tests;

import fp.clinico.EstudioClinico;
import fp.clinico.EstudioClinicoBucles;
import fp.clinico.PacienteEstudio;

import java.util.List;

public class TestEstudioClinicoBucles {
    public static void main(String[] args) {
        EstudioClinico estudio = new EstudioClinicoBucles();
        String ruta = "data/estudio_clinico.csv";
        List<PacienteEstudio> lista = estudio.leeFichero(ruta);
        for(PacienteEstudio p : lista){
            System.out.println(p);
        }
    }
}
