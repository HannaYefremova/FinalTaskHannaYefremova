package Framework.Pages;

import Framework.Components.SubMenuComponent;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

@Log4j2
public class BasePage {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    public static WebDriverWait wait;

    public static ThreadLocal<WebDriver> getDriverThreadLocal() {
        return DRIVER_THREAD_LOCAL;
    }

    public static void setDriverThreadLocal(WebDriver driver) {
        DRIVER_THREAD_LOCAL.set(driver);
    }

    public static WebDriver getWebDriver() {
        return getDriverThreadLocal().get();
    }

    public static WebElement find(By locator) {
        return getWebDriver().findElement(locator);
    }

    public static List<WebElement> findAll(By locator) {
        return getWebDriver().findElements(locator);
    }

    @Step("Hover over by element")
    public static void hoverOverElement(WebElement webElement) {
        log.info("Hover over by element");
        Actions action = new Actions(getWebDriver());
        action.moveToElement(webElement).perform();
    }

    public static List<String> getSubMenuNames(WebElement webElement) {
        return new SubMenuComponent(webElement).getSubMenuNames();
    }

    public static boolean isElementPresent(By locator) {
        try {
            getWebDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectByText(By selectLocator, String text) {
        Select select = new Select(find(selectLocator));
        select.selectByVisibleText(text);
    }
}
