package fp.farmaceutico.test;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;

import java.util.List;

public class TestFactoriaMedicamentos {

	public static void main(String[] args) {
		//
		Medicamento m1 = FactoriaMedicamentos.ParseaMedicamento("efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m1);
		System.out.println("Test(true) m1.tratarEnfermedad(trata1): "+m1.tratarEnfermedad("Y212XXA"));
		System.out.println("Test(true) m1.tratarEnfermedad(trata2): "+m1.tratarEnfermedad("albacete"));
		List<Medicamento> lista = FactoriaMedicamentos.leeFichero("data/medicamentos.csv");
		for (Medicamento m : lista) {
			System.out.println(m);
		}
	}

}
