package com.orangehrm.stepsdefinitions;

import com.orangehrm.questions.PerformanceValidation;
import com.orangehrm.tasks.PerformanceTasks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class PerformanceSteps {

    @Cuando("el usuario navega a la seccion de desempeno")
    public void elUsuarioNavegaASeccionDesempeno() {
        theActorInTheSpotlight().attemptsTo(PerformanceTasks.navigateToPerformance());
    }

    @Cuando("el usuario busca la evaluacion del empleado {string}")
    public void elUsuarioBuscaEvaluacionEmpleado(String employee) {
        theActorInTheSpotlight().attemptsTo(PerformanceTasks.searchEmployeePerformance(employee));
    }

    @Entonces("el sistema muestra la pagina de desempeno")
    public void elSistemaMuestraPaginaDeDesempeno() {
        theActorInTheSpotlight().should(
                seeThat("Performance page displayed", PerformanceValidation.pageIsDisplayed(), is(true))
        );
    }
}
