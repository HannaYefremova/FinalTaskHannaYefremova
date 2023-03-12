package UI;

import Framework.Components.CartModalComponent;
import Framework.Listeners.TestListeners;
import Framework.Pages.MainPage;
import Framework.Pages.ProductPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class AddToCartTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    public void addToCartTest() {
        String paperType = "Doted";
        String quantity = "5";

        ProductPage productPage = mainPage.searchTextAndPressEnter("Bear")
                .clickOnWebElementByName("Brown Bear Notebook");
        String price = productPage.getPrice();

        CartModalComponent cartModalComponent = productPage
                .selectPaperType(paperType)
                .inputQuantity(quantity)
                .clickAddToCartButton()
                .getModalWindow();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(cartModalComponent.getCssValue("display"))
                .as("Modal window is not appear.")
                .isNotEqualTo("none");

        softAssertions.assertThat(cartModalComponent.getTitle())
                .as("Modal window title is not expected.")
                .isEqualTo("Product successfully added to your shopping cart");


        softAssertions.assertThat(cartModalComponent.getPaperType())
                .as("Modal window paper type value is not expected.")
                .isEqualTo(paperType);

        softAssertions.assertThat(cartModalComponent.getQuantity())
                .as("Modal window quantity value is not expected.")
                .isEqualTo(quantity);

        softAssertions.assertThat(Double.parseDouble(cartModalComponent.getTotalPriceLocator().substring(1)))
                .as("Total price calculated wrong.")
                .isEqualTo(Double.parseDouble(quantity) * Double.parseDouble(price.substring(1)));

        softAssertions.assertAll();
    }
}
