package com.orangehrm.stepsdefinitions;

import com.orangehrm.questions.DashboardValidation;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class DashboardSteps {

    @Entonces("el sistema muestra el panel principal correctamente")
    public void elSistemaMuestraPanelPrincipalCorrectamente() {
        theActorInTheSpotlight().should(
                seeThat("Dashboard displayed", DashboardValidation.isDisplayed(), is(true))
        );
    }

    @Entonces("el sistema muestra los widgets e indicadores disponibles")
    public void elSistemaMuestraWidgetsEIndicadores() {
        theActorInTheSpotlight().should(
                seeThat("Widgets visible", DashboardValidation.hasWidgets(), is(true))
        );
    }
}
