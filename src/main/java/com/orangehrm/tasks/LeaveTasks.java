package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.DashboardPage;
import com.orangehrm.userinterfaces.LeavePage;
import com.orangehrm.userinterfaces.Urls;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LeaveTasks {

    public static Task navigateToLeave() {
        return Task.where("{0} navigates to leave",
                Click.on(DashboardPage.MENU_LEAVE)
        );
    }

    public static Task navigateToAssignLeave() {
        return Task.where("{0} navigates to assign leave",
                Open.url(Urls.ASSIGN_LEAVE)
        );
    }

    public static Task fillAssignLeave(String employeeName, String fromDate, String toDate) {
        return Task.where("{0} fills assign leave form",
                Enter.theValue(employeeName).into(LeavePage.EMPLOYEE_NAME_INPUT),
                Enter.theValue(fromDate).into(LeavePage.FROM_DATE_FIELD),
                Enter.theValue(toDate).into(LeavePage.TO_DATE_FIELD)
        );
    }

    public static Task assignLeave() {
        return Task.where("{0} clicks assign leave",
                WaitUntil.the(LeavePage.ASSIGN_BUTTON, isClickable()),
                Click.on(LeavePage.ASSIGN_BUTTON)
        );
    }

    public static Task approveFirstLeave() {
        return Task.where("{0} approves first leave request",
                WaitUntil.the(LeavePage.FIRST_APPROVE_BUTTON, isClickable()),
                Click.on(LeavePage.FIRST_APPROVE_BUTTON)
        );
    }
}
