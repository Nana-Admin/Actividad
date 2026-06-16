package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.PERFORMANCE_REVIEWS)
public class PerformancePage extends PageObject {

    public static final Target PERFORMANCE_HEADER = Target.the("Performance header")
            .located(By.xpath("//h6[normalize-space()='Performance']"));

    public static final Target REVIEW_LIST_TABLE = Target.the("Review list table")
            .located(By.cssSelector("div.oxd-table-card"));

    public static final Target EMPLOYEE_NAME_INPUT = Target.the("Employee name search")
            .located(By.xpath("//label[text()='Employee Name']/../following-sibling::div//input"));

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target NO_RECORDS = Target.the("No records message")
            .located(By.xpath("//span[contains(text(),'No Records Found')]"));
}
