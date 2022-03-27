package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public class FactoriaMedicamentos {
	public static Medicamento ParseaMedicamento(String cadena) {
		//Ejemplo de cadena: “efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019”
		//String tipomedicamento string string double integer localdate boolean
		//
		Checkers.checkNoNull("Linea vacia", cadena);
		String[] Medicamento = cadena.split(",");
		Checkers.check("Error parametros", Medicamento.length == 7);
		String nombreMedicamento = Medicamento[0];
		TipoMedicamento tipoMedicamento = TipoMedicamento.valueOf(Medicamento[1]);
		String codigoEnfermedad = Medicamento[2];
		String farmaceutica = Medicamento[3];
		Double puntacion = Double.parseDouble(Medicamento[4]);
		Integer indiceSomatico = Integer.parseInt(Medicamento[5]);
		String fecha = Medicamento[6].strip();
		LocalDate fechaCatalogo = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento (nombreMedicamento, tipoMedicamento, codigoEnfermedad, farmaceutica, puntacion, indiceSomatico, fechaCatalogo);
	}
}
