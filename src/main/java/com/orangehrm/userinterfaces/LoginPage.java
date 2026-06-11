package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.LOGIN)
public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD = Target.the("Username input")
            .located(By.name("username"));

    public static final Target PASSWORD_FIELD = Target.the("Password input")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target ERROR_MESSAGE = Target.the("Error alert message")
            .located(By.xpath("//p[contains(@class,'oxd-alert-content-text')]"));

    public static final Target DASHBOARD_HEADER = Target.the("Dashboard header")
            .located(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]"));

    public static final Target USER_DROPDOWN = Target.the("User dropdown menu")
            .located(By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]"));

    public static final Target LOGOUT_LINK = Target.the("Logout option")
            .located(By.xpath("//a[contains(@class,'oxd-userdropdown-link') and contains(text(),'Logout')]"));

    public static final Target REQUIRED_FIELD_ERROR = Target.the("Required field error span")
            .located(By.xpath("//span[contains(@class,'oxd-input-field-error-message')]"));

    public static final Target LOGIN_TITLE = Target.the("Login page title")
            .located(By.xpath("//h5[contains(@class,'orangehrm-login-title')]"));
}
