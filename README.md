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

**Representación como cadena: Por defecto asociado al record.

**Criterio de igualdad**: Por defecto asociado al record.

**Otras operaciones**:
 
-	Metodo static of: recibe nombre, apellidos, dni y fecha de nacimiento, codigo y fecha y hora de ingreso y devuelve un paciente.
-	Metodo static of: recibe un objeto persona, un codigo y una fecha y hora de ingreso y devuelve un paciente.


### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
