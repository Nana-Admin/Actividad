package com.orangehrm.stepsdefinitions;

import com.orangehrm.abilities.Authenticate;
import com.orangehrm.models.LoginCredentials;
import com.orangehrm.tasks.LoginTask;
import com.orangehrm.tasks.OpenPage;
import com.orangehrm.userinterfaces.Urls;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario abre la pagina de login")
    public void queElUsuarioAbreLaPaginaDeLogin() {
        Actor actor = theActorCalled("Usuario");
        actor.wasAbleTo(OpenPage.loginPage());
    }

    @Dado("que el usuario esta autenticado en el sistema")
    public void queElUsuarioEstaAutenticadoEnElSistema() {
        Actor actor = theActorCalled("Usuario");
        actor.can(Authenticate.withDefaultCredentials());
        actor.wasAbleTo(LoginTask.withDefaultCredentials());
    }
}
