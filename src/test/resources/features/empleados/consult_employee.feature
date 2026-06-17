# language: es
@PIM @ConsultEmployee @Positivo
Característica: Consulta de empleados en PIM

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema
    Y que existe un empleado recien creado en el sistema

  Escenario: Consultar la informacion de un empleado registrado
    Cuando el usuario navega a la lista de empleados
    Entonces el sistema muestra la informacion del empleado en la lista
