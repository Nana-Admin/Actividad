package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.DIRECTORY)
public class DirectoryPage extends PageObject {

    public static final Target DIRECTORY_HEADER = Target.the("Directory header")
            .located(By.xpath("//h6[normalize-space()='Directory']"));

    public static final Target SEARCH_NAME_INPUT = Target.the("Search name input")
            .located(By.xpath("//input[@placeholder='Type for hints...']"));

    public static final Target SEARCH_JOB_TITLE_DROPDOWN = Target.the("Job title dropdown")
            .located(By.xpath("//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text')]"));

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target RESULT_CARD = Target.the("Directory result card")
            .located(By.cssSelector("div.orangehrm-directory-card"));

    public static final Target NO_RECORDS = Target.the("No records message")
            .located(By.xpath("//span[contains(text(),'No Records Found')]"));
}
