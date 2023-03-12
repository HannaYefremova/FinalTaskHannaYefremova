package Framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ShoppingCardPage extends BasePage {
    private final By totalValueLocator = By.xpath("//div[@class='cart-summary-line cart-total']/span[@class='value']");
    private final By proceedToCheckoutButtonLocator = By.xpath("//div[@class='checkout cart-detailed-actions js-cart-detailed-actions card-block']//a");


    public String getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalValueLocator));
        return find(totalValueLocator).getText();
    }

    public PersonalInformationPage clickProceedToCheckout() {
        find(proceedToCheckoutButtonLocator).click();
        return new PersonalInformationPage();
    }
}
