package UI;

import Framework.Enum.BrowserType;
import Framework.Pages.BasePage;
import Framework.Pages.BrowserFactory;
import Framework.Pages.MainPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

@Log4j2
public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp() {
        int width = Integer.parseInt(System.getProperty("browser.width"));
        int height = Integer.parseInt(System.getProperty("browser.height"));
        String browser = System.getProperty("browser.type");
        log.info("Tests will run at {}x{}", width, height);

        WebDriver driver = BrowserFactory.getBrowserInstance(BrowserType.valueOf(browser));

        driver.get("https://demo.prestashop.com/");
        driver.manage().window().setSize(new Dimension(width, height));
        BasePage.setDriverThreadLocal(driver);
        BasePage.wait = new WebDriverWait(BasePage.getWebDriver(), Duration.ofSeconds(20));
        MainPage mainPage = new MainPage();
        mainPage.waitForPageLoad();
        mainPage.switchToFrame("framelive");
    }

    @AfterMethod(alwaysRun = true)
    public void quite() {
        BasePage.getWebDriver().quit();
    }
}
