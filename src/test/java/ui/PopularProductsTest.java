package ui;

import framework.components.ProductComponent;
import framework.helpers.ProductsHelper;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class PopularProductsTest extends BaseTest {
    @Test
    public void checkPopularProductsTest() {
        List<ProductComponent> products = ProductsHelper.getAllProducts();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(products.size())
                .as("Products size is not equals expected")
                .isEqualTo(8);

        List<String> productNames = ProductsHelper.getProductNames(products);
        softAssertions.assertThat(productNames)
                .as("Product name is empty")
                .doesNotContainNull();

        List<BigDecimal> productPrices = ProductsHelper.getProductPrices(products);
        softAssertions.assertThat(productPrices)
                .as("Product price is empty")
                .doesNotContainNull();

        softAssertions.assertThat(productPrices)
                .as("Product price is lover or equals zero")
                .allSatisfy(input -> softAssertions.assertThat(input).isGreaterThan(BigDecimal.ZERO));

        softAssertions.assertAll();
    }
}