package framework.pages;

import framework.components.CartModalComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

@Log4j2
public class ProductPage extends BasePage {
    private final By paperTypeLocator = By.xpath("//select[@id='group_4']");
    private final By quantityIncrementButtonLocator = By.xpath("//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']");
    private final By addToCartButtonLocator = By.xpath("//button[@class='btn btn-primary add-to-cart']");
    private final By modalWindowLocator = By.xpath("//div[@id='blockcart-modal']");
    private final By priceLocator = By.xpath("//span[@class='current-price-value']");
    private final By customTextAreaLocator = By.xpath("//textarea[@id='field-textField1']");
    private final By saveCustomizationButtonLocator = By.xpath("//button[@name='submitCustomizedData']");
    private final By selectColorLocator = By.xpath("//input[@class='input-color']");
    private final By proceedToCheckoutButtonLocator = By.xpath("//a[@class='btn btn-primary']/i");


    public ProductPage selectPaperType(String value) {
        selectByText(paperTypeLocator, value);
        return this;
    }

    public ProductPage inputQuantity(int value) {
        WebElement button = find(quantityIncrementButtonLocator);
        for (int i = 1; i < value; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("An exception has occurred while wait for next button click.");
            }
            button.click();
            BasePage.getWaiter().withTimeout(Duration.ofSeconds(5));
        }
        return this;
    }

    public ProductPage clickAddToCartButton() {
        find(addToCartButtonLocator).click();
        return this;
    }

    public CartModalComponent getModalWindow() {
        BasePage.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(modalWindowLocator));
        return new CartModalComponent(find(modalWindowLocator));
    }

    public BigDecimal getPrice() {
        return new BigDecimal(find(priceLocator).getText().substring(1));
    }

    public ProductPage inputCustomText(String text) {
        find(customTextAreaLocator).sendKeys(text);
        return this;
    }

    public ProductPage clickSaveCustomization() {
        find(saveCustomizationButtonLocator).click();
        return this;
    }

    public ProductPage clickOnTheColor(String color) {
        List<WebElement> productsColor = findAll(selectColorLocator);
        for (WebElement element : productsColor) {
            if (element.getAttribute("title").equals(color)) {
                element.click();
            }
        }
        return this;
    }

    public ShoppingCardPage clickOnTheProceedToCheckoutButton() {
        BasePage.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButtonLocator));
        find(proceedToCheckoutButtonLocator).click();
        return new ShoppingCardPage();
    }
}