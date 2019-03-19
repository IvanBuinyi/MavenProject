package Lesson09;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Lesson08_add_basepage_and_simple_api.Conditions.clickable;

public class LandingPage extends BasePage {

    By searchFieldLocator = By.id("search_query_top");
    By firstTipLocator = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    void searchFor(String query) {
        //$(searchFieldLocator, ExpectedConditions::elementToBeClickable).click();
        $(searchFieldLocator, clickable).click();
        $(searchFieldLocator).clear();
        $(searchFieldLocator).sendKeys(query);
    }

    void visit() {
        open("http://automationpractice.com/index.php");
    }
}