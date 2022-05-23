# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2021/2022)
Autor/a: Daniel del Castillo Piñero   uvus: dandelpin


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.clinico**: Paquete que contiene los tipos del proyecto.
  * **fp.farmaceutico**: Paquete que contiene los tipos del proyecto.
  * **fp.farmaceutico.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.vacunas**: Paquete que contiene los tipos del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 


## Tipos implementados

Los tipos implementados son:
  * **Tipo Paciente**: Record.
  * **Tipo PacienteEstudio**: Record.
  * **Tipo Persona**: Record.
  * **Tipo TipoResidencia**: Enumerado.
  * **Tipo FactoriaMedicamentos**: Clase, contiene el parseo de la clase Medicamento.
  * **Tipo Medicamento**: Clase.
  * **Tipo TipoMedicamento**: Enumerado.
  * **Tipo TestMedicamentos**: Clase. Modulo test de la clase Medicamento y FactoriaMedicamentos.
  * **Tipo Vacunacion**: Record.

### Tipo Persona (Record)

**Propiedades**:

- nombre, de tipo String.
- apellidos, de tipo String.
- dni, de tipo String.
- fecha de nacimiento, de tipo LocalDate.
- edad, de tipo Integer. (derivada a partir de la fecha de nacimiento).

**Restricciones**:
 
- R1: La fecha de nacimiento debe ser anterior a la fecha actual.
- R2: El dni debe ser una cadena con ocho digitos y seguidos de una letra.

**Criterio de igualdad**: Por defecto asociado al record.

**Criterio de ordenación**: Por dni.

**Otras operaciones**:
 
-	Metodo static of: recibe nombre, apellidos, dni y fecha de nacimiento y devuelve una persona.
- 	Metodo static parse: Recibe una cadena con un formato específico y devuelve una persona.
-	Metodo main para comprobar el correcto funcionamiento del metodo parse.

### Tipo Paciente (Record)

**Propiedades**:

- persona, de tipo Persona.
- codigo de ingreso, de tipo String.
- fecha y hora de ingreso, de tipo LocalDateTime.
- fecha de ingreso, de tipo LocalDate. (Derivada a partir de la fecha y hora de ingreso).
- hora de ingreso, de tipo String. (Derivada a partir de la fecha y hora de ingreso). 

**Restricciones**:
 
- R1: La fecha y hora de ingreso debe ser anterior o igual a la fecha actual. 

**Representación como cadena**: Por defecto asociado al record.

**Criterio de igualdad**: Por defecto asociado al record.

**Otras operaciones**:
 
-	Metodo static of: recibe nombre, apellidos, dni y fecha de nacimiento, codigo y fecha y hora de ingreso y devuelve un paciente.
-	Metodo static of: recibe un objeto persona, un codigo y una fecha y hora de ingreso y devuelve un paciente.

### Tipo PacienteEstudio (Record)

**Propiedades**:

- id, de tipo String.
- genero, de tipo String.
- edad, de tipo Double.
- hipertension, de tipo Boolean.
- enfermedad del corazon, de tipo Boolean.
- tipo de residencia, enumerado TipoResidencia, cuyos valores son rural o urbana.
- nivel medio de glucosa, de tipo Double.
- factor de riesgo, de tipo Boolean. (Derivada, si tiene hipertension y mas de 40 años se considerara que tiene factor de riesgo).

**Restricciones**:
 
- R1: La edad tiene que ser mayor o igual que cero y menor o igual que 130. 
- R2:  El nivel medio de glucosa tiene que ser mayor o igual que cero.

**Representación como cadena**: Por defecto asociado al record.

**Criterio de igualdad**: Por defecto asociado al record.

**Criterio de orden**: Segun la edad y el id.

**Otras operaciones**:
 
-	Metodo static of: Recibe valores para cada propiedad básica y devuelve un objeto del tipo.
- 	Metodo static parse: Recibe una cadena con un formato especifico y devuelve un objeto del tipo.
-	Metodo main para comprobar el correcto funcionamiento del metodo parse.

### Tipo Vacunacion (Record)

**Propiedades**:

- fecha, de tipo LocalDate.
- comunidad, de tipo String.
- pfizer, de tipo Integer.
- moderna, de tipo Integer.
- astrazeneca, de tipo Integer.
- janssen, de tipo Integer.
- numero de personas, de tipo Integer.
- numero total, de tipo integer (Derivada, siendo la suma de dosis de Pfizer, moderna, astrazeneca y janssen).

