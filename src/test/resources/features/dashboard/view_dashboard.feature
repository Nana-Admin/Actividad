# language: es
@Dashboard @ViewDashboard @Positivo
Característica: Visualización del panel principal

  Antecedentes:
    Dado que el usuario esta autenticado en el sistema

  Escenario: Visualizar correctamente el panel principal del sistema
    Entonces el sistema muestra el panel principal correctamente

  @Widgets @Positivo
  Escenario: Consultar los widgets e indicadores disponibles
    Entonces el sistema muestra los widgets e indicadores disponibles
