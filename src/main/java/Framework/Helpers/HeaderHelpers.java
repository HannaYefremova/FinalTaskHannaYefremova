package Framework.Helpers;

import Framework.Components.LanguageComponent;
import Framework.Pages.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class HeaderHelpers extends BasePage {
    private static final By languagesContainersLocator = By.xpath("//div[@class='language-selector dropdown js-dropdown']/button");
    private static final By allLanguagesContainersLocator = By.xpath("//ul[@class='dropdown-menu hidden-sm-down']/li");

    public static List<LanguageComponent> getAllLanguages() {
        List<LanguageComponent> languageComponents = new ArrayList<>();
        List<WebElement> containers = BasePage.findAll(allLanguagesContainersLocator);
        for (WebElement element : containers) {
            LanguageComponent languageComponent = new LanguageComponent(element);
            languageComponents.add(languageComponent);
        }
        return languageComponents;
    }

    public static List<String> getLanguageNames(List<LanguageComponent> languageComponents) {
        List<String> result = new ArrayList<>();
        for (LanguageComponent lc : languageComponents) {
            result.add(lc.getLanguageName());
        }
        return result;
    }

    @Step("Click on the language dropdown")
    public static void ClickOnLanguages() {
        log.info("Click on the language dropdown");
        getWebDriver().findElement(languagesContainersLocator).click();
    }
}
