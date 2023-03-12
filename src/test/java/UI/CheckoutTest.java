package UI;

import Framework.Helpers.PriceHelper;
import Framework.Listeners.TestListeners;
import Framework.Pages.*;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class CheckoutTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkCorrectOrderCalculate() {

        String quantity = "1";

        ProductPage productPage = mainPage
                .searchTextAndPressEnter("Mug")
                .clickOnWebElementByName("Customizable Mug")
                .inputCustomText("Best mug ever")
                .clickSaveCustomization()
                .inputQuantity(quantity);

        String mugPrice = productPage.getPrice();

        productPage.clickAddToCartButton()
                .getModalWindow()
                .clickContinueShoppingButton();

        productPage = mainPage.searchTextAndPressEnter("T-Shirt")
                .clickOnWebElementByName("Hummingbird Printed T-Shirt")
                .clickOnTheColor("Black");

        String tshirtPrice = productPage.getPrice();

        ShoppingCardPage shoppingCardPage = productPage.clickAddToCartButton()
                .clickOnTheProceedToCheckoutButton();

        String totalPrice = shoppingCardPage.getTotalPrice();

        SoftAssertions softAssertions = new SoftAssertions();

        Double expectedPrice =
                PriceHelper.calculateTotalPrice(mugPrice, quantity) + PriceHelper.calculateTotalPrice(
                        tshirtPrice,
                        quantity
                );
        expectedPrice = PriceHelper.roundPrice(expectedPrice);

        softAssertions.assertThat(Double.parseDouble(totalPrice.substring(1)))
                .as("Total price is not equals expected")
                .isEqualTo(expectedPrice);

        PersonalInformationPage personalInformationPage = shoppingCardPage.clickProceedToCheckout()
                .setGender()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setBirthday()
                .checkCustomerPrivacy()
                .checkAgree()
                .clickPersonalInformationContinueButton()
                .setAddress()
                .setPostalCode()
                .setCity()
                .clickAddressContinueButton()
                .clickMyCarrierOptionButton()
                .clickDeliveryContinueButton()
                .clickPayByCheckOption();

        String amount = personalInformationPage.getPaymentAmount();
        String subtotal = personalInformationPage.getSubtotal();
        String shipping = personalInformationPage.getShipping();

        softAssertions.assertThat(PriceHelper.getPriceFromString(amount))
                .as("Amount values is not equals expected")
                .isEqualTo(PriceHelper.roundPrice(PriceHelper.getPriceFromString(subtotal) + PriceHelper.getPriceFromString(shipping)));

        OrderConfirmationPage orderConfirmationPage = personalInformationPage
                .checkAgreeCheckbox()
                .clickPlaceOrderButton();

        String confirmationText = orderConfirmationPage.getConfirmationText();

        softAssertions.assertThat(confirmationText)
                .as("Confirmation text is not equals expected")
                .isEqualTo("YOUR ORDER IS CONFIRMED");

        String confirmationSubtotal = orderConfirmationPage.getConfirmationSubtotal();
        String confirmationShipping = orderConfirmationPage.getConfirmationShipping();
        String confirmationTotal = orderConfirmationPage.getConfirmationTotal();

        softAssertions.assertThat(PriceHelper.getPriceFromString(confirmationTotal))
                .as("Confirmation page total value is not equals expected.")
                .isEqualTo(PriceHelper.roundPrice(PriceHelper.getPriceFromString(confirmationSubtotal) + PriceHelper.getPriceFromString(confirmationShipping)));

        softAssertions.assertAll();
    }
}
