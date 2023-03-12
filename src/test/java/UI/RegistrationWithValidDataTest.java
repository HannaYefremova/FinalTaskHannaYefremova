package UI;

import Framework.Helpers.StringHelpers;
import Framework.Listeners.TestListeners;
import Framework.Pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class RegistrationWithValidDataTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkLanguagesDropdown() {
        String firstName = StringHelpers.generateValidFirstName();
        String lastName = StringHelpers.generateValidLastName();
        String accountName = mainPage.headerPage.clickSignInButton()
                .clickCreateAccountLink()
                .setGender()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail()
                .setPassword()
                .setBirthday()
                .checkCustomerPrivacy()
                .checkAgree()
                .clickSaveButton()
                .headerPage.getAccountName();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(accountName)
                .as("Account name is not equals than entered name on registration")
                .isEqualTo(firstName + " " + lastName);
        softAssertions.assertAll();

    }
}
