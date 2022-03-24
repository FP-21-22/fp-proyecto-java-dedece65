package fp.farmaceutico.test;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;

public class TestMedicamentos {

	public static void main(String[] args) {
		//
		Medicamento m1 = FactoriaMedicamentos.ParseaMedicamento("efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m1);
		System.out.println("m1.tratarEnfermedad(trata1): "+m1.tratarEnfermedad("Y212XXA"));
		System.out.println("m1.tratarEnfermedad(trata2): "+m1.tratarEnfermedad("albacete"));
	}

}
