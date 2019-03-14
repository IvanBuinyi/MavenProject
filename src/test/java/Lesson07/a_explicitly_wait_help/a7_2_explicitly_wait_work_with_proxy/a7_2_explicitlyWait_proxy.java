package Lesson07.a_explicitly_wait_help.a7_2_explicitly_wait_work_with_proxy;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class a7_2_explicitlyWait_proxy {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();

       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void verifyFirstTip(){
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");

        WebElement searchRes = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"));

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .textToBePresentInElement(searchRes,"Dress"));


        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");

        (new WebDriverWait(driver, 10)).ignoring(StaleElementReferenceException.class)
                .until(webDriver -> webDriver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
                        .getText().contains("T-shirts"));


    }

}