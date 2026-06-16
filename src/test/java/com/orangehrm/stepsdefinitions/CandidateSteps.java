package com.orangehrm.stepsdefinitions;

import com.orangehrm.questions.CandidateValidation;
import com.orangehrm.tasks.CandidateTasks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class CandidateSteps {

    @Cuando("el usuario navega a la seccion de reclutamiento")
    public void elUsuarioNavegaASeccionReclutamiento() {
        theActorInTheSpotlight().attemptsTo(CandidateTasks.navigateToRecruitment());
    }

    @Cuando("el usuario hace clic en agregar candidato")
    public void elUsuarioHaceClicEnAgregarCandidato() {
        theActorInTheSpotlight().attemptsTo(CandidateTasks.clickAddCandidate());
    }

    @Cuando("el usuario completa los datos del candidato {string} {string} con email {string}")
    public void elUsuarioCompletaDatosCandidato(String firstName, String lastName, String email) {
        String uniqueFirst = firstName + System.currentTimeMillis() % 1000;
        String uniqueLast = lastName + System.currentTimeMillis() % 1000;
        String uniqueEmail = "test" + System.currentTimeMillis() % 10000 + "@test.com";
        theActorInTheSpotlight().remember("candFullName", uniqueFirst + " " + uniqueLast);
        theActorInTheSpotlight().attemptsTo(CandidateTasks.fillCandidateDetails(uniqueFirst, uniqueLast, uniqueEmail));
    }

    @Cuando("el usuario guarda el candidato")
    public void elUsuarioGuardaElCandidato() {
        theActorInTheSpotlight().attemptsTo(CandidateTasks.saveCandidate());
    }

    @Cuando("el usuario busca el candidato por nombre {string}")
    public void elUsuarioBuscaCandidatoPorNombre(String name) {
        theActorInTheSpotlight().attemptsTo(CandidateTasks.searchCandidateByName(name));
    }

    @Entonces("el sistema muestra la pagina de reclutamiento")
    public void elSistemaMuestraPaginaReclutamiento() {
        theActorInTheSpotlight().should(
                seeThat("Recruitment page displayed", CandidateValidation.pageDisplayed(), is(true))
        );
    }

    @Entonces("el sistema confirma el registro del candidato")
    public void elSistemaConfirmaRegistroDelCandidato() {
        theActorInTheSpotlight().should(
                seeThat("Candidate saved", CandidateValidation.isSaved(), is(true))
        );
    }

    @Entonces("el sistema muestra el candidato en la lista")
    public void elSistemaMuestraCandidatoEnLista() {
        String fullName = theActorInTheSpotlight().recall("candFullName");
        theActorInTheSpotlight().should(
                seeThat("Candidate found", CandidateValidation.isInList(fullName), is(true))
        );
    }
}
