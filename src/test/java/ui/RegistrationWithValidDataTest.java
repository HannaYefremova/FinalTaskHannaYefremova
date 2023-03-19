package ui;

import framework.enums.Genders;
import framework.helpers.StringHelpers;
import framework.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegistrationWithValidDataTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkLanguagesDropdown() {
        String firstName = StringHelpers.generateValidFirstName();
        String lastName = StringHelpers.generateValidLastName();
        String accountName = mainPage.getHeaderPage()
                .clickSignInButton()
                .clickCreateAccountLink()
                .setGender(Genders.MR)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(StringHelpers.generateValidEmail())
                .setPassword(StringHelpers.generateValidPassword())
                .setBirthday(StringHelpers.generaValidBirthdate())
                .checkCustomerPrivacy()
                .checkAgree()
                .clickSaveButton()
                .getHeaderPage()
                .getAccountName();

        Assertions.assertThat(accountName)
                .as("Account name is not equals than entered name on registration")
                .isEqualTo(firstName + " " + lastName);
    }
}