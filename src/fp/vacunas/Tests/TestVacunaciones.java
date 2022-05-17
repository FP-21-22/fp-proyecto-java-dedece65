package fp.vacunas.Tests;

import fp.vacunas.FactoriaVacunaciones;
import fp.vacunas.Vacunacion;
import fp.vacunas.Vacunaciones;

import java.util.List;

public class TestVacunaciones {
    public static void main(String[] args) {
        List<Vacunacion> lista = FactoriaVacunaciones.leeFichero("data/ccaa_vacunas_3.csv");
        Vacunaciones v = new Vacunaciones(lista.stream());
        System.out.println(v.diaMasVacunacionesEn("Canarias"));
    }
}
