package com.orangehrm.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl(Urls.DASHBOARD)
public class DashboardPage extends PageObject {

    public static final Target DASHBOARD_HEADER = Target.the("Dashboard title")
            .located(By.xpath("//h6[normalize-space()='Dashboard']"));

    public static final Target SIDEBAR_MENU = Target.the("Sidebar menu")
            .located(By.cssSelector("ul.oxd-main-menu"));

    public static final Target MENU_PIM = Target.the("PIM menu option")
            .located(By.xpath("//a[@class='oxd-main-menu-item' and contains(@href,'pim')]"));

    public static final Target MENU_ADMIN = Target.the("Admin menu option")
            .located(By.xpath("//a[contains(@class,'oxd-main-menu-item') and contains(@href,'admin')]"));

    public static final Target MENU_LEAVE = Target.the("Leave menu option")
            .located(By.xpath("//a[@class='oxd-main-menu-item' and contains(@href,'leave')]"));

    public static final Target MENU_RECRUITMENT = Target.the("Recruitment menu option")
            .located(By.xpath("//a[@class='oxd-main-menu-item' and contains(@href,'recruitment')]"));

    public static final Target MENU_PERFORMANCE = Target.the("Performance menu option")
            .located(By.xpath("//a[@class='oxd-main-menu-item' and contains(@href,'performance')]"));

    public static final Target MENU_DIRECTORY = Target.the("Directory menu option")
            .located(By.xpath("//a[@class='oxd-main-menu-item' and contains(@href,'directory')]"));

    public static final Target MENU_MY_INFO = Target.the("My Info menu option")
            .located(By.xpath("//a[@class='oxd-main-menu-item' and contains(@href,'viewMyDetails')]"));

    public static final Target QUICK_LAUNCH_WIDGETS = Target.the("Quick launch widgets")
            .located(By.cssSelector("div.oxd-grid-item.orangehrm-quick-launch-widget-card"));
}
