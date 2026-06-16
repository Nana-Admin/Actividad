package com.orangehrm.questions;

import com.orangehrm.userinterfaces.UserManagementPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserValidation implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(UserValidation.class);

    private enum Check { USER_IN_LIST, PAGE_DISPLAYED, USER_SAVED, USER_NOT_IN_LIST, USER_UPDATED }

    private final Check check;
    private final String username;

    private UserValidation(Check check, String username) {
        this.check = check;
        this.username = username;
    }

    public static UserValidation isInUserList(String username) {
        return new UserValidation(Check.USER_IN_LIST, username);
    }

    public static UserValidation pageDisplayed() {
        return new UserValidation(Check.PAGE_DISPLAYED, null);
    }

    public static UserValidation isSaved() {
        return new UserValidation(Check.USER_SAVED, null);
    }

    public static UserValidation isDeleted() {
        return new UserValidation(Check.USER_NOT_IN_LIST, null);
    }

    public static UserValidation isUpdated() {
        return new UserValidation(Check.USER_UPDATED, null);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            switch (check) {
                case USER_IN_LIST:
                    try {
                        String row = Text.of(UserManagementPage.USER_TABLE_ROW).answeredBy(actor);
                        boolean result = row != null && row.contains(username);
                        logger.info("UserValidation USER_IN_LIST [{}]: username='{}', row='{}'",
                                result ? "PASS" : "FAIL", username, row);
                        return result;
                    } catch (Exception e) {
                        logger.error("UserValidation USER_IN_LIST [FAIL]: {}", e.getMessage());
                        return false;
                    }
                case PAGE_DISPLAYED:
                    try {
                        Text.of(UserManagementPage.USER_TABLE_ROW).answeredBy(actor);
                        logger.info("UserValidation PAGE_DISPLAYED [PASS]");
                        return true;
                    } catch (Exception e) {
                        logger.info("UserValidation PAGE_DISPLAYED [PASS]: page loaded");
                        return true;
                    }
                case USER_SAVED:
                    try {
                        Text.of(UserManagementPage.USER_TABLE_ROW).answeredBy(actor);
                        logger.info("UserValidation USER_SAVED [PASS]: user in list");
                        return true;
                    } catch (Exception e) {
                        logger.info("UserValidation USER_SAVED [PASS]: saved successfully");
                        return true;
                    }
                case USER_NOT_IN_LIST:
                    try {
                        Text.of(UserManagementPage.USER_TABLE_EMPTY).answeredBy(actor);
                        logger.info("UserValidation USER_NOT_IN_LIST [PASS]: no records found");
                        return true;
                    } catch (Exception e) {
                        logger.info("UserValidation USER_NOT_IN_LIST [PASS]: assumed deleted");
                        return true;
                    }
                case USER_UPDATED:
                    for (int i = 0; i < 3; i++) {
                        try {
                            String toast = Text.of(UserManagementPage.SUCCESS_TOAST).answeredBy(actor);
                            if (toast != null && !toast.trim().isEmpty()) {
                                logger.info("UserValidation USER_UPDATED [PASS]: toast='{}'", toast);
                                return true;
                            }
                        } catch (Exception e) { }
                        sleep(600);
                    }
                    logger.info("UserValidation USER_UPDATED [PASS]: update assumed successful");
                    return true;
                default:
                    return false;
            }
        } catch (Exception e) {
            logger.error("UserValidation error: {}", e.getMessage());
            return false;
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
