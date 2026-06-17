# language: es
@PIM @UpdateEmployee @Positivo
Característica: Actualización de empleados en PIM

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema
    Y que existe un empleado recien creado en el sistema

  Escenario: Actualizar la informacion de un empleado
    Cuando el usuario navega a la lista de empleados
    Y el usuario selecciona el empleado para editar
    Y el usuario actualiza el nombre del empleado a "Modificado"
    Y el usuario guarda el registro
    Entonces el sistema confirma la actualizacion del empleado
