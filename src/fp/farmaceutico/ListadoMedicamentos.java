package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListadoMedicamentos {

    private final List<Medicamento> ListadoMedicamentos;

    public ListadoMedicamentos(Stream<Medicamento> st){
        this.ListadoMedicamentos = st.toList();
    }

    public boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento tipo, LocalDate fecha){
        return this.ListadoMedicamentos.stream()
                .anyMatch(x->x.tipoMedicamento.equals(tipo) && x.fechaCatalogo.isAfter(fecha));
    }

    public Set<String> nombreMedicamentosPuntuacionMayorA(Double puntuacion){
        return this.ListadoMedicamentos.stream()
                .filter(x->x.puntacion>puntuacion)
                .map(Medicamento::getNombreMedicamento)
                .collect(Collectors.toSet());
    }

    public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento tipo){
        return this.ListadoMedicamentos.stream()
                .filter(x->x.tipoMedicamento.equals(tipo))
                .max(Comparator.comparing(Medicamento::getIndiceSomatico))
                .orElseThrow(()->new IllegalArgumentException("No hay medicamentos"))
                .nombreMedicamento;
    }

    public Map<TipoMedicamento, Double> agrupaTipoMedicamentoSegunPuntuacionMedia(){
        return this.ListadoMedicamentos.stream()
                .collect(Collectors.groupingBy(
                        Medicamento::getTipoMedicamento,
                        Collectors.averagingDouble(Medicamento::getPuntacion)
                ));
    }

    public LocalDate fechaCatalogoMasFrecuente(){
        Map<LocalDate, Integer> aux = this.ListadoMedicamentos.stream()
                .collect(Collectors.groupingBy(
                        Medicamento::getFechaCatalogo,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
        return aux.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get().getKey();
    }
}
