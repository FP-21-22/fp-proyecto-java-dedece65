package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class Medicamento implements Comparable<Medicamento> {
	//Atributos
	private String nombreMedicamento;//observable
	private TipoMedicamento tipoMedicamento;//observable
	private String codigoEnfermedad;//observable
	private String farmaceutica;//observable
	private Double puntuacion;//observable
	private Integer indiceSomatico;//observable
	private LocalDate fechaCatalogo;//observable y modificable
	private Boolean tratarEnfermedad;//DERIVADA DE ABAJO (PUESTO PARA NO ERROR EN EL CODIGO PERO NO VA AQUI)
	
	//Derivadas
	
	private Boolean tratarEnfermedad(String cadena) {
		Boolean res = false;
		if(this.codigoEnfermedad == cadena) {
			res = true;
		}
		return res;
	}

	//Constructores
	public Medicamento(String nombreMedicamento, TipoMedicamento tipoMedicamento, String codigoEnfermedad,
			String farmaceutica, Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		//RESTRICCIONES---------------------
		Checkers.check("R1: ...", puntuacion > 0);
		Checkers.check("R2: ...", indiceSomatico >= 1000);
		Checkers.check("R3: ...", fechaCatalogo.isAfter(LocalDate.of(2015, 1, 1)));
		//----------------------------------
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.codigoEnfermedad = codigoEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaCatalogo = fechaCatalogo;
	}
	//Metodos de las propiedades
	
	public LocalDate getFechaCatalogo() {
		return fechaCatalogo;
	}
	public void setFechaCatalogo(LocalDate fechaCatalogo) {
		this.fechaCatalogo = fechaCatalogo;
	}
	public String getNombreMedicamento() {
		return nombreMedicamento;
	}
	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}
	public String getCodigoEnfermedad() {
		return codigoEnfermedad;
	}
	public String getFarmaceutica() {
		return farmaceutica;
	}
	public Double getPuntuacion() {
		return puntuacion;
	}
	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}
	
	//-----------------------------------	GET DEL METODO DERIVADO --------------------------------
	public Boolean getTratarEnfermedad() {
		return tratarEnfermedad;
	}
	//----------------------------------------------------------------------------------------------

	// Metodos adicionales
	//	a) Representacion como cadena (redefinir el toString())

	public String representacionCadena() {
		String res = this.getNombreMedicamento()+","+this.getFarmaceutica();
		return res;
	}

	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + nombreMedicamento + ", tipoMedicamento=" + tipoMedicamento
				+ ", codigoEnfermedad=" + codigoEnfermedad + ", farmaceutica=" + farmaceutica + ", puntuacion="
				+ puntuacion + ", indiceSomatico=" + indiceSomatico + ", fechaCatalogo=" + fechaCatalogo
				+ ", tratarEnfermedad=" + tratarEnfermedad + "]";
	}
	
	//	b) Igualdad (Redefinir el equals y hashCode)
	
	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, nombreMedicamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(nombreMedicamento, other.nombreMedicamento);
	}
	
	//	c) Orden (se debe a la interfaz Comparable<T>)
	
	@Override
	public int compareTo(Medicamento o) {
		//
		int res = this.nombreMedicamento.compareTo(o.nombreMedicamento);
		if (res==0) {
			res = this.farmaceutica.compareTo(o.farmaceutica);
		}
		return res;
	}
}