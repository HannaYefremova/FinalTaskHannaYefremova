package UI;

import Framework.Helpers.StringHelpers;
import Framework.Listeners.TestListeners;
import Framework.Pages.CreateAccountPage;
import Framework.Pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class RegistrationWithInvalidDataTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkLanguagesDropdown() {
        String firstName = StringHelpers.generateValidFirstName();

        CreateAccountPage createAccountPage = mainPage.headerPage.clickSignInButton()
                .clickCreateAccountLink()
                .setGender()
                .setFirstName("James8")
                .setLastName()
                .setEmail()
                .setPassword()
                .setBirthday()
                .checkCustomerPrivacy()
                .checkAgree();

        createAccountPage.clickSaveButton();
        String outlineValue = createAccountPage.getFirstNameOutlineValue();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(outlineValue)
                .as("Higlight color is not equals as expected")
                .contains("rgb(255, 0, 0)");
        String errorPopupValue = createAccountPage.getNameErrorPopupText();
        softAssertions.assertThat(errorPopupValue)
                .as("Error text is not equals")
                .isEqualTo("Invalid name");
        softAssertions.assertAll();

    }
}
