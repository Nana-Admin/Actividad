package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.DashboardPage;
import com.orangehrm.userinterfaces.EmployeePage;
import com.orangehrm.userinterfaces.Urls;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class EmployeeTasks {

    public static Task navigateToEmployeeList() {
        return Task.where("{0} navigates to PIM employee list",
                Open.url(Urls.PIM_EMPLOYEE_LIST)
        );
    }

    public static Task navigateToAddEmployee() {
        return Task.where("{0} navigates to add employee",
                Click.on(DashboardPage.MENU_PIM),
                WaitUntil.the(EmployeePage.ADD_EMPLOYEE_BUTTON, isClickable()),
                Click.on(EmployeePage.ADD_EMPLOYEE_BUTTON)
        );
    }

    public static Task fillEmployeeDetails(String firstName, String lastName) {
        return Task.where("{0} fills employee details: " + firstName + " " + lastName,
                Enter.theValue(firstName).into(EmployeePage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(EmployeePage.LAST_NAME_FIELD)
        );
    }

    public static Task fillEmployeeDetails(String firstName, String middleName, String lastName) {
        return Task.where("{0} fills employee details",
                Enter.theValue(firstName).into(EmployeePage.FIRST_NAME_FIELD),
                Enter.theValue(middleName).into(EmployeePage.MIDDLE_NAME_FIELD),
                Enter.theValue(lastName).into(EmployeePage.LAST_NAME_FIELD)
        );
    }

    public static Task saveEmployee() {
        return Task.where("{0} saves the employee",
                WaitUntil.the(EmployeePage.SAVE_BUTTON, isClickable()),
                Click.on(EmployeePage.SAVE_BUTTON)
        );
    }

    public static Task searchEmployeeByName(String name) {
        return Task.where("{0} searches employee by name: " + name,
                Enter.theValue(name).into(EmployeePage.SEARCH_EMPLOYEE_NAME_FIELD),
                Click.on(EmployeePage.SEARCH_BUTTON)
        );
    }

    public static Task clickEditEmployee() {
        return Task.where("{0} clicks edit employee",
                WaitUntil.the(EmployeePage.EDIT_EMPLOYEE_BUTTON, isClickable()),
                Click.on(EmployeePage.EDIT_EMPLOYEE_BUTTON)
        );
    }

    public static Task updateEmployeeFirstName(String newFirstName) {
        return Task.where("{0} updates employee first name",
                Enter.theValue(newFirstName).into(EmployeePage.FIRST_NAME_FIELD)
        );
    }

    public static Task clickDeleteCheckbox() {
        return Task.where("{0} clicks delete checkbox",
                WaitUntil.the(EmployeePage.ROW_CHECKBOX, isClickable()),
                Click.on(EmployeePage.ROW_CHECKBOX)
        );
    }

    public static Task clickDeleteSelected() {
        return Task.where("{0} clicks delete selected",
                WaitUntil.the(EmployeePage.DELETE_SELECTED_BUTTON, isClickable()),
                Click.on(EmployeePage.DELETE_SELECTED_BUTTON)
        );
    }

    public static Task confirmDelete() {
        return Task.where("{0} confirms delete",
                WaitUntil.the(EmployeePage.CONFIRM_DELETE_BUTTON, isClickable()),
                Click.on(EmployeePage.CONFIRM_DELETE_BUTTON)
        );
    }

    public static Task clickRowTrashButton() {
        return Task.where("{0} clicks row trash button",
                WaitUntil.the(EmployeePage.ROW_TRASH_BUTTON, isClickable()),
                Click.on(EmployeePage.ROW_TRASH_BUTTON)
        );
    }
}
