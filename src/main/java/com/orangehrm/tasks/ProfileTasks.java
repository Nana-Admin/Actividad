package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.DashboardPage;
import com.orangehrm.userinterfaces.MyProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ProfileTasks {

    public static Task navigateToMyProfile() {
        return Task.where("{0} navigates to my profile",
                Click.on(DashboardPage.MENU_MY_INFO)
        );
    }

    public static Task updatePersonalInfo(String newFirstName, String newLastName) {
        return Task.where("{0} updates personal info",
                Enter.theValue(newFirstName).into(MyProfilePage.FIRST_NAME_FIELD),
                Enter.theValue(newLastName).into(MyProfilePage.LAST_NAME_FIELD)
        );
    }

    public static Task saveProfile() {
        return Task.where("{0} saves profile changes",
                Click.on(MyProfilePage.SAVE_PROFILE_BUTTON)
        );
    }
}
