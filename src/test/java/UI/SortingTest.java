package UI;

import Framework.Components.ProductComponent;
import Framework.Helpers.ProductsHelper;
import Framework.Listeners.TestListeners;
import Framework.Pages.MainPage;
import Framework.Pages.ProductsPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Listeners(TestListeners.class)
public class SortingTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkCorrectSortingTest() {
        ProductsPage productsPage = mainPage.clickAllProducts();
        productsPage.clickOnSortBy().clickOnDropdownItemByName("Name, A to Z");
        List<ProductComponent> products = ProductsHelper.getAllProducts();
        List<String> productNamesSorted = ProductsHelper.getProductNames(products);
        productNamesSorted.sort(Comparator.comparing(String::toLowerCase));
        products = ProductsHelper.getAllProducts();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(ProductsHelper.getProductNames(products))
                .as("Products name is not sorted as expected.")
                .containsExactlyElementsOf(productNamesSorted);

        productsPage.clickOnSortBy().clickOnDropdownItemByName("Name, Z to A");
        products = ProductsHelper.getAllProducts();
        productNamesSorted = ProductsHelper.getProductNames(products);
        productNamesSorted.sort(Collections.reverseOrder());
        softAssertions.assertThat(ProductsHelper.getProductNames(products))
                .as("Products name is not sorted as expected.")
                .containsExactlyElementsOf(productNamesSorted);

        productsPage.clickOnSortBy().clickOnDropdownItemByName("Price, low to high");
        products = ProductsHelper.getAllProducts();
        List<Double> productPriceSorted = ProductsHelper.getProductPrices(products);
        productPriceSorted.sort(Comparator.comparing(Double::doubleValue));
        softAssertions.assertThat(ProductsHelper.getProductPrices(products))
                .as("Products price is not sorted as expected.")
                .containsExactlyElementsOf(productPriceSorted);

        productsPage.clickOnSortBy().clickOnDropdownItemByName("Price, high to low");
        products = ProductsHelper.getAllProducts();
        productPriceSorted = ProductsHelper.getProductPrices(products);
        productPriceSorted.sort(Collections.reverseOrder());

        softAssertions.assertThat(ProductsHelper.getProductPrices(products))
                .as("Products price is not sorted as expected.")
                .containsExactlyElementsOf(productPriceSorted);

        softAssertions.assertAll();
    }
}
