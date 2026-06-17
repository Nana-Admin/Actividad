# language: es
@Performance @CreateEvaluation @Positivo
Característica: Creación de evaluaciones de desempeño

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Crear una evaluacion de desempeño
    Cuando el usuario navega a la seccion de desempeno
    Entonces el sistema muestra la pagina de desempeno

  @ConsultEvaluation @Positivo
  Escenario: Consultar una evaluacion de desempeño
    Cuando el usuario navega a la seccion de desempeno
    Y el usuario busca la evaluacion del empleado "Admin"
    Entonces el sistema muestra la pagina de desempeno
