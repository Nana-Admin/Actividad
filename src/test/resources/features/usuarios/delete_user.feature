# language: es
@Admin @DeleteUser @Positivo
Característica: Eliminación de usuarios del sistema

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema
    Y que existe un usuario recien creado en el sistema

  Escenario: Eliminar un usuario del sistema
    Entonces el sistema muestra la pagina de administracion de usuarios
