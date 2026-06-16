package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.Urls;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class DashboardTasks {

    public static Task navigateToDashboard() {
        return Task.where("{0} navigates to dashboard",
                Open.url(Urls.DASHBOARD)
        );
    }
}
