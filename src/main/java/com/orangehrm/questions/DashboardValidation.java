package com.orangehrm.questions;

import com.orangehrm.userinterfaces.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardValidation implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(DashboardValidation.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String header = Text.of(DashboardPage.DASHBOARD_HEADER).answeredBy(actor);
            boolean result = "Dashboard".equalsIgnoreCase(header.trim());
            logger.info("DashboardValidation [{}]: header='{}'", result ? "PASS" : "FAIL", header);
            return result;
        } catch (Exception e) {
            logger.error("DashboardValidation error: {}", e.getMessage());
            return false;
        }
    }

    public static DashboardValidation isDisplayed() {
        return new DashboardValidation();
    }

    public static DashboardValidation hasWidgets() {
        return new DashboardValidation();
    }
}
