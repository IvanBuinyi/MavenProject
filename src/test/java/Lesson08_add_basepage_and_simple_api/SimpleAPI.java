package Lesson08_add_basepage_and_simple_api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class SimpleAPI {

    abstract WebDriver getDriver();

    protected void open(String url){
        driver.get(url);
    }

    protected WebElement $(By locator){
        return driver.findElement(locator);
    }

    protected WebElement $(String xPath){
        return $(By.xpath(xPath));
    }

    protected List<WebElement> $$(By locator){
        return driver.findElement(locator);
    }
    protected List<WebElement> $$(String xPath) {
        return $$(By.xpath(xPath));
    }

    <T> T waitFor(ExpectedCondition<T> condition, long timeout){
        return (new WebDriverWait(driver,timeout)).until(condition);
    }

    <T> T waitFor(ExpectedCondition<T> condition){
        return (new WebDriverWait(driver, 10l)).until(condition);
    }
}
