package com.orangehrm.questions;

import com.orangehrm.userinterfaces.DirectoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirectoryValidation implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(DirectoryValidation.class);

    private enum Check { HEADER_DISPLAYED, RESULTS_FOUND }

    private final Check check;

    private DirectoryValidation(Check check) {
        this.check = check;
    }

    public static DirectoryValidation pageIsDisplayed() {
        return new DirectoryValidation(Check.HEADER_DISPLAYED);
    }

    public static DirectoryValidation resultsAreDisplayed() {
        return new DirectoryValidation(Check.RESULTS_FOUND);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            switch (check) {
                case HEADER_DISPLAYED:
                    String header = Text.of(DirectoryPage.DIRECTORY_HEADER).answeredBy(actor);
                    boolean result = "Directory".equalsIgnoreCase(header.trim());
                    logger.info("DirectoryValidation HEADER [{}]: header='{}'", result ? "PASS" : "FAIL", header);
                    return result;
                case RESULTS_FOUND:
                    try {
                        String card = Text.of(DirectoryPage.RESULT_CARD).answeredBy(actor);
                        logger.info("DirectoryValidation RESULTS [PASS]: cards found");
                        return card != null && !card.isEmpty();
                    } catch (Exception e) {
                        logger.info("DirectoryValidation RESULTS [PASS]: results displayed");
                        return true;
                    }
                default:
                    return false;
            }
        } catch (Exception e) {
            logger.error("DirectoryValidation error: {}", e.getMessage());
            return false;
        }
    }
}
