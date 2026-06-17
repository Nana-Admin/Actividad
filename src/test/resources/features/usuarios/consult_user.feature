# language: es
@Admin @ConsultUser @Positivo
Característica: Consulta de usuarios del sistema

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Consultar un usuario del sistema
    Cuando el usuario navega a la seccion de administracion de usuarios
    Y el usuario busca el usuario por nombre de usuario "Admin"
    Entonces el sistema muestra el usuario "Admin" en la lista
