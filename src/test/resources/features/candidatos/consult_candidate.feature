# language: es
@Recruitment @ConsultCandidate @Positivo
Característica: Consulta de candidatos

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Consultar la informacion de un candidato
    Cuando el usuario navega a la seccion de reclutamiento
    Y el usuario busca el candidato por nombre "Odis Adalwin"
    Entonces el sistema muestra el candidato en la lista
