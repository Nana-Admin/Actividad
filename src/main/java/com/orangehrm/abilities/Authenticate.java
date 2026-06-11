package com.orangehrm.abilities;

import com.orangehrm.models.LoginCredentials;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

public class Authenticate implements Ability {

    private final String username;
    private final String password;

    private Authenticate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Authenticate withDefaultCredentials() {
        return new Authenticate(LoginCredentials.getUsername(), LoginCredentials.getPassword());
    }

    public static Authenticate with(String username, String password) {
        return new Authenticate(username, password);
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public static String getUsername(Actor actor) {
        return actor.abilityTo(Authenticate.class).username();
    }

    public static String getPassword(Actor actor) {
        return actor.abilityTo(Authenticate.class).password();
    }
}
