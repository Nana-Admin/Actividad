# language: es
@PIM @DeleteEmployee @Positivo
Característica: Eliminación de empleados en PIM

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema
    Y que existe un empleado recien creado en el sistema

  Escenario: Eliminar un empleado existente
    Cuando el usuario navega a la lista de empleados
    Y el usuario selecciona un empleado y lo elimina
    Entonces el sistema elimina el empleado de la lista
