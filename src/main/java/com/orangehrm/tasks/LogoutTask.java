package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class LogoutTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginPage.USER_DROPDOWN),
                Click.on(LoginPage.LOGOUT_LINK)
        );
    }

    public static LogoutTask now() {
        return new LogoutTask();
    }
}
