package com.orangehrm.questions;

import com.orangehrm.userinterfaces.PerformancePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceValidation implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceValidation.class);

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String header = Text.of(PerformancePage.PERFORMANCE_HEADER).answeredBy(actor);
            boolean result = "Performance".equalsIgnoreCase(header.trim());
            logger.info("PerformanceValidation [{}]: header='{}'", result ? "PASS" : "FAIL", header);
            return result;
        } catch (Exception e) {
            logger.error("PerformanceValidation error: {}", e.getMessage());
            return false;
        }
    }

    public static PerformanceValidation pageIsDisplayed() {
        return new PerformanceValidation();
    }
}
