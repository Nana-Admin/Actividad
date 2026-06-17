# language: es
@Admin @CreateUser @Positivo
Característica: Creación de usuarios del sistema

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Crear un usuario del sistema
    Cuando el usuario navega a la seccion de administracion de usuarios
    Y el usuario hace clic en agregar usuario
    Y el usuario completa el formulario con usuario "testuser123" y contrasena "Test123456"
    Y el usuario guarda el nuevo usuario
    Entonces el sistema confirma la creacion del usuario
