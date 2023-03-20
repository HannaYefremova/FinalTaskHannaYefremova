package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;


public class ShoppingCardPage extends BasePage {
    private final By totalValueLocator = By.xpath("//div[@class='cart-summary-line cart-total']/span[@class='value']");
    private final By proceedToCheckoutButtonLocator = By.xpath("//div[@class='checkout cart-detailed-actions js-cart-detailed-actions card-block']//a");

    public BigDecimal getTotalPrice() {
        BasePage.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(totalValueLocator));
        return new BigDecimal(find(totalValueLocator).getText().substring(1));
    }

    public PersonalInformationPage clickProceedToCheckout() {
        find(proceedToCheckoutButtonLocator).click();
        return new PersonalInformationPage();
    }
}