package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.DashboardPage;
import com.orangehrm.userinterfaces.PerformancePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class PerformanceTasks {

    public static Task navigateToPerformance() {
        return Task.where("{0} navigates to performance",
                Click.on(DashboardPage.MENU_PERFORMANCE)
        );
    }

    public static Task searchEmployeePerformance(String employeeName) {
        return Task.where("{0} searches performance by employee",
                Enter.theValue(employeeName).into(PerformancePage.EMPLOYEE_NAME_INPUT),
                Click.on(PerformancePage.SEARCH_BUTTON)
        );
    }
}
