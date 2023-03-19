package ui;

import framework.components.ProductComponent;
import framework.helpers.ProductsHelper;
import framework.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class PriceDropTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkPriceDropPricesTest() {
        mainPage.clickPricesDrop();
        List<ProductComponent> products = ProductsHelper.getAllProducts();
        List<BigDecimal> prices = ProductsHelper.getProductPrices(products);
        List<BigDecimal> regularPrices = ProductsHelper.getProductRegularPrices(products);
        List<BigDecimal> calculatedDiscounts = ProductsHelper.getCalculatedDiscount(products);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(regularPrices)
                .as("Product regularPrice is empty")
                .doesNotContainNull();

        softAssertions.assertThat(prices)
                .as("Product price is empty")
                .doesNotContainNull();

        softAssertions.assertThat(prices)
                .as("Product price is empty")
                .containsExactlyElementsOf(calculatedDiscounts);

        softAssertions.assertAll();
    }
}