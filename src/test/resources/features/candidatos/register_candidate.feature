# language: es
@Recruitment @RegisterCandidate @Positivo
Característica: Registro de candidatos

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Registrar un nuevo candidato
    Cuando el usuario navega a la seccion de reclutamiento
    Y el usuario hace clic en agregar candidato
    Y el usuario completa los datos del candidato "Maria" "Lopez" con email "maria.lopez@test.com"
    Y el usuario guarda el candidato
    Entonces el sistema confirma el registro del candidato
