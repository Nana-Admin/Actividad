package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.RECRUITMENT_CANDIDATES)
public class RecruitmentPage extends PageObject {

    public static final Target ADD_CANDIDATE_BUTTON = Target.the("Add candidate button")
            .located(By.xpath("//button[contains(@class,'oxd-button--secondary') and contains(.,'Add')]"));

    public static final Target FIRST_NAME_FIELD = Target.the("First name input")
            .located(By.name("firstName"));

    public static final Target MIDDLE_NAME_FIELD = Target.the("Middle name input")
            .located(By.name("middleName"));

    public static final Target LAST_NAME_FIELD = Target.the("Last name input")
            .located(By.name("lastName"));

    public static final Target EMAIL_FIELD = Target.the("Email input")
            .located(By.xpath("//label[text()='Email']/../following-sibling::div/input"));

    public static final Target CONTACT_NUMBER_FIELD = Target.the("Contact number input")
            .located(By.xpath("//label[text()='Contact Number']/../following-sibling::div/input"));

    public static final Target SAVE_CANDIDATE_BUTTON = Target.the("Save button")
            .located(By.xpath("//div[contains(@class,'orangehrm-card-container')]//button[@type='submit']"));

    public static final Target CANDIDATE_TABLE_ROW = Target.the("Candidate table row")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')])[1]"));

    public static final Target SEARCH_CANDIDATE_NAME = Target.the("Search candidate name")
            .located(By.xpath("//input[@placeholder='Type for hints...']"));

    public static final Target SEARCH_CANDIDATE_BUTTON = Target.the("Search candidate button")
            .located(By.xpath("//div[contains(@class,'oxd-form-actions')]//button[@type='submit']"));

    public static final Target SUCCESS_TOAST = Target.the("Success toast")
            .located(By.xpath("//div[contains(@class,'oxd-toast--success')]//p"));
}
