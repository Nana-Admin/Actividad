# language: es
@Profile @UpdateProfile @Positivo
Característica: Actualización del perfil de usuario

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Actualizar la informacion personal del usuario autenticado
    Cuando el usuario navega a la seccion de mi perfil
    Y el usuario actualiza la informacion personal con nombre "AdminMod" y apellido "Test"
    Y el usuario guarda los cambios de perfil
    Entonces el sistema muestra el perfil del usuario
    Y el sistema confirma la actualizacion del perfil

  @UpdatePhoto @Positivo
  Escenario: Actualizar la fotografia de perfil
    Cuando el usuario navega a la seccion de mi perfil
    Entonces el sistema muestra el perfil del usuario
