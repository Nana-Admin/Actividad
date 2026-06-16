package com.orangehrm.stepsdefinitions;

import com.orangehrm.questions.DirectoryValidation;
import com.orangehrm.tasks.DirectoryTasks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class DirectorySteps {

    @Cuando("el usuario navega a la seccion de directorio")
    public void elUsuarioNavegaASeccionDirectorio() {
        theActorInTheSpotlight().attemptsTo(DirectoryTasks.navigateToDirectory());
    }

    @Cuando("el usuario busca por nombre {string} en el directorio")
    public void elUsuarioBuscaPorNombreEnDirectorio(String name) {
        theActorInTheSpotlight().attemptsTo(DirectoryTasks.searchByName(name));
    }

    @Entonces("el sistema muestra los resultados del directorio")
    public void elSistemaMuestraResultadosDelDirectorio() {
        theActorInTheSpotlight().should(
                seeThat("Directory results shown", DirectoryValidation.resultsAreDisplayed(), is(true))
        );
    }
}
