package ui;

import framework.components.CartModalComponent;
import framework.pages.MainPage;
import framework.pages.ProductPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class AddToCartTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    public void addToCartTest() {
        String paperType = "Doted";
        int quantity = 5;

        ProductPage productPage = mainPage.searchTextAndPressEnter("Bear")
                .clickOnWebElementByName("Brown Bear Notebook");
        BigDecimal price = productPage.getPrice();
        CartModalComponent cartModalComponent = productPage
                .selectPaperType(paperType)
                .inputQuantity(quantity)
                .clickAddToCartButton()
                .getModalWindow();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(cartModalComponent.getParentElement().isDisplayed())
                .as("Modal window is not appear.");

        softAssertions.assertThat(cartModalComponent.getTitle())
                .as("Modal window title is not expected.")
                .isEqualTo("Product successfully added to your shopping cart");

        softAssertions.assertThat(cartModalComponent.getPaperType())
                .as("Modal window paper type value is not expected.")
                .isEqualTo(paperType);

        softAssertions.assertThat(cartModalComponent.getQuantity())
                .as("Modal window quantity value is not expected.")
                .isEqualTo(quantity);

        softAssertions.assertThat(cartModalComponent.getTotalPrice())
                .as("Total price calculated wrong.")
                .isEqualTo(price.multiply(new BigDecimal(quantity)));

        softAssertions.assertAll();
    }
}
