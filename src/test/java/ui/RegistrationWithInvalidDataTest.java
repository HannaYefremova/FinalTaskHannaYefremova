package ui;

import framework.enums.Genders;
import framework.helpers.StringHelpers;
import framework.pages.CreateAccountPage;
import framework.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class RegistrationWithInvalidDataTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkLanguagesDropdown() {
        CreateAccountPage createAccountPage = mainPage.getHeaderPage()
                .clickSignInButton()
                .clickCreateAccountLink()
                .setGender(Genders.MR)
                .setFirstName("James8")
                .setLastName(StringHelpers.generateValidLastName())
                .setEmail(StringHelpers.generateValidEmail())
                .setPassword(StringHelpers.generateValidPassword())
                .setBirthday(StringHelpers.generaValidBirthdate())
                .checkCustomerPrivacy()
                .checkAgree();

        createAccountPage.clickSaveButton();
        String outlineValue = createAccountPage.getFirstNameOutlineColorValue();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(outlineValue)
                .as("Highlight color is not equals as expected")
                .isEqualTo("#ff4c4c");
        String errorPopupValue = createAccountPage.getNameErrorPopupText();
        softAssertions.assertThat(errorPopupValue)
                .as("Error text is not equals")
                .isEqualTo("Invalid format.");
        softAssertions.assertAll();
    }
}