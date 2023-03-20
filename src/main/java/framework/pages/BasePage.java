package framework.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Log4j2
public class BasePage {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

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

    public static boolean isElementPresent(By locator) {
        try {
            getWebDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static WebDriverWait getWaiter() {
        return new WebDriverWait(BasePage.getWebDriver(), Duration.ofSeconds(20));
    }

    public void selectByText(By selectLocator, String text) {
        Select select = new Select(find(selectLocator));
        select.selectByVisibleText(text);
    }

    public String getAttributeValue(WebElement webElement, String attributeName) {
        return webElement.getAttribute(attributeName);
    }

    public String getCssStyleValue(WebElement webElement, String style) {
        return webElement.getCssValue(style);
    }
}