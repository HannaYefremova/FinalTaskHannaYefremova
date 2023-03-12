package UI;

import Framework.Components.ProductComponent;
import Framework.Helpers.ProductsHelper;
import Framework.Listeners.TestListeners;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;

@Listeners(TestListeners.class)
public class PopularProductsTest extends BaseTest {

    @Test
    public void checkPopularProductsTest() {
        List<ProductComponent> products = ProductsHelper.getAllProducts();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(products.size())
                .as("Products size is not equals expected")
                .isEqualTo(8);

        for (ProductComponent productComponent : products) {
            softAssertions.assertThat(productComponent.getName())
                    .as("Product name is empty")
                    .isNotEmpty();
            softAssertions.assertThat(productComponent.getPrice())
                    .as("Product price is empty")
                    .isNotEmpty();
            softAssertions.assertThat(Double.parseDouble(productComponent.getPrice().substring(1)))
                    .as("Product price is lover or equals zero")
                    .isGreaterThan(0);
        }

        softAssertions.assertAll();
    }
}
