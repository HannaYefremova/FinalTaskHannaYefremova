package framework.components;

import framework.pages.ProductPage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

@Getter
public class ProductComponent {
    private final By priceLocator = By.xpath(".//div[@class='product-price-and-shipping']/span[@class='price']");
    private final By regularPriceLocator = By.xpath(".//div[@class='product-price-and-shipping']/span[@class='regular-price']");
    private final By nameLocator = By.xpath(".//*[@class='h3 product-title']");
    private final By discountValueLocator = By.xpath(".//li[@class='product-flag discount']");
    private final WebElement baseElement;
    private String name;
    private BigDecimal price;
    private int discountValue;
    private BigDecimal regularPrice;

    public ProductComponent(WebElement webElement) {
        baseElement = webElement;
        try {
            this.price = new BigDecimal(webElement.findElement(priceLocator).getText().substring(1));

        } catch (NoSuchElementException e) {
            this.price = null;
        }

        try {
            this.name = webElement.findElement(nameLocator).getText();
        } catch (NoSuchElementException e) {
            this.name = "";
        }

        try {
            String stringDiscount = webElement.findElement(discountValueLocator).getText();
            this.discountValue = Integer.parseInt(stringDiscount.substring(1, stringDiscount.length() - 1));
        } catch (NoSuchElementException e) {
            this.discountValue = 0;
        }

        try {
            this.regularPrice = new BigDecimal(webElement.findElement(regularPriceLocator).getText().substring(1));
        } catch (NoSuchElementException e) {
            this.regularPrice = null;
        }
    }

    public ProductPage clickOnElement() {
        baseElement.click();
        return new ProductPage();
    }
}