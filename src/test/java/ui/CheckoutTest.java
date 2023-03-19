package ui;

import framework.enums.Genders;
import framework.helpers.PriceHelper;
import framework.helpers.StringHelpers;
import framework.pages.*;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CheckoutTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkCorrectOrderCalculate() {
        int quantity = 1;

        ProductPage productPage = mainPage
                .searchTextAndPressEnter("Mug")
                .clickOnWebElementByName("Customizable Mug")
                .inputCustomText("Best mug ever")
                .clickSaveCustomization()
                .inputQuantity(quantity);

        BigDecimal mugPrice = productPage.getPrice();

        productPage.clickAddToCartButton()
                .getModalWindow()
                .clickContinueShoppingButton();

        productPage = mainPage.searchTextAndPressEnter("T-Shirt")
                .clickOnWebElementByName("Hummingbird Printed T-Shirt")
                .clickOnTheColor("Black");

        BigDecimal tshirtPrice = productPage.getPrice();

        ShoppingCardPage shoppingCardPage = productPage.clickAddToCartButton()
                .clickOnTheProceedToCheckoutButton();

        BigDecimal totalPrice = shoppingCardPage.getTotalPrice();

        SoftAssertions softAssertions = new SoftAssertions();

        BigDecimal expectedPrice =
                PriceHelper.calculateTotalPrice(mugPrice, quantity).add(PriceHelper.calculateTotalPrice(
                        tshirtPrice, quantity));

        softAssertions.assertThat(totalPrice)
                .as("Total price is not equals expected")
                .isEqualTo(expectedPrice);

        PersonalInformationPage personalInformationPage = shoppingCardPage.clickProceedToCheckout()
                .setGender(Genders.MR)
                .setFirstName(StringHelpers.generateValidFirstName())
                .setLastName(StringHelpers.generateValidLastName())
                .setEmail(StringHelpers.generateValidEmail())
                .setBirthday(StringHelpers.generaValidBirthdate())
                .checkCustomerPrivacy()
                .checkAgree()
                .clickPersonalInformationContinueButton()
                .setAddress(StringHelpers.generateValidAddress())
                .setPostalCode(StringHelpers.generatePostalCode())
                .setCity(StringHelpers.generateCity())
                .clickAddressContinueButton()
                .clickMyCarrierOptionButton()
                .clickDeliveryContinueButton()
                .clickPayByCheckOption();

        BigDecimal amount = personalInformationPage.getPaymentAmount();
        BigDecimal subtotal = personalInformationPage.getSubtotal();
        BigDecimal shipping = personalInformationPage.getShipping();

        softAssertions.assertThat(amount)
                .as("Amount values is not equals expected")
                .isEqualTo(subtotal.add(shipping));

        OrderConfirmationPage orderConfirmationPage = personalInformationPage
                .checkAgreeCheckbox()
                .clickPlaceOrderButton();

        String confirmationText = orderConfirmationPage.getConfirmationText();

        softAssertions.assertThat(confirmationText)
                .as("Confirmation text is not equals expected")
                .isEqualTo("YOUR ORDER IS CONFIRMED");

        BigDecimal confirmationSubtotal = orderConfirmationPage.getConfirmationSubtotal();
        BigDecimal confirmationShipping = orderConfirmationPage.getConfirmationShipping();
        BigDecimal confirmationTotal = orderConfirmationPage.getConfirmationTotal();

        softAssertions.assertThat(confirmationTotal)
                .as("Confirmation page total value is not equals expected.")
                .isEqualTo(confirmationSubtotal.add(confirmationShipping));

        softAssertions.assertAll();
    }
}