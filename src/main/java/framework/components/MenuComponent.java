package framework.components;

import framework.enums.MenuItems;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static framework.pages.BasePage.*;

@Log4j2
public class MenuComponent {
    public final By subMenuValueLocator = By.xpath(".//li[@class='category']/a");
    private final By clothesMenuLocator = By.id("category-3");
    private final By accessoriesMenuLocator = By.id("category-6");
    private final By artMenuLocator = By.id("category-9");
    private final By subMenuClothesLocator = By.xpath("//li[@id='category-3']//div[@class='popover " +
            "sub-menu js-sub-menu collapse']");
    private final By subMenuAccessoriesLocator = By.xpath("//li[@id='category-6']//div[@class='popover sub-menu " +
            "js-sub-menu collapse']");
    private final By subMenuArtLocator = By.xpath("//li[@id='category-9']//div[@class='popover " +
            "sub-menu " +
            "js-sub-menu collapse']");
    private List<WebElement> subMenuElements;

    @Step("Hover over element")
    public void hoverOver(MenuItems menuItem) {
        switch (menuItem) {
            case CLOTHES:
                this.subMenuElements = find(clothesMenuLocator).findElements(subMenuValueLocator);
                hoverOverElement(clothesMenuLocator);
                break;
            case ACCESSORIES:
                this.subMenuElements = find(accessoriesMenuLocator).findElements(subMenuValueLocator);
                hoverOverElement(accessoriesMenuLocator);
                break;
            case ART:
                this.subMenuElements = find(artMenuLocator).findElements(subMenuValueLocator);
                hoverOverElement(artMenuLocator);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + menuItem);
        }
    }

    private void hoverOverElement(By locator) {
        log.info("Hover over element");
        WebElement webElement = getWebDriver().findElement(locator);
        Actions action = new Actions(getWebDriver());
        action.moveToElement(webElement).perform();
    }

    public WebElement getSubMenu(MenuItems menuItem) {
        switch (menuItem) {
            case CLOTHES:
                return getWebDriver().findElement(subMenuClothesLocator);
            case ACCESSORIES:
                return getWebDriver().findElement(subMenuAccessoriesLocator);
            case ART:
                return getWebDriver().findElement(subMenuArtLocator);

            default:
                throw new IllegalStateException("Unexpected value: " + menuItem);
        }
    }

    public boolean isArtSubMenuVisible() {
        return isElementPresent(subMenuArtLocator);
    }

    public List<String> getSubMenuNames() {
        List<String> list = new ArrayList<>();
        for (WebElement element : subMenuElements) {
            list.add(element.getText());
        }
        return list;
    }
}