**Restricciones**:
 
- R1: La fecha debe ser posterior al 10/02/2021.

**Representación como cadena**: Por defecto asociado al record.

**Criterio de igualdad**: Por defecto asociado al record.

**Criterio de orden**: Por comunidad y en caso de igualdad por fecha.

**Otras operaciones**:
 
-	Metodo static of: Recibe valores para cada propiedad básica y devuelve un objeto del tipo.
- 	Metodo static parse: Recibe una cadena con un formato especifico y devuelve un objeto del tipo.
-	Metodo main para comprobar el correcto funcionamiento del metodo parse.


### Tipo Medicamento (Clase)

**Propiedades**:

- nombre del medicamento, de tipo String, observable. 
- tipo de medicamento, enumerado de tipo TipoMedicamento, observable. Los valores del enumerado son anatomico, quimico y terapeutico.
- codigo de la enfermedad, de tipo String, observable.
- farmaceutica, de tipo String, observable.
- puntacion, de tipo Double, observable.
- indice somatico, de tipo Integer, observable.
- fecha de catalogo, de tipo LocalDate, observable y modificable.
- tratar enfermedad, de tipo Boolean. (Derivada, siendo cierta si el codigo de la enfermedad coincide con un parametro de tipo cadena
que recibe como argumento la propiedad).

**Restricciones**:
 
- R1: La puntacion debe ser mayor estricta que cero.
- R2: El indice somatico tiene que ser mayor o igual que 1000.
- R3: La fecha de catalogo tiene que ser posterior al 01/01/2015.

**Representacion como cadena**: Segun el nombre del medicamento y de la farmaceutica.

**Criterio de igualdad**: Por nombre del medicamento y farmaceutica.

**Orden natural**: Por nombre del medicamento y en caso de igualdad por la farmaceutica.

**Otras operaciones**:
 
- Clase FactoriaMedicamentos: Se ha programado una clase FactoriaMedicamentos que incluye, de momento, un metodo static de nombre 
parseaMedicamento, que recibe una cadena con un formato especifico y devuelve un objeto del tipo Medicamento.
- Clase TestFactoriaMedicamentos: Se ha implementado tambien una clase de nombre TestFactoriaMedicamentos que comprueba el correcto funcionamiento
del metodo anterior.


## Interfaz EstudioClinico

**Métodos**:

- numeroPacientes() : muestra el número de pacientes.
- incluyePaciente(PacienteEstudio paciente) : añade el paciente dado como parámetro a la lista.
- incluyePacientes(Collection<PacienteEstudio> pacientes) : añade los pacientes dados como parámetro a la lista.
- eliminaPaciente(PacienteEstudio paciente) : elimina el paciente dado como parámetro.
- estaPaciente(PacienteEstudio paciente) : devuelve true o false si esta o no el paciente dado como parámetro en la lista de pacientes.
- borraEstudio() : borra la lista completa de pacientes.
- of(String nombreFichero) : metodo de factoria.
- leeFichero(String nombreFichero) : lee el fichero dado como parámetro
- todosPacienteSonDelTipo(TipoResidencia tipo) : comprueba si todos los pacientes son del tipo dado como parámetro.
- existeAlgunPacienteDelTipo(TipoResidencia tipo) : comprueba si hay algun paciente con el tipo dado como parámetro.
- numeroPacientesFactorRiesgo() : muestra el numero de pacientes con FactorRiesgo true.
- filtraPacientesPorEdad(Double edad) : muestra todos los pacientes con la edad introducida como parámetro.
- agruparPacientesEdadMayorQuePorGenero(Double edad) : agrupa los pacientes mayores que la edad introducida como parámetro por género.
- numeroPacientesPorGenero() : muestra los géneros que forman la lista de pacientes junto con el número de pacientes de cada uno.
- edadMediaPacientesPorPorGenero() : muestra la edad media de los pacientes de cada género.

**Clases que usan esta interfaz**:

- EstudioClinicoBucles : metodos programados con bucles.
- EstudioClinicoStreams : metodos programados con .stream().

## Clase Vacunaciones

- Ubicada en el paquete fp.vacunas

**Constructor**:

- Un único constructor que recibe un Stream con objetos del tipo Vacunacion e inicializa el atributo con los objetos de dicho Stream.

**Métodos**:

- anyadeVacunacion: dado un objeto del tipo Vacunacion lo añade al atributo de
  List< Vacunacion>.
