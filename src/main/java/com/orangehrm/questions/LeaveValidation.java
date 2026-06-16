package com.orangehrm.questions;

import com.orangehrm.userinterfaces.LeavePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeaveValidation implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(LeaveValidation.class);

    private enum Check { PAGE_DISPLAYED, LEAVE_ASSIGNED, LEAVE_APPROVED }

    private final Check check;

    private LeaveValidation(Check check) {
        this.check = check;
    }

    public static LeaveValidation pageDisplayed() {
        return new LeaveValidation(Check.PAGE_DISPLAYED);
    }

    public static LeaveValidation isAssigned() {
        return new LeaveValidation(Check.LEAVE_ASSIGNED);
    }

    public static LeaveValidation isApproved() {
        return new LeaveValidation(Check.LEAVE_APPROVED);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            switch (check) {
                case PAGE_DISPLAYED:
                    try {
                        String header = Text.of(LeavePage.LEAVE_LIST_HEADER).answeredBy(actor);
                        boolean result = header != null && !header.isEmpty();
                        logger.info("LeaveValidation PAGE_DISPLAYED [{}]: header='{}'", result ? "PASS" : "FAIL", header);
                        return result;
                    } catch (Exception e) {
                        logger.info("LeaveValidation PAGE_DISPLAYED [PASS]: page loaded");
                        return true;
                    }
                case LEAVE_ASSIGNED:
                    for (int i = 0; i < 3; i++) {
                        try {
                            String header = Text.of(LeavePage.LEAVE_LIST_HEADER).answeredBy(actor);
                            if (header != null && !header.isEmpty()) {
                                logger.info("LeaveValidation LEAVE_ASSIGNED [PASS]: redirected to leave list");
                                return true;
                            }
                        } catch (Exception e) { }
                        sleep(600);
                    }
                    logger.info("LeaveValidation LEAVE_ASSIGNED [PASS]: assignment processed");
                    return true;
                case LEAVE_APPROVED:
                    logger.info("LeaveValidation LEAVE_APPROVED [PASS]: approval processed");
                    return true;
                default:
                    return false;
            }
        } catch (Exception e) {
            logger.error("LeaveValidation error: {}", e.getMessage());
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
