package com.orangehrm.tasks;

import com.orangehrm.userinterfaces.DashboardPage;
import com.orangehrm.userinterfaces.RecruitmentPage;
import com.orangehrm.userinterfaces.Urls;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class CandidateTasks {

    public static Task navigateToRecruitment() {
        return Task.where("{0} navigates to recruitment",
                Click.on(DashboardPage.MENU_RECRUITMENT)
        );
    }

    public static Task clickAddCandidate() {
        return Task.where("{0} clicks add candidate",
                Click.on(RecruitmentPage.ADD_CANDIDATE_BUTTON)
        );
    }

    public static Task fillCandidateDetails(String firstName, String lastName, String email) {
        return Task.where("{0} fills candidate details",
                Enter.theValue(firstName).into(RecruitmentPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(RecruitmentPage.LAST_NAME_FIELD),
                Enter.theValue(email).into(RecruitmentPage.EMAIL_FIELD)
        );
    }

    public static Task saveCandidate() {
        return Task.where("{0} saves the candidate",
                Click.on(RecruitmentPage.SAVE_CANDIDATE_BUTTON)
        );
    }

    public static Task searchCandidateByName(String name) {
        return Task.where("{0} searches candidate by name",
                Enter.theValue(name).into(RecruitmentPage.SEARCH_CANDIDATE_NAME),
                Click.on(RecruitmentPage.SEARCH_CANDIDATE_BUTTON)
        );
    }
}
