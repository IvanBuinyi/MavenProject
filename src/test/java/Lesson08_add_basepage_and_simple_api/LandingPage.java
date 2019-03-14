package Lesson08_add_basepage_and_simple_api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private WebDriver driver;


    By searchFieldlocator = By.id("search_query_top");
    By firstTipPage = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
}
