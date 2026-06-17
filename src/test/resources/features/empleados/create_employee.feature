# language: es
@PIM @CreateEmployee @Positivo
Característica: Registro de empleados en PIM

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Registrar un nuevo empleado exitosamente
    Cuando el usuario navega a la seccion de agregar empleado
    Y el usuario ingresa los datos del nuevo empleado "Carlos" "Garcia"
    Y el usuario guarda el registro
    Entonces el sistema muestra un mensaje de confirmacion del empleado creado
