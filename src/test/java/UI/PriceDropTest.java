package UI;

import Framework.Components.ProductComponent;
import Framework.Helpers.PriceHelper;
import Framework.Helpers.ProductsHelper;
import Framework.Listeners.TestListeners;
import Framework.Pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;

@Listeners(TestListeners.class)
public class PriceDropTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkPriceDropPricesTest() {
        mainPage.clickPricesDrop();
        List<ProductComponent> products = ProductsHelper.getAllProducts();

        SoftAssertions softAssertions = new SoftAssertions();
        for (ProductComponent product : products) {

            String regularPrice = product.getRegularPrice();
            String price = product.getPrice();

            softAssertions.assertThat(regularPrice)
                    .as("Product regularPrice is empty")
                    .isNotEmpty();
            softAssertions.assertThat(price)
                    .as("Product price is empty")
                    .isNotEmpty();

            Double expectedPrice = PriceHelper.calculateDiscount(regularPrice, product.getDiscountValue());
            expectedPrice = PriceHelper.roundPrice(expectedPrice);

            softAssertions.assertThat(expectedPrice)
                    .as("Product discount is not properly calculated")
                    .isEqualTo(Double.parseDouble(price.substring(1)));
        }

        softAssertions.assertAll();
    }
}
