package com.orangehrm.stepsdefinitions;

import com.orangehrm.questions.UserValidation;
import com.orangehrm.tasks.UserTasks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class UserSteps {

    private String generateUnique() {
        return "utest" + System.currentTimeMillis() % 100000;
    }

    @Dado("que existe un usuario recien creado en el sistema")
    public void queExisteUnUsuarioRecienCreado() {
        Actor actor = theActorInTheSpotlight();
        String username = generateUnique();
        String password = "Test123456";
        actor.remember("testUsername", username);
        actor.remember("testPassword", password);
        actor.attemptsTo(Open.url(com.orangehrm.userinterfaces.Urls.ADMIN_USER_MANAGEMENT));
        actor.attemptsTo(UserTasks.clickAddUser());
        actor.attemptsTo(UserTasks.fillUserForm(username, password));
        actor.attemptsTo(UserTasks.saveUser());
    }

    @Cuando("el usuario navega a la seccion de administracion de usuarios")
    public void elUsuarioNavegaAAdministracionUsuarios() {
        theActorInTheSpotlight().attemptsTo(UserTasks.navigateToUserManagement());
    }

    @Cuando("el usuario hace clic en agregar usuario")
    public void elUsuarioHaceClicEnAgregarUsuario() {
        theActorInTheSpotlight().attemptsTo(UserTasks.clickAddUser());
    }

    @Cuando("el usuario completa el formulario con usuario {string} y contrasena {string}")
    public void elUsuarioCompletaFormularioUsuario(String username, String password) {
        String uniqueUser = username + System.currentTimeMillis() % 1000;
        theActorInTheSpotlight().remember("testUsername", uniqueUser);
        theActorInTheSpotlight().attemptsTo(UserTasks.fillUserForm(uniqueUser, password));
    }

    @Cuando("el usuario guarda el nuevo usuario")
    public void elUsuarioGuardaElNuevoUsuario() {
        theActorInTheSpotlight().attemptsTo(UserTasks.saveUser());
    }

    @Cuando("el usuario busca el usuario por nombre de usuario {string}")
    public void elUsuarioBuscaUsuarioPorUsername(String username) {
        theActorInTheSpotlight().attemptsTo(UserTasks.searchUserByUsername(username));
    }

    @Cuando("el usuario busca el usuario creado")
    public void elUsuarioBuscaUsuarioCreado() {
        String username = theActorInTheSpotlight().recall("testUsername");
        theActorInTheSpotlight().attemptsTo(UserTasks.searchUserByUsername(username));
    }

    @Cuando("el usuario selecciona un usuario y lo elimina")
    public void elUsuarioSeleccionaUsuarioYLoElimina() {
        theActorInTheSpotlight().attemptsTo(UserTasks.deleteUser());
    }

    @Cuando("el usuario hace clic en editar usuario")
    public void elUsuarioHaceClicEnEditarUsuario() {
        theActorInTheSpotlight().attemptsTo(UserTasks.clickEditUser());
    }

    @Entonces("el sistema muestra el usuario {string} en la lista")
    public void elSistemaMuestraUsuarioEnLista(String username) {
        theActorInTheSpotlight().should(
                seeThat("User found in list", UserValidation.isInUserList(username), is(true))
        );
    }

    @Entonces("el sistema muestra la pagina de administracion de usuarios")
    public void elSistemaMuestraPaginaAdminUsuarios() {
        theActorInTheSpotlight().should(
                seeThat("Admin page displayed", UserValidation.pageDisplayed(), is(true))
        );
    }

    @Entonces("el sistema confirma la creacion del usuario")
    public void elSistemaConfirmaCreacionDelUsuario() {
        theActorInTheSpotlight().should(
                seeThat("User created", UserValidation.isSaved(), is(true))
        );
    }

    @Entonces("el sistema elimina el usuario de la lista")
    public void elSistemaEliminaUsuarioDeLaLista() {
        theActorInTheSpotlight().should(
                seeThat("User deleted", UserValidation.isDeleted(), is(true))
        );
    }

    @Entonces("el sistema confirma la actualizacion del usuario")
    public void elSistemaConfirmaActualizacionDelUsuario() {
        theActorInTheSpotlight().should(
                seeThat("User updated", UserValidation.isUpdated(), is(true))
        );
    }

    @Entonces("el sistema muestra el usuario creado en la lista")
    public void elSistemaMuestraUsuarioCreadoEnLista() {
        String username = theActorInTheSpotlight().recall("testUsername");
        theActorInTheSpotlight().should(
                seeThat("User found in list", UserValidation.isInUserList(username), is(true))
        );
    }
}
