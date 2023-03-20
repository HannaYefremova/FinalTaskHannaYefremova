package ui;

import framework.components.ProductComponent;
import framework.enums.SortingTypes;
import framework.helpers.ProductsHelper;
import framework.pages.MainPage;
import framework.pages.ProductsPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkCorrectSortingTest() {
        ProductsPage productsPage = mainPage.clickAllProducts();
        productsPage.clickOnSortBy().clickOnDropdownItemByName(SortingTypes.NAME_A_Z.getValueName());
        List<ProductComponent> products = ProductsHelper.getAllProducts();
        List<String> productNamesSorted = ProductsHelper.getProductNames(products);
        productNamesSorted.sort(Comparator.comparing(String::toLowerCase));
        products = ProductsHelper.getAllProducts();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(ProductsHelper.getProductNames(products))
                .as("Products name is not sorted as expected.")
                .containsExactlyElementsOf(productNamesSorted);

        productsPage.clickOnSortBy().clickOnDropdownItemByName(SortingTypes.NAME_Z_A.getValueName());
        products = ProductsHelper.getAllProducts();
        productNamesSorted = ProductsHelper.getProductNames(products);
        productNamesSorted.sort(Collections.reverseOrder());
        softAssertions.assertThat(ProductsHelper.getProductNames(products))
                .as("Products name is not sorted as expected.")
                .containsExactlyElementsOf(productNamesSorted);

        productsPage.clickOnSortBy().clickOnDropdownItemByName(SortingTypes.PRICE_LOW_HIGH.getValueName());
        products = ProductsHelper.getAllProducts();
        List<BigDecimal> productPriceSorted = ProductsHelper.getSortedProductPrices(products);
        productPriceSorted.sort(Comparator.comparing(BigDecimal::doubleValue));
        softAssertions.assertThat(ProductsHelper.getSortedProductPrices(products))
                .as("Products price is not sorted as expected.")
                .containsExactlyElementsOf(productPriceSorted);

        productsPage.clickOnSortBy().clickOnDropdownItemByName(SortingTypes.PRICE_HIGH_LOW.getValueName());
        products = ProductsHelper.getAllProducts();
        productPriceSorted = ProductsHelper.getSortedProductPrices(products);
        productPriceSorted.sort(Collections.reverseOrder());

        softAssertions.assertThat(ProductsHelper.getSortedProductPrices(products))
                .as("Products price is not sorted as expected.")
                .containsExactlyElementsOf(productPriceSorted);

        softAssertions.assertAll();
    }
}