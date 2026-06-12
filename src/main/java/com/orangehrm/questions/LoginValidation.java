package com.orangehrm.questions;

import com.orangehrm.userinterfaces.LoginPage;
import com.orangehrm.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginValidation implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(LoginValidation.class);

    private final String expectedText;
    private final Target primaryTarget;

    private LoginValidation(String expectedText, Target primaryTarget) {
        this.expectedText = expectedText;
        this.primaryTarget = primaryTarget;
    }

    public static LoginValidation isSuccessful() {
        return new LoginValidation(Constants.DASHBOARD_HEADER_TEXT, LoginPage.DASHBOARD_HEADER);
    }

    public static LoginValidation showsError(String expectedError) {
        return new LoginValidation(expectedError, LoginPage.ERROR_MESSAGE);
    }

    public static LoginValidation showsRequiredField() {
        return new LoginValidation(Constants.REQUIRED_FIELD_MSG, LoginPage.REQUIRED_FIELD_ERROR);
    }

    public static LoginValidation redirectsToLogin() {
        return new LoginValidation("Login", LoginPage.LOGIN_TITLE);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String text = safeTextOf(actor, primaryTarget);
            if (text.isEmpty()) {
                text = fallbackText(actor);
            }
            boolean result = !text.isEmpty() && (text.contains(expectedText) || text.equalsIgnoreCase(expectedText));
            logger.info("LoginValidation [{}]: expected='{}', actual='{}', result={}",
                    result ? "PASS" : "FAIL", expectedText, text, result);
            return result;
        } catch (Exception e) {
            logger.error("LoginValidation error: {}", e.getMessage());
            return false;
        }
    }

    private String safeTextOf(Actor actor, Target target) {
        try {
            return WebElementQuestion.the(target).answeredBy(actor).getText().trim();
        } catch (Exception e) {
            try {
                return Text.of(target).answeredBy(actor).trim();
            } catch (Exception ex) {
                return "";
            }
        }
    }

    private String fallbackText(Actor actor) {
        Target[] fallbacks;
        if (primaryTarget == LoginPage.ERROR_MESSAGE) {
            fallbacks = new Target[]{LoginPage.DASHBOARD_HEADER, LoginPage.LOGIN_TITLE};
        } else if (primaryTarget == LoginPage.DASHBOARD_HEADER) {
            fallbacks = new Target[]{LoginPage.ERROR_MESSAGE, LoginPage.LOGIN_TITLE};
        } else {
            fallbacks = new Target[]{LoginPage.DASHBOARD_HEADER, LoginPage.ERROR_MESSAGE};
        }
        for (Target t : fallbacks) {
            String text = safeTextOf(actor, t);
            if (!text.isEmpty()) return text;
        }
        return "";
    }
}
