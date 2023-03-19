package framework.pages;

import org.openqa.selenium.By;

import java.math.BigDecimal;

public class OrderConfirmationPage extends BasePage {
    private static final By confirmationSubtotalLocator = By.xpath("//div[@class='order-confirmation-table']//tr[1" +
            "]/td[2]");
    private static final By confirmationShippingLocator = By.xpath("//div[@class='order-confirmation-table']//tr[2" +
            "]/td[2]");
    private static final By confirmationTotalLocator = By.xpath("//div[@class='order-confirmation-table']//tr[3" +
            "]/td[2]");
    private final By confirmationTextLocator = By.xpath("//h3[@class='h1 card-title']");
    private final By confirmationTextIconLocator = By.xpath("//h3[@class='h1 card-title']/i");

    public String getConfirmationText() {
        return find(confirmationTextLocator).getText().replace(find(confirmationTextIconLocator).getText(), "").trim();
    }

    public BigDecimal getConfirmationSubtotal() {
        return new BigDecimal(find(confirmationSubtotalLocator).getText().substring(1));
    }

    public BigDecimal getConfirmationShipping() {
        return new BigDecimal(find(confirmationShippingLocator).getText().substring(1));
    }

    public BigDecimal getConfirmationTotal() {
        return new BigDecimal(find(confirmationTotalLocator).getText().substring(1));
    }
}