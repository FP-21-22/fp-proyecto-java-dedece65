package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class FactoriaMedicamentos {
	public static List<Medicamento> leeFichero(String ruta) {
		//efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019
		List<Medicamento> res = new ArrayList<>();
		List<String> aux = null;
		try{
			aux = Files.readAllLines(Paths.get(ruta));
		}catch(IOException e){
			e.printStackTrace();
		}
		// Nos saltamos la primera línea
		int cont = 0;
		assert aux != null;
		for (String e : aux) {
			if(cont>0){
				Medicamento m = ParseaMedicamento(e);
				res.add(m);
			}
			cont++;
		}
		return res;
	}
	public static Medicamento ParseaMedicamento(String cadena) {
		//Ejemplo de cadena: efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019
		//String tipomedicamento string string double integer localdate boolean
		//
		Checkers.checkNoNull("Linea vacia", cadena);
		String[] Medicamento = cadena.split(",");
		Checkers.check("Error parametros", Medicamento.length == 7);
		//
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
