package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.ADMIN_USER_MANAGEMENT)
public class UserManagementPage extends PageObject {

    public static final Target ADD_USER_BUTTON = Target.the("Add user button")
            .located(By.xpath("//button[contains(@class,'oxd-button--secondary') and contains(.,'Add')]"));

    public static final Target USER_ROLE_DROPDOWN = Target.the("User role dropdown")
            .located(By.xpath("//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]"));

    public static final Target USER_ROLE_OPTION = Target.the("User role option Admin")
            .located(By.xpath("//div[@role='listbox']//span[contains(.,'Admin')]"));

    public static final Target USERNAME_FIELD = Target.the("Username input")
            .located(By.xpath("//label[text()='Username']/../following-sibling::div/input"));

    public static final Target PASSWORD_FIELD = Target.the("Password input - user form")
            .located(By.xpath("//label[text()='Password']/../following-sibling::div/input"));

    public static final Target CONFIRM_PASSWORD_FIELD = Target.the("Confirm password input")
            .located(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input"));

    public static final Target SAVE_USER_BUTTON = Target.the("Save user button")
            .located(By.xpath("//div[contains(@class,'orangehrm-card-container')]//button[@type='submit']"));

    public static final Target SEARCH_USERNAME_FIELD = Target.the("Search username input")
            .located(By.xpath("//label[text()='Username']/../following-sibling::div/input"));

    public static final Target SEARCH_USER_BUTTON = Target.the("Search user button")
            .located(By.xpath("//div[contains(@class,'oxd-form-actions')]//button[@type='submit']"));

    public static final Target USER_TABLE_ROW = Target.the("User table row")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')])[1]"));

    public static final Target DELETE_USER_BUTTON = Target.the("Delete user button")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')]//i[contains(@class,'bi-trash')])[1]"));

    public static final Target CONFIRM_DELETE_USER = Target.the("Confirm delete user")
            .located(By.xpath("//div[contains(@class,'orangehrm-modal-footer')]//button[contains(@class,'oxd-button--label-danger')]"));

    public static final Target USER_TABLE_EMPTY = Target.the("No records message")
            .located(By.xpath("//span[contains(.,'No Records Found')]"));

    public static final Target EDIT_USER_BUTTON = Target.the("Edit user button")
            .located(By.xpath("(//div[contains(@class,'oxd-table-card')]//i[contains(@class,'bi-pencil')])[1]"));

    public static final Target SUCCESS_TOAST = Target.the("Success toast")
            .located(By.xpath("//div[contains(@class,'oxd-toast--success')]//p"));
}
