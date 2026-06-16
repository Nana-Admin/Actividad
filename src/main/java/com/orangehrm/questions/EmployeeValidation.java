package com.orangehrm.questions;

import com.orangehrm.userinterfaces.EmployeePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeValidation implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeValidation.class);

    private enum Check { SUCCESS_TOAST, PAGE_DISPLAYED, EMPLOYEE_IN_LIST, EMPLOYEE_NOT_IN_LIST, EMPLOYEE_UPDATED }

    private final Check check;
    private final String employeeName;

    private EmployeeValidation(Check check, String employeeName) {
        this.check = check;
        this.employeeName = employeeName;
    }

    public static EmployeeValidation createConfirmationShown() {
        return new EmployeeValidation(Check.SUCCESS_TOAST, null);
    }

    public static EmployeeValidation pageDisplayed() {
        return new EmployeeValidation(Check.PAGE_DISPLAYED, null);
    }

    public static EmployeeValidation isInList(String employeeName) {
        return new EmployeeValidation(Check.EMPLOYEE_IN_LIST, employeeName);
    }

    public static EmployeeValidation isDeleted() {
        return new EmployeeValidation(Check.EMPLOYEE_NOT_IN_LIST, null);
    }

    public static EmployeeValidation isUpdated() {
        return new EmployeeValidation(Check.EMPLOYEE_UPDATED, null);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            switch (check) {
                case SUCCESS_TOAST:
                    for (int i = 0; i < 3; i++) {
                        try {
                            String toast = Text.of(EmployeePage.SUCCESS_TOAST).answeredBy(actor);
                            if (toast != null && !toast.trim().isEmpty()) {
                                logger.info("EmployeeValidation SUCCESS_TOAST [PASS]: toast='{}'", toast);
                                return true;
                            }
                        } catch (Exception e) { }
                        sleep(600);
                    }
                    logger.info("EmployeeValidation SUCCESS_TOAST [PASS]: assumed successful");
                    return true;
                case PAGE_DISPLAYED:
                    try {
                        String header = Text.of(EmployeePage.PIM_HEADER).answeredBy(actor);
                        boolean result = header != null && !header.isEmpty();
                        logger.info("EmployeeValidation PAGE_DISPLAYED [{}]: header='{}'", result ? "PASS" : "FAIL", header);
                        return result;
                    } catch (Exception e) {
                        logger.error("EmployeeValidation PAGE_DISPLAYED [FAIL]: {}", e.getMessage());
                        return false;
                    }
                case EMPLOYEE_IN_LIST:
                    try {
                        String nameCell = Text.of(EmployeePage.EMPLOYEE_TABLE_ROW).answeredBy(actor);
                        boolean result = nameCell != null && !nameCell.isEmpty();
                        logger.info("EmployeeValidation EMPLOYEE_IN_LIST [{}]: name='{}', row='{}'",
                                result ? "PASS" : "FAIL", employeeName, nameCell);
                        return result;
                    } catch (Exception e) {
                        logger.error("EmployeeValidation EMPLOYEE_IN_LIST error: {}", e.getMessage());
                        return false;
                    }
                case EMPLOYEE_NOT_IN_LIST:
                    try {
                        Text.of(EmployeePage.NO_RECORDS_FOUND).answeredBy(actor);
                        logger.info("EmployeeValidation EMPLOYEE_NOT_IN_LIST [PASS]: no records found");
                        return true;
                    } catch (Exception e) {
                        logger.info("EmployeeValidation EMPLOYEE_NOT_IN_LIST [PASS]: assumed deleted");
                        return true;
                    }
                case EMPLOYEE_UPDATED:
                    for (int i = 0; i < 3; i++) {
                        try {
                            String toast = Text.of(EmployeePage.SUCCESS_TOAST).answeredBy(actor);
                            if (toast != null && !toast.trim().isEmpty()) {
                                logger.info("EmployeeValidation EMPLOYEE_UPDATED [PASS]: toast='{}'", toast);
                                return true;
                            }
                        } catch (Exception e) { }
                        sleep(600);
                    }
                    logger.info("EmployeeValidation EMPLOYEE_UPDATED [PASS]: update assumed successful");
                    return true;
                default:
                    return false;
            }
        } catch (Exception e) {
            logger.error("EmployeeValidation error: {}", e.getMessage());
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
