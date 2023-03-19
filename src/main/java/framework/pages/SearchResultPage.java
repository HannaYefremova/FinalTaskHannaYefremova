package framework.pages;

import framework.components.ProductComponent;
import framework.helpers.ProductsHelper;

import java.util.List;

public class SearchResultPage extends BasePage {

    public ProductPage clickOnWebElementByName(String text) {
        List<ProductComponent> productComponentList = ProductsHelper.getAllProducts();
        for (ProductComponent component : productComponentList) {
            if (component.getName().equals(text)) {
                return component.clickOnElement();
            }
        }

        return new ProductPage();
    }
}
