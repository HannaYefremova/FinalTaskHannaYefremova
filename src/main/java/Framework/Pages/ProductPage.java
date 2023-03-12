package Framework.Pages;

import Framework.Components.CartModalComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

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

    public ProductPage inputQuantity(String value) {
        WebElement button = find(quantityIncrementButtonLocator);
        int intValue = Integer.parseInt(value);
        for (int i = 1; i < intValue; i++) {
            button.click();
            //wait for html reload with max timeout 5;
            wait.withTimeout(Duration.ofSeconds(5));
        }
        return this;
    }

    public ProductPage clickAddToCartButton() {
        find(addToCartButtonLocator).click();
        return this;
    }

    public CartModalComponent getModalWindow() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalWindowLocator));
        return new CartModalComponent(find(modalWindowLocator));
    }

    public String getPrice() {
        return find(priceLocator).getText();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButtonLocator));
        find(proceedToCheckoutButtonLocator).click();
        return new ShoppingCardPage();
    }
}
