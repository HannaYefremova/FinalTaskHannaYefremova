package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;


public class ShoppingCardPage extends BasePage {
    private final By totalValueLocator = By.xpath("//div[@class='cart-summary-line cart-total']/span[@class='value']");
    private final By proceedToCheckoutButtonLocator = By.xpath("//div[@class='checkout cart-detailed-actions js-cart-detailed-actions card-block']//a");

    public BigDecimal getTotalPrice() {
        new WebDriverWait(BasePage.getWebDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(totalValueLocator));
        return new BigDecimal(find(totalValueLocator).getText().substring(1));
    }

    public PersonalInformationPage clickProceedToCheckout() {
        find(proceedToCheckoutButtonLocator).click();
        return new PersonalInformationPage();
    }
}