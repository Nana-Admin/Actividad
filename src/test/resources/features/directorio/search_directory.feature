# language: es
@Directory @SearchDirectory @Positivo
Característica: Búsqueda en el directorio corporativo

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Buscar un empleado en el directorio corporativo
    Cuando el usuario navega a la seccion de directorio
    Y el usuario busca por nombre "Admin" en el directorio
    Entonces el sistema muestra los resultados del directorio
