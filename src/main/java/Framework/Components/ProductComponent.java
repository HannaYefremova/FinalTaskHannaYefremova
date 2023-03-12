package Framework.Components;

import Framework.Pages.ProductPage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class ProductComponent {

    private final By priceLocator = By.xpath(".//div[@class='product-price-and-shipping']/span[@class='price']");
    private final By regularPriceLocator = By.xpath(".//div[@class='product-price-and-shipping']/span[@class='regular-price']");
    private final By nameLocator = By.xpath(".//*[@class='h3 product-title']");
    private final By discountValueLocator = By.xpath(".//li[@class='product-flag discount']");

    private final WebElement baseElement;
    private String name;
    private String price;
    private String discountValue;
    private String regularPrice;

    public ProductComponent(WebElement webElement) {
        baseElement = webElement;
        try {
            this.price = webElement.findElement(priceLocator).getText();

        } catch (NoSuchElementException e) {
            this.price = "";
        }

        try {
            this.name = webElement.findElement(nameLocator).getText();
        } catch (NoSuchElementException e) {
            this.name = "";
        }

        try {
            this.discountValue = webElement.findElement(discountValueLocator).getText();
        } catch (NoSuchElementException e) {
            this.discountValue = "";
        }

        try {
            this.regularPrice = webElement.findElement(regularPriceLocator).getText();
        } catch (NoSuchElementException e) {
            this.regularPrice = "";
        }
    }

    public ProductPage clickOnElement() {
        baseElement.click();
        return new ProductPage();
    }
}
