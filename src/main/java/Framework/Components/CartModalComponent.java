package Framework.Components;

import Framework.Pages.ProductPage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class CartModalComponent {

    private final By titleLocator = By.xpath(".//*[@id='myModalLabel']");
    private final By titleIconLocator = By.xpath(".//*[@id='myModalLabel']/i");
    private final By paperTypeLocator = By.xpath(".//span[@class='paper type']/strong");
    private final By quantityLocator = By.xpath(".//span[@class='product-quantity']/strong");
    private final By totalPriceLocator = By.xpath("//p[@class='product-total']/span[@class='value']");
    private final By continueShoppingLocator = By.xpath("//button[@class='btn btn-secondary']");
    private final WebElement parentElement;
    private final String title;
    private final String quantity;
    private String paperType;

    public CartModalComponent(WebElement element) {
        parentElement = element;
        this.title = element.findElement(titleLocator).getText()
                .replace(parentElement.findElement(titleIconLocator).getText(), "").trim();
        try {
            this.paperType = element.findElement(paperTypeLocator).getText();
        } catch (NoSuchElementException e) {
            this.paperType = "";
        }
        this.quantity = element.findElement(quantityLocator).getText();
    }

    public String getCssValue(String value) {
        return parentElement.getCssValue(value);
    }

    public String getTotalPriceLocator() {
        return parentElement.findElement(totalPriceLocator).getText();
    }

    public ProductPage clickContinueShoppingButton() {
        parentElement.findElement(continueShoppingLocator).click();
        return new ProductPage();
    }
}
