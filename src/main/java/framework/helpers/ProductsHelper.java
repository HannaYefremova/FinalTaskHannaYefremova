package framework.helpers;

import framework.components.ProductComponent;
import framework.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsHelper {
    private static final By allProductsLocator = By.xpath("//div[@class='products row']/div");

    @Step("Get all products from page")
    public static List<ProductComponent> getAllProducts() {
        List<WebElement> webElementList = BasePage.findAll(allProductsLocator);
        List<ProductComponent> result = new ArrayList<>();
        for (WebElement element : webElementList) {
            result.add(new ProductComponent(element));
        }
        return result;
    }

    public static List<String> getProductNames(List<ProductComponent> productComponents) {
        List<String> result = new ArrayList<>();
        for (ProductComponent productComponent : productComponents) {
            result.add(productComponent.getName());
        }
        return result;
    }

    public static List<BigDecimal> getProductPrices(List<ProductComponent> productComponents) {
        List<BigDecimal> result = new ArrayList<>();
        for (ProductComponent productComponent : productComponents) {
            result.add(productComponent.getPrice());
        }
        return result;
    }

    public static List<BigDecimal> getSortedProductPrices(List<ProductComponent> productComponents) {
        List<BigDecimal> result = new ArrayList<>();
        for (ProductComponent productComponent : productComponents) {
            if (productComponent.getRegularPrice() != null) {
                result.add(productComponent.getRegularPrice());
            } else {
                result.add(productComponent.getPrice());
            }
        }
        return result;
    }

    public static List<BigDecimal> getProductRegularPrices(List<ProductComponent> productComponents) {
        List<BigDecimal> result = new ArrayList<>();
        for (ProductComponent productComponent : productComponents) {
            result.add(productComponent.getRegularPrice());
        }
        return result;
    }

    public static List<BigDecimal> getCalculatedDiscount(List<ProductComponent> productComponents) {
        List<BigDecimal> result = new ArrayList<>();
        for (ProductComponent productComponent : productComponents) {
            result.add(PriceHelper.calculateDiscount(
                    productComponent.getRegularPrice(),
                    productComponent.getDiscountValue()
            ));
        }
        return result;
    }
}
