package UI;

import Framework.Listeners.TestListeners;
import Framework.Pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class SubscribeWithInvalidEmailTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkFooterLabels() {

        //Get label text near the email field
        String newLetterLabelText = mainPage.getNewLetterLabelText();


        SoftAssertions softAssertions = new SoftAssertions();
        //Check label text near the email field
        softAssertions.assertThat(newLetterLabelText)
                .as("No valid new Letter Label text ")
                .isEqualTo("Get our latest news and special sales");

        //Get label text under the email field
        String underEmailText = mainPage.getUnderEmailText();

        //Check label text under the email field
        softAssertions.assertThat(underEmailText)
                .as("No valid under the email field text ")
                .contains("You may unsubscribe at any moment. For that purpose, please find my contact info " +
                        "in the legal notice.");

        //Get Subscribe text
        String subscribeButtonText = mainPage.getSubscribeButtonText();

        //Check that all characters on 'SUBSCRIBE' button in upper case
        softAssertions.assertThat(subscribeButtonText)
                .as("Subscribe text on the button is not upper case ")
                .isUpperCase();

        softAssertions.assertAll();
    }
}
