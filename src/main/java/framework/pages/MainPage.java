package framework.pages;

import framework.components.MenuComponent;
import io.qameta.allure.Step;
import lombok.Getter;
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
    private final By searchFieldLocator = By.xpath("//div[@id='search_widget']//input[@type='text']");
    private final By pricesDropLocator = By.xpath("//ul[@id='footer_sub_menu_1']/li[1]/a");
    private final By allProductsLinkLocator = By.xpath("//a[@class='all-product-link float-xs-left float-md-right " +
            "h4']");

    @Getter
    private final HeaderPage headerPage;
    @Getter
    private final MenuComponent menuComponent;

    public MainPage() {
        headerPage = new HeaderPage();
        menuComponent = new MenuComponent();
    }

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

    public WebElement getSubscribeButton() {
        log.info("Get Subscribe button element");
        return find(subscribeButtonLocator);
    }

    @Step("Wait for loader hide")
    public void waitForPageLoad() {
        log.info("Wait for loader hide");
        WebElement loader = find(loaderLocator);
        BasePage.getWaiter().until(ExpectedConditions.invisibilityOf(loader));
    }

    @Step("Switch to another iframe")
    public void switchToFrame(String frameName) {
        log.info("Switch to another iframe");
        getWebDriver().switchTo().frame(frameName);
    }

    @Step("Click prices drop link")
    public void clickPricesDrop() {
        log.info("Click prices drop link");
        find(pricesDropLocator).click();
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
        BasePage.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchElement = find(searchFieldLocator);
        searchElement.sendKeys(text);
        searchElement.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }
}