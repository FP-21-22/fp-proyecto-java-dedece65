package fp.clinico;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioClinicoAmpliacionStream extends EstudioClinicoStreams implements EstudioClinicoAmpliacion{
    //
    public EstudioClinicoAmpliacionStream(){
        super();
    }

    public EstudioClinicoAmpliacionStream(List<PacienteEstudio> lista){
        super(lista);
    }

//    public EstudioClinicoAmpliacionStream(Stream<PacienteEstudio> st){
//        super(st);
//    }

    @Override
    public Map<TipoResidencia, Integer> agruparNumeroPacientesPorTipoResidencia() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::tipoResidencia,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                Long::intValue
                        )
                ));
    }

    @Override
    public Map<TipoResidencia, Double> agruparNivelMedioGlucosaMedioPorTipoResidencia() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::tipoResidencia,
                        Collectors.averagingDouble(PacienteEstudio::nivelMedioGlucosa)
                ));
    }

    @SuppressWarnings("SimplifyCollector")
    @Override
    public Map<TipoResidencia, PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::tipoResidencia,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(PacienteEstudio::nivelMedioGlucosa)),
                                Optional::get
                        )
                ));
    }

    @Override
    public Map<String, List<PacienteEstudio>> agrupaPacientesPorGenero() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::genero
                ));
    }

    @Override
    public Map<String, Set<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjunto() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::genero,
                        Collectors.toSet()
                ));
    }

    @Override
    public Map<String, SortedSet<PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjuntoOrdenado() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::genero,
                        Collectors.collectingAndThen(
                                Collectors.toSet(),
                                Set -> new TreeSet<>()
                        )
                ));
    }

    @SuppressWarnings("SimplifyCollector")
    @Override
    public Map<String, PacienteEstudio> pacienteEdadMaximaPacientesPorGenero() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::genero,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(PacienteEstudio::edad)),
                                Optional::get
                        )
                ));
    }

    @Override
    public Map<String, List<Double>> listaEdadesPorGenero() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::genero,
                        Collectors.mapping(PacienteEstudio::edad, Collectors.toList())
                ));
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public Map<String, Double> edadMaximaPacientesPorGenero() {
        //
        return super.listaPacientes.stream()
                .collect(Collectors.groupingBy(
                        PacienteEstudio::genero,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(PacienteEstudio::edad)),
                                opt -> opt.get().edad()
                        )
                ));
    }

    @Override
    public String generoEdadMaximaPacientesPorGenero() {
        //
        Double maximo = edadMaximaPacientesPorGenero().values().stream()
                .sorted()
                .toList()
                .get(edadMaximaPacientesPorGenero().values().size() - 1);
        List<Map.Entry<String, Double>> generoConEdadMaxima = edadMaximaPacientesPorGenero().entrySet().stream()
                .filter(x -> x.getValue().equals(maximo)).toList();
        return null;
    }
}
