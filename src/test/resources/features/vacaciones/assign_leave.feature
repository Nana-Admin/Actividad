# language: es
@Leave @AssignLeave @Positivo
Característica: Asignación de vacaciones

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Asignar vacaciones a un empleado
    Cuando el usuario navega a la seccion de asignar vacaciones
    Y el usuario completa los datos de vacaciones para "Odis Adalwin" del "2026-06-20" al "2026-06-21"
    Y el usuario asigna las vacaciones
    Entonces el sistema confirma la asignacion de vacaciones
