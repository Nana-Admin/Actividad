package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.Urls;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenPage implements Task {

    private final String url;

    private OpenPage(String url) {
        this.url = url;
    }

    public static OpenPage at(String url) {
        return new OpenPage(url);
    }

    public static OpenPage loginPage() {
        return new OpenPage(Urls.LOGIN);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
