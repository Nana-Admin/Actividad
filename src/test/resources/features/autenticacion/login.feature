# language: es
@Autenticacion @Login
Característica: Autenticación en OrangeHRM

  Antecedentes:
    Dado que el usuario abre la pagina de login

  @LoginExitoso @Positivo
  Escenario: Iniciar sesión con credenciales válidas
    Cuando el usuario ingresa credenciales validas
    Entonces el sistema muestra el dashboard principal

  @LoginFallido @Negativo
  Escenario: Iniciar sesión con credenciales incorrectas
    Cuando el usuario ingresa credenciales incorrectas
    Entonces el sistema muestra un mensaje de error "Invalid credentials"

  @LoginCamposVacios @Negativo
  Escenario: Iniciar sesión con campos vacíos
    Cuando el usuario deja los campos vacios e intenta iniciar sesion
    Entonces el sistema muestra mensajes de campos requeridos

  @LoginUsuarioInexistente @Negativo
  Escenario: Iniciar sesión con usuario inexistente
    Cuando el usuario ingresa un usuario que no existe
    Entonces el sistema muestra un mensaje de error "Invalid credentials"

  @LoginCaracteresEspeciales @Borde
  Escenario: Iniciar sesión con caracteres especiales en las credenciales
    Cuando el usuario ingresa "/*!\"$%&=?*" en los campos de credenciales
    Entonces el sistema muestra un mensaje de error "Invalid credentials"

  @LoginContrasenaEspacios @Borde
  Escenario: Iniciar sesión con espacios en la contraseña
    Cuando el usuario ingresa "  admin123  " como contrasena
    Entonces el sistema muestra un mensaje de error "Invalid credentials"

  @Logout @Positivo
  Escenario: Cerrar sesión exitosamente
    Cuando el usuario ingresa credenciales validas
    Y el usuario selecciona la opcion de cerrar sesion
    Entonces el sistema redirige a la pagina de login
