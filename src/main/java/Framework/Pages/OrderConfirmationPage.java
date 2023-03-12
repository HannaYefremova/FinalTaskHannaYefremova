package Framework.Pages;

import org.openqa.selenium.By;

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

    public String getConfirmationSubtotal() {
        return find(confirmationSubtotalLocator).getText();
    }

    public String getConfirmationShipping() {
        return find(confirmationShippingLocator).getText();
    }

    public String getConfirmationTotal() {
        return find(confirmationTotalLocator).getText();
    }
}
