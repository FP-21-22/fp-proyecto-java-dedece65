package fp.vacunas.Tests;

import fp.vacunas.FactoriaVacunaciones;
import fp.vacunas.Vacunacion;

import java.util.List;

public class TestFactoriaVacunaciones {
    public static void main(String[] args) {
        List<Vacunacion> vacunas = FactoriaVacunaciones.leeFichero("data/ccaa_vacunas_3.csv");
        for (Vacunacion v : vacunas) {
            System.out.println(v);
            System.out.println(v.numeroTotal());
        }
    }
}
