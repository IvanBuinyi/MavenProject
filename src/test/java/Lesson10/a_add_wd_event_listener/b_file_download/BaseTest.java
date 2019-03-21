package Lesson10.a_add_wd_event_listener.b_file_download;

import Lesson08_add_basepage_and_simple_api.SimpleAPI;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import utils.EventHandler;

import java.util.concurrent.TimeUnit;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public abstract class BaseTest extends SimpleAPI{

    protected static WebDriver driver;

    @Override
    WebDriver getDriver() {
        return driver;
    }

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(String
                    .format("Test '%s' - PASSED", description.getMethodName()));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(String
                    .format("Test '%s' - FAILED due to: %s",
                            description.getMethodName(),
                            e.getMessage()));
            super.failed(e, description);
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.println(String
                    .format("Test '%s' - SKIPPED", description.getMethodName()));
            super.skipped(e, description);
        }

        @Override
        protected void starting(Description description) {
            System.out.println(String
                    .format("Test '%s' - is starting...", description.getMethodName()));
            super.starting(description);
        }
    };

    @BeforeClass
    public static void setUp() {

        EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new EventHandler());

        driver = wd;

        LOGGER.debug("WebDriver has been started");

        //driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    void assertThat(ExpectedCondition<Boolean> condition) {
        assertThat(condition, 10l);
    }

    void assertThat(ExpectedCondition<Boolean> condition, long timeout) {
        waitFor(condition, timeout);
    }
}

