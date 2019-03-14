package Lesson08_add_basepage_and_simple_api;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseTest {
    protected static WebDriver driver;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(String.format("Test '%s' - PASSED", description.getMethodName()));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(String.format("Test '%s' - FAILED", description.getMethodName()));
            super.failed(e, description);
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.println(String.format("Test '%s' - SKIPPED", description.getMethodName()));
            super.skipped(e, description);
        }

        @Override
        protected void starting(Description description) {
            System.out.println(String.format("Test '%s' - is starting...", description.getMethodName()));
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
        }
    };
    class LandingPage{

        @CacheLookup
        @FindBy(id = "search_query_top")
        WebElement searchFieald;

        @FindBy(xpath = "//*[@id=\"index\"]/div[2]/ul/li[1]")
        WebElement firstTip;

        public LandingPage(WebDriver driver){
            PageFactory.initElements(driver, this);
        }

        void searchFor (String query){
            searchFieald.clear();
            searchFieald.sendKeys(query);
        }

    }

}
