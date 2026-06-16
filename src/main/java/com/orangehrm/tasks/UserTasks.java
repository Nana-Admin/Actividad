package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.UserManagementPage;
import com.orangehrm.userinterfaces.Urls;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class UserTasks {

    public static Task navigateToUserManagement() {
        return Task.where("{0} navigates to user management",
                Open.url(Urls.ADMIN_USER_MANAGEMENT)
        );
    }

    public static Task clickAddUser() {
        return Task.where("{0} clicks add user",
                Click.on(UserManagementPage.ADD_USER_BUTTON)
        );
    }

    public static Task fillUserForm(String username, String password) {
        return Task.where("{0} fills user form",
                Click.on(UserManagementPage.USER_ROLE_DROPDOWN),
                WaitUntil.the(UserManagementPage.USER_ROLE_OPTION, isClickable()),
                Click.on(UserManagementPage.USER_ROLE_OPTION),
                Enter.theValue(username).into(UserManagementPage.USERNAME_FIELD),
                Enter.theValue(password).into(UserManagementPage.PASSWORD_FIELD),
                Enter.theValue(password).into(UserManagementPage.CONFIRM_PASSWORD_FIELD)
        );
    }

    public static Task saveUser() {
        return Task.where("{0} saves the user",
                Click.on(UserManagementPage.SAVE_USER_BUTTON)
        );
    }

    public static Task searchUserByUsername(String username) {
        return Task.where("{0} searches user by username: " + username,
                Enter.theValue(username).into(UserManagementPage.SEARCH_USERNAME_FIELD),
                Click.on(UserManagementPage.SEARCH_USER_BUTTON)
        );
    }

    public static Task deleteUser() {
        return Task.where("{0} deletes the user",
                WaitUntil.the(UserManagementPage.DELETE_USER_BUTTON, isClickable()),
                Click.on(UserManagementPage.DELETE_USER_BUTTON),
                WaitUntil.the(UserManagementPage.CONFIRM_DELETE_USER, isClickable()),
                Click.on(UserManagementPage.CONFIRM_DELETE_USER)
        );
    }

    public static Task clickEditUser() {
        return Task.where("{0} clicks edit user",
                WaitUntil.the(UserManagementPage.EDIT_USER_BUTTON, isClickable()),
                Click.on(UserManagementPage.EDIT_USER_BUTTON)
        );
    }
}
