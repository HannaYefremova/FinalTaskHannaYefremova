package Framework.Helpers;

import Framework.Components.ProductComponent;
import Framework.Pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public static List<Double> getProductPrices(List<ProductComponent> productComponents) {
        List<Double> result = new ArrayList<>();
        for (ProductComponent productComponent : productComponents) {
            result.add(Double.parseDouble(productComponent.getPrice().substring(1)));
        }
        return result;
    }
}
