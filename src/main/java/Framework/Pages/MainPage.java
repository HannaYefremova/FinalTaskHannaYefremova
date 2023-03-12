package Framework.Pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MainPage extends BasePage {
    private final By loaderLocator = By.id("loadingMessage");
    private final By newsLetterLabelLocator = By.id("block-newsletter-label");
    private final By underEmailTextLocator = By.xpath("//div[@class='col-md-7 col-xs-12']//p");
    private final By subscribeButtonLocator = By.xpath(
            "//input[@class='btn btn-primary float-xs-right hidden-xs-down']");
    private final By clothesMenuLocator = By.id(
            "category-3");
    private final By accessoriesMenuLocator = By.id(
            "category-6");
    private final By artMenuLocator = By.id(
            "category-9");
    private final By subMenuClothesLocator = By.xpath("//li[@id='category-3']//div[@class='popover " +
            "sub-menu js-sub-menu collapse']");
    private final By subMenuAccessoriesLocator = By.xpath("//li[@id='category-6']//div[@class='popover sub-menu " +
            "js-sub-menu collapse']");
    private final By subMenuArtLocator = By.xpath("//li[@id='category-9']//div[@class='popover " +
            "sub-menu " +
            "js-sub-menu collapse']");
    private final By searchFieldLocator = By.xpath("//div[@id='search_widget']//input[@type='text']");
    private final By pricesDropLocator = By.xpath("//ul[@id='footer_sub_menu_1']/li[1]/a");
    private final By allProductsLinkLocator = By.xpath("//a[@class='all-product-link float-xs-left float-md-right " +
            "h4']");
    public HeaderPage headerPage = new HeaderPage();

    @Step("Get text near the email field")
    public String getNewLetterLabelText() {
        log.info("Get text near the email field");
        return find(newsLetterLabelLocator).getText();
    }

    @Step("Get text under email field")
    public String getUnderEmailText() {
        log.info("Get text under email field");
        return find(underEmailTextLocator).getText();
    }

    @Step("Get Subscribe button text")
    public String getSubscribeButtonText() {
        log.info("Get Subscribe button text");
        return find(subscribeButtonLocator).getAttribute("value");
    }

    @Step("Wait for loader hide")
    public void waitForPageLoad() {
        log.info("Wait for loader hide");
        WebElement loader = find(loaderLocator);
        wait.until(ExpectedConditions.invisibilityOf(loader));
    }

    @Step("Switch to another iframe")
    public void switchToFrame(String frameName) {
        log.info("Switch to another iframe");
        getWebDriver().switchTo().frame(frameName);
    }

    @Step("Hover over by 'Clothes' menu")
    public void hoverOverByClothesMenu() {
        log.info("Hover over by 'Clothes' menu");
        hoverOverElement(find(clothesMenuLocator));
    }

    public WebElement getClothesSubMenu() {
        return find(subMenuClothesLocator);
    }

    @Step("Hover over by 'ACCESSORIES' menu")
    public void hoverOverByAccessoriesMenu() {
        log.info("Hover over by 'ACCESSORIES' menu");
        hoverOverElement(find(accessoriesMenuLocator));
    }

    public WebElement getAccessoriesSubMenu() {
        return find(subMenuAccessoriesLocator);
    }

    @Step("Hover over by 'Art' menu")
    public void hoverOverByArtMenu() {
        log.info("Hover over by 'Art' menu");
        hoverOverElement(find(artMenuLocator));
    }

    public boolean checkArtSubMenuForVisible() {
        return isElementPresent(subMenuArtLocator);
    }

    @Step("Click prices drop link")
    public PricesDropPage clickPricesDrop() {
        log.info("Click prices drop link");
        find(pricesDropLocator).click();
        return new PricesDropPage();
    }

    @Step("Click all products link")
    public ProductsPage clickAllProducts() {
        log.info("Click all products link");
        find(allProductsLinkLocator).click();
        return new ProductsPage();
    }

    @Step("Input search text and press enter")
    public SearchResultPage searchTextAndPressEnter(String text) {
        log.info("Input search text and press enter");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchElement = find(searchFieldLocator);
        searchElement.sendKeys(text);
        searchElement.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }
}
