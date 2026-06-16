package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.LEAVE_LIST)
public class LeavePage extends PageObject {

    public static final Target ASSIGN_LEAVE_LINK = Target.the("Assign leave tab")
            .located(By.xpath("//a[contains(@class,'oxd-topbar-body-nav-tab-item') and contains(.,'Assign')]"));

    public static final Target EMPLOYEE_NAME_INPUT = Target.the("Employee name input")
            .located(By.xpath("//input[@placeholder='Type for hints...']"));

    public static final Target LEAVE_TYPE_DROPDOWN = Target.the("Leave type dropdown")
            .located(By.xpath("//label[text()='Leave Type']/../following-sibling::div//div[contains(@class,'oxd-select-text')]"));

    public static final Target LEAVE_TYPE_OPTION = Target.the("Leave type option CAN")
            .located(By.xpath("//div[@role='listbox']//span[contains(.,'CAN')]"));

    public static final Target FROM_DATE_FIELD = Target.the("From date input")
            .located(By.xpath("//label[text()='From Date']/../following-sibling::div//input"));

    public static final Target TO_DATE_FIELD = Target.the("To date input")
            .located(By.xpath("//label[text()='To Date']/../following-sibling::div//input"));

    public static final Target ASSIGN_BUTTON = Target.the("Assign button")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target LEAVE_LIST_HEADER = Target.the("Leave list header")
            .located(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]"));

    public static final Target FIRST_APPROVE_BUTTON = Target.the("First approve button")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')]//button[contains(.,'Approve')])[1]"));
}
