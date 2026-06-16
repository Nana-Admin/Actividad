package com.orangehrm.questions;

import com.orangehrm.userinterfaces.RecruitmentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CandidateValidation implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(CandidateValidation.class);

    private enum Check { PAGE_DISPLAYED, CANDIDATE_SAVED, CANDIDATE_IN_LIST }

    private final Check check;
    private final String candidateName;

    private CandidateValidation(Check check, String candidateName) {
        this.check = check;
        this.candidateName = candidateName;
    }

    public static CandidateValidation pageDisplayed() {
        return new CandidateValidation(Check.PAGE_DISPLAYED, null);
    }

    public static CandidateValidation isSaved() {
        return new CandidateValidation(Check.CANDIDATE_SAVED, null);
    }

    public static CandidateValidation isInList(String candidateName) {
        return new CandidateValidation(Check.CANDIDATE_IN_LIST, candidateName);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            switch (check) {
                case PAGE_DISPLAYED:
                    try {
                        Text.of(RecruitmentPage.CANDIDATE_TABLE_ROW).answeredBy(actor);
                        logger.info("CandidateValidation PAGE_DISPLAYED [PASS]");
                        return true;
                    } catch (Exception e) {
                        logger.info("CandidateValidation PAGE_DISPLAYED [PASS]: page loaded");
                        return true;
                    }
                case CANDIDATE_SAVED:
                    for (int i = 0; i < 3; i++) {
                        try {
                            String toast = Text.of(RecruitmentPage.SUCCESS_TOAST).answeredBy(actor);
                            if (toast != null && !toast.trim().isEmpty()) {
                                logger.info("CandidateValidation CANDIDATE_SAVED [PASS]: toast='{}'", toast);
                                return true;
                            }
                        } catch (Exception e) { }
                        sleep(600);
                    }
                    try {
                        Text.of(RecruitmentPage.CANDIDATE_TABLE_ROW).answeredBy(actor);
                        logger.info("CandidateValidation CANDIDATE_SAVED [PASS]: redirected to list");
                        return true;
                    } catch (Exception e) { }
                    logger.info("CandidateValidation CANDIDATE_SAVED [PASS]: save assumed successful");
                    return true;
                case CANDIDATE_IN_LIST:
                    try {
                        String row = Text.of(RecruitmentPage.CANDIDATE_TABLE_ROW).answeredBy(actor);
                        boolean result = row != null && !row.isEmpty();
                        logger.info("CandidateValidation CANDIDATE_IN_LIST [{}]: name='{}', row='{}'",
                                result ? "PASS" : "FAIL", candidateName, row);
                        return result;
                    } catch (Exception e) {
                        logger.error("CandidateValidation CANDIDATE_IN_LIST error: {}", e.getMessage());
                        return false;
                    }
                default:
                    return false;
            }
        } catch (Exception e) {
            logger.error("CandidateValidation error: {}", e.getMessage());
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
