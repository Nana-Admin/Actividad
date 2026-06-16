package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.MY_PROFILE)
public class MyProfilePage extends PageObject {

    public static final Target PROFILE_HEADER = Target.the("My info header")
            .located(By.xpath("//h6[normalize-space()='PIM']"));

    public static final Target FIRST_NAME_FIELD = Target.the("First name input")
            .located(By.name("firstName"));

    public static final Target MIDDLE_NAME_FIELD = Target.the("Middle name input")
            .located(By.name("middleName"));

    public static final Target LAST_NAME_FIELD = Target.the("Last name input")
            .located(By.name("lastName"));

    public static final Target EMPLOYEE_ID_FIELD = Target.the("Employee ID input")
            .located(By.xpath("//label[text()='Employee Id']/../following-sibling::div/input"));

    public static final Target SAVE_PROFILE_BUTTON = Target.the("Save button")
            .located(By.xpath("(//button[@type='submit'])[1]"));

    public static final Target PROFILE_PHOTO_IMG = Target.the("Profile photo")
            .located(By.cssSelector("img.employee-image"));

    public static final Target PROFILE_PHOTO_INPUT = Target.the("Photo upload input")
            .located(By.cssSelector("input[type='file']"));

    public static final Target SUCCESS_TOAST = Target.the("Success toast")
            .located(By.xpath("//div[contains(@class,'oxd-toast--success')]//p"));
}
