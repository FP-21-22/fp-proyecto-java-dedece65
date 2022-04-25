package fp.vacunas;

import fp.utiles.Checkers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FactoriaVacunaciones {
    public static List<Vacunacion> leeFichero(String ruta) {
        //
        List<Vacunacion> res = new ArrayList<>();
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
            if (cont > 0) {
                Vacunacion v = parseaVacunacion(e);
                res.add(v);
            }
            cont++;
        }
        return res;
    }

    private static Vacunacion parseaVacunacion(String cadena) {
        //04/01/2021;Andalucía;140295;0;0;0;0
        //
        Checkers.checkNoNull("Linea vacia", cadena);
        String[] aux = cadena.split(";");
        Checkers.check("Error parametros", aux.length == 7);
        //
        LocalDate fecha = LocalDate.parse(aux[0].trim(),
                DateTimeFormatter.ofPattern("d/M/y"));
        String comunidad = aux[1].trim();
        Integer pfizer = Integer.parseInt(aux[2]);
        Integer moderna = Integer.parseInt(aux[3]);
        Integer astrazeneca = Integer.parseInt(aux[4]);
        Integer janssen = Integer.parseInt(aux[5]);
        Integer numeroPersonas = Integer.parseInt(aux[6]);
        return new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janssen, numeroPersonas);
    }
}