package com.orangehrm.stepsdefinitions;

import com.orangehrm.questions.ProfileValidation;
import com.orangehrm.tasks.ProfileTasks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class ProfileSteps {

    @Cuando("el usuario navega a la seccion de mi perfil")
    public void elUsuarioNavegaASeccionMiPerfil() {
        theActorInTheSpotlight().attemptsTo(ProfileTasks.navigateToMyProfile());
    }

    @Cuando("el usuario actualiza la informacion personal con nombre {string} y apellido {string}")
    public void elUsuarioActualizaInformacionPersonal(String firstName, String lastName) {
        theActorInTheSpotlight().attemptsTo(ProfileTasks.updatePersonalInfo(firstName, lastName));
    }

    @Cuando("el usuario guarda los cambios de perfil")
    public void elUsuarioGuardaCambiosDePerfil() {
        theActorInTheSpotlight().attemptsTo(ProfileTasks.saveProfile());
    }

    @Entonces("el sistema muestra el perfil del usuario")
    public void elSistemaMuestraElPerfilDelUsuario() {
        theActorInTheSpotlight().should(
                seeThat("Profile displayed", ProfileValidation.pageIsDisplayed(), is(true))
        );
    }

    @Entonces("el sistema confirma la actualizacion del perfil")
    public void elSistemaConfirmaActualizacionDelPerfil() {
        theActorInTheSpotlight().should(
                seeThat("Profile updated", ProfileValidation.infoIsUpdated(), is(true))
        );
    }
}
