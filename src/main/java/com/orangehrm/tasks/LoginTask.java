package com.orangehrm.tasks;

import com.orangehrm.abilities.Authenticate;
import com.orangehrm.models.LoginCredentials;
import com.orangehrm.userinterfaces.LoginPage;
import com.orangehrm.userinterfaces.Urls;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class LoginTask implements Task {

    private final String username;
    private final String password;

    private LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginTask withDefaultCredentials() {
        return new LoginTask(LoginCredentials.getUsername(), LoginCredentials.getPassword());
    }

    public static LoginTask withCredentials(String username, String password) {
        return new LoginTask(username, password);
    }

    public static LoginTask withActorAbility() {
        return new LoginTask(null, null);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(Urls.LOGIN));
        String user = username != null ? username : Authenticate.getUsername(actor);
        String pass = password != null ? password : Authenticate.getPassword(actor);
        actor.attemptsTo(
                Enter.theValue(user).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(pass).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