- vacunacionesEntreFechas: dadas dos fechas como parámetros de entrada, devuelve
  una lista con aquellas vacunaciones entre dichas fechas.
- existeNumPersonasPautaCompletaPorEncimaDe: dada una comunidad y un valor
  entero, indica si existen o no vacunaciones con un número de personas con la pauta
  completa de vacunación por encima del valor entero dado.
- diaMasVacunacionesEn: dada una comunidad, devuelve la fecha en la que hubo más
  personas vacunadas.
- vacunacionesPorFecha: devuelve un mapa, o diccionario, en el que las claves son las
  fechas y los valores son listas de vacunaciones asociadas a dichas fechas.
- maximoNumTotalVacunasporComunidad: devuelve un mapa, o diccionario, en el
  que las claves son las comunidades y los valores son el máximo para el número total
  de vacunas puestas para cada comunidad.

## Clase ListadoMedicamentos

- Ubicada en el paquete fp.farmaceutico

**Constructor**:

- Un único constructor que recibe un Stream con objetos del tipo Medicamento e inicializa el atributo con los objetos de dicho Stream.

**Métodos**:

- existeMedicamentoSegunTipoAnteriorA: dado un tipo de medicamento y una fecha,
  indica si existe un medicamento de dicho tipo posterior a la fecha dada.
- nombreMedicamentosPuntuacionMayorA: dada una puntuación, devuelve un
  conjunto con los nombres de los medicamentos con una puntuación mayor a la dada.
- nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento: dado un tipo
  de medicamento, devuelve el nombre del medicamento con mayor índice somático.
  En caso de no haber ninguno, se eleva una excepción.
- agrupaTipoMedicamentoSegunPuntuacionMedia: devuelve un diccionario que
  asocia a cada tipo de medicamento su puntuación media.
- fechaCatalogoMasFrecuente: devuelve la fecha del catálogo más frecuente, es decir,
  la que aparece más veces.

## Metodos Adicionales (Interfaz EstudioClinicoAmpliación)

**Metodos que incluye esta interfaz**:

Map<TipoResidencia,Integer> agruparNumeroPacientesPorTipoResidencia();
- Un método que devuelva un diccionario cuyas claves son el tipo de residencia y cuyos valores
asociados son el número de pacientes de cada tipo. Tenga en cuenta que los valores son de tipo
Integer.

Map<TipoResidencia,Double> agruparNivelMedioGlucosaMedioPorTipoResidencia();
- Un método que devuelva un diccionario cuyas claves son el tipo de residencia y cuyo valor asociado
es la media del valor medio de glucosa de los pacientes.

Map<TipoResidencia,PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia();
- Un método que devuelva un diccionario cuyas claves son el tipo de residencia y cuyo valor asociado
es el paciente con mayor nivel medio de glucosa. Tenga en cuenta que los valores son de tipo
PacienteEstudio y no del tipo Optional< PacienteEstudio>.

Map<String,List< PacienteEstudio>> agrupaPacientesPorGenero();
- Un método que devuelva un diccionario cuyas claves son el género del paciente y cuyos valores son
las listas de pacientes asociados a cada género.

Map<String,Set< PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjunto();
- Un método que devuelva un diccionario cuyas claves son el género del paciente y cuyos valores son
los conjuntos de pacientes asociados a cada género.

Map<String,SortedSet< PacienteEstudio>> agrupaPacientesPorPorGeneroEnConjuntoOrdenado();
- Un método que devuelva un diccionario cuyas claves son el género del paciente y cuyos valores son
los conjuntos de pacientes asociados a cada género.

Map<String,PacienteEstudio> pacienteEdadMaximaPacientesPorGenero();
- Un método que devuelva un diccionario cuyas claves son el género del paciente y cuyo valor es el
paciente con mayor edad. Tenga en cuenta que los valores son de tipo PacienteEstudio y no del tipo
Optional< PacienteEstudio>.

Map<String,List< Double>> listaEdadesPorGenero();
- Un método que devuelva un diccionario cuyas claves son el género del paciente y cuyos valores son
listas de edades de los pacientes de cada género.

Map<String,Double> edadMaximaPacientesPorGenero();
- Un método que devuelva un diccionario cuyas claves son el género del paciente y cuyos valores son
listas de edades de los pacientes de cada género.

String generoEdadMaximaPacientesPorGenero();
- Un método que devuelva el género del paciente con más edad. Este método puede hacerlo
basándose en el diccionario que devuelve el método edadMaximaPacientesPorGenero(). 