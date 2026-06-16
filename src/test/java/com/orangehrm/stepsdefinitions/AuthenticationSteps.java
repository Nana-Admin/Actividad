package com.orangehrm.stepsdefinitions;

import com.orangehrm.models.LoginCredentials;
import com.orangehrm.questions.LoginValidation;
import com.orangehrm.tasks.LoginTask;
import com.orangehrm.tasks.LogoutTask;
import com.orangehrm.tasks.OpenPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class AuthenticationSteps {

    @Cuando("el usuario ingresa credenciales validas")
    public void elUsuarioIngresaCredencialesValidas() {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials(LoginCredentials.getUsername(), LoginCredentials.getPassword())
        );
    }

    @Cuando("el usuario ingresa credenciales incorrectas")
    public void elUsuarioIngresaCredencialesIncorrectas() {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials("wronguser", "wrongpass")
        );
    }

    @Cuando("el usuario deja los campos vacios e intenta iniciar sesion")
    public void elUsuarioDejaLosCamposVacios() {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials("", "")
        );
    }

    @Cuando("el usuario ingresa un usuario que no existe")
    public void elUsuarioIngresaUnUsuarioQueNoExiste() {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials("noexiste", LoginCredentials.getPassword())
        );
    }

    @Cuando("el usuario ingresa {string} en los campos de credenciales")
    public void elUsuarioIngresaCaracteresEspeciales(String caracteres) {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials(caracteres, caracteres)
        );
    }

    @Cuando("el usuario ingresa {string} como contrasena")
    public void elUsuarioIngresaContrasenaConEspacios(String password) {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials(LoginCredentials.getUsername(), password)
        );
    }

    @Cuando("el usuario selecciona la opcion de cerrar sesion")
    public void elUsuarioSeleccionaOpcionCerrarSesion() {
        theActorInTheSpotlight().attemptsTo(LogoutTask.now());
    }

    @Entonces("el sistema muestra el dashboard principal")
    public void elSistemaMuestraElDashboard() {
        theActorInTheSpotlight().should(
                seeThat("Dashboard visible", LoginValidation.isSuccessful(), is(true))
        );
    }

    @Entonces("el sistema muestra un mensaje de error {string}")
    public void elSistemaMuestraMensajeError(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat("Error message visible", LoginValidation.showsError(mensaje), is(true))
        );
    }

    @Entonces("el sistema muestra mensajes de campos requeridos")
    public void elSistemaMuestraMensajesCamposRequeridos() {
        theActorInTheSpotlight().should(
                seeThat("Required field errors visible", LoginValidation.showsRequiredField(), is(true))
        );
    }

    @Entonces("el sistema redirige a la pagina de login")
    public void elSistemaRedirigeAPaginaLogin() {
        theActorInTheSpotlight().should(
                seeThat("Redirected to login", LoginValidation.redirectsToLogin(), is(true))
        );
    }
}
