package framework.helpers;

import framework.pages.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class HeaderHelpers extends BasePage {
    private static final By languagesContainersLocator = By.xpath("//div[@class='language-selector dropdown js-dropdown']/button");
    private static final By languagesLocator = By.xpath("//ul[@class='dropdown-menu " +
            "hidden-sm-down']/li/a");

    public static List<String> getLanguages() {
        List<String> result = new ArrayList<>();
        List<WebElement> containers = BasePage.findAll(languagesLocator);
        for (WebElement element : containers) {
            result.add(element.getText());
        }
        return result;
    }

    @Step("Click on the language dropdown")
    public static void ClickOnLanguages() {
        log.info("Click on the language dropdown");
        getWebDriver().findElement(languagesContainersLocator).click();
    }
}