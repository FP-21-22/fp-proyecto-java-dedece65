package fp.farmaceutico.test;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;

public class TestMedicamentos {

	public static void main(String[] args) {
		//
		Medicamento m1 = FactoriaMedicamentos.ParseaMedicamento("efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
		System.out.println(m1);
	}

}
