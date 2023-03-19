package framework.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

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
    private final int quantity;
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
        this.quantity = Integer.parseInt(element.findElement(quantityLocator).getText());
    }

    public BigDecimal getTotalPrice() {
        return new BigDecimal(parentElement.findElement(totalPriceLocator).getText().substring(1));
    }

    public void clickContinueShoppingButton() {
        parentElement.findElement(continueShoppingLocator).click();
    }
}
