# language: es
@Admin @UpdateUser @Positivo
Característica: Actualización de usuarios del sistema

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Actualizar la informacion de un usuario
    Cuando el usuario navega a la seccion de administracion de usuarios
    Y el usuario busca el usuario por nombre de usuario "Admin"
    Y el usuario hace clic en editar usuario
    Y el usuario guarda el registro
    Entonces el sistema confirma la actualizacion del usuario
