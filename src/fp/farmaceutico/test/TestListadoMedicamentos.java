package fp.farmaceutico.test;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.ListadoMedicamentos;
import fp.farmaceutico.Medicamento;

import java.util.List;

public class TestListadoMedicamentos {
    public static void main(String[] args) {
        List<Medicamento> lista = FactoriaMedicamentos.leeFichero("data/medicamentos.csv");
        ListadoMedicamentos m1 = new ListadoMedicamentos(lista.stream());
        System.out.println(m1.agrupaTipoMedicamentoSegunPuntuacionMedia());
    }
}
