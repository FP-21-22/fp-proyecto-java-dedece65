package fp.vacunas;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings({"OptionalGetWithoutIsPresent", "unused"})
public class Vacunaciones {

    private final List<Vacunacion> vacunaciones;
    public Vacunaciones(Stream<Vacunacion>st) {
         this.vacunaciones = st.toList();
    }

    public void anyadeVacunaciones(Vacunacion objeto){
        this.vacunaciones.add(objeto);
    }

    public List<Vacunacion> vacunacionesEntreFechas(LocalDate fecha1, LocalDate fecha2){
        return this.vacunaciones.stream()
                .filter(x->x.fecha().isAfter(fecha1) && x.fecha().isBefore(fecha2))
                .collect(Collectors.toList());
    }

    public boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad, Integer n){
        //
        return this.vacunaciones.stream()
                .anyMatch(x->x.comunidad().equals(comunidad) && x.numeroPersonas() > n);
    }

    public LocalDate  diaMasVacunacionesEn(String comunidad){
        //
        return this.vacunaciones.stream()
                .filter(x->x.comunidad().equals(comunidad))
                .max(Comparator.comparing(Vacunacion::numeroTotal))
                .get()
                .fecha();
    }

    public Map<LocalDate, List<Vacunacion>> vacunacionesPorFecha(){
        //
        return this.vacunaciones.stream()
                .collect(Collectors.groupingBy(
                        Vacunacion::fecha
                ));
    }

    public Map<String, Integer> maximoNumTotalVacunasporComunidad(){
        //
        return this.vacunaciones.stream()
                .collect(Collectors.groupingBy(
                        Vacunacion::comunidad,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Vacunacion::numeroTotal)),
                                opt->opt.get().numeroTotal()
                                )
                ));
    }
}
