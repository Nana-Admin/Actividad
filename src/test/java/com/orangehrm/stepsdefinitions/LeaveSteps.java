package com.orangehrm.stepsdefinitions;

import com.orangehrm.questions.LeaveValidation;
import com.orangehrm.tasks.LeaveTasks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class LeaveSteps {

    @Cuando("el usuario navega a la seccion de asignar vacaciones")
    public void elUsuarioNavegaASeccionAsignarVacaciones() {
        theActorInTheSpotlight().attemptsTo(LeaveTasks.navigateToAssignLeave());
    }

    @Cuando("el usuario navega a la lista de vacaciones")
    public void elUsuarioNavegaAListaDeVacaciones() {
        theActorInTheSpotlight().attemptsTo(LeaveTasks.navigateToLeave());
    }

    @Cuando("el usuario completa los datos de vacaciones para {string} del {string} al {string}")
    public void elUsuarioCompletaDatosVacaciones(String employee, String from, String to) {
        theActorInTheSpotlight().attemptsTo(LeaveTasks.fillAssignLeave(employee, from, to));
    }

    @Cuando("el usuario asigna las vacaciones")
    public void elUsuarioAsignaLasVacaciones() {
        theActorInTheSpotlight().attemptsTo(LeaveTasks.assignLeave());
    }

    @Cuando("el usuario aprueba la primera solicitud pendiente")
    public void elUsuarioApruebaPrimeraSolicitud() {
        theActorInTheSpotlight().attemptsTo(LeaveTasks.approveFirstLeave());
    }

    @Entonces("el sistema muestra la pagina de asignar vacaciones")
    public void elSistemaMuestraPaginaAsignarVacaciones() {
        theActorInTheSpotlight().should(
                seeThat("Assign leave page displayed", LeaveValidation.pageDisplayed(), is(true))
        );
    }

    @Entonces("el sistema muestra la pagina de lista de vacaciones")
    public void elSistemaMuestraPaginaListaVacaciones() {
        theActorInTheSpotlight().should(
                seeThat("Leave list page displayed", LeaveValidation.pageDisplayed(), is(true))
        );
    }

    @Entonces("el sistema confirma la asignacion de vacaciones")
    public void elSistemaConfirmaAsignacionVacaciones() {
        theActorInTheSpotlight().should(
                seeThat("Leave assigned", LeaveValidation.isAssigned(), is(true))
        );
    }

    @Entonces("el sistema muestra la confirmacion de aprobacion")
    public void elSistemaMuestraConfirmacionAprobacion() {
        theActorInTheSpotlight().should(
                seeThat("Leave approved", LeaveValidation.isApproved(), is(true))
        );
    }
}
