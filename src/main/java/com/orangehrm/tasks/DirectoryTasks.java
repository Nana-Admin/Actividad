package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.DashboardPage;
import com.orangehrm.userinterfaces.DirectoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class DirectoryTasks {

    public static Task navigateToDirectory() {
        return Task.where("{0} navigates to directory",
                Click.on(DashboardPage.MENU_DIRECTORY)
        );
    }

    public static Task searchByName(String name) {
        return Task.where("{0} searches directory by name",
                Enter.theValue(name).into(DirectoryPage.SEARCH_NAME_INPUT),
                Click.on(DirectoryPage.SEARCH_BUTTON)
        );
    }
}
