package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.PIM_EMPLOYEE_LIST)
public class EmployeePage extends PageObject {

    public static final Target ADD_EMPLOYEE_BUTTON = Target.the("Add employee button")
            .located(By.xpath("//button[contains(@class,'oxd-button--secondary') and contains(.,'Add')]"));

    public static final Target FIRST_NAME_FIELD = Target.the("First name input")
            .located(By.name("firstName"));

    public static final Target MIDDLE_NAME_FIELD = Target.the("Middle name input")
            .located(By.name("middleName"));

    public static final Target LAST_NAME_FIELD = Target.the("Last name input")
            .located(By.name("lastName"));

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target SUCCESS_TOAST = Target.the("Success toast message")
            .located(By.xpath("//div[contains(@class,'oxd-toast--success')]//p[contains(@class,'oxd-text--toast-message')]"));

    public static final Target SEARCH_EMPLOYEE_NAME_FIELD = Target.the("Search employee name input")
            .located(By.xpath("//input[@placeholder='Type for hints...']"));

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.xpath("//div[contains(@class,'oxd-form-actions')]//button[@type='submit']"));

    public static final Target EMPLOYEE_TABLE_ROW = Target.the("Employee table first row")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')])[1]"));

    public static final Target ROW_CHECKBOX = Target.the("Row checkbox icon")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')]//i[contains(@class,'oxd-checkbox-input-icon')])[1]"));

    public static final Target DELETE_SELECTED_BUTTON = Target.the("Delete selected button")
            .located(By.xpath("//button[contains(@class,'oxd-button--label-danger')]"));

    public static final Target CONFIRM_DELETE_BUTTON = Target.the("Confirm delete button")
            .located(By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[contains(@class,'oxd-button--label-danger')]"));

    public static final Target EDIT_EMPLOYEE_BUTTON = Target.the("Edit employee button")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')]//i[contains(@class,'bi-pencil')])[1]"));

    public static final Target PIM_HEADER = Target.the("PIM header")
            .located(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]"));

    public static final Target ROW_TRASH_BUTTON = Target.the("Row trash button")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')]//i[contains(@class,'bi-trash')])[1]"));

    public static final Target NO_RECORDS_FOUND = Target.the("No records found message")
            .located(By.xpath("//span[contains(.,'No Records Found')]"));

    public static final Target EMPLOYEE_NAME_IN_TABLE = Target.the("Employee name cell in first row")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')]//div[contains(@class,'oxd-table-cell')])[3]/div"));
}
