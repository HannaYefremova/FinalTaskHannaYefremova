package ui;

import framework.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SubscribeWithInvalidEmailTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void checkFooterLabels() {
        //Get label text near the email field
        String newLetterLabelText = mainPage.getNewLetterLabelText();

        SoftAssertions softAssertions = new SoftAssertions();
        //Check label text near the email field
        softAssertions.assertThat(newLetterLabelText)
                .as("New Letter Label text is not valid.")
                .isEqualTo("Get our latest news and special sales");

        //Get label text under the email field
        String underEmailText = mainPage.getUnderEmailText();

        //Check label text under the email field
        softAssertions.assertThat(underEmailText)
                .as("Text under email field is not valid.")
                .contains("You may unsubscribe at any moment. For that purpose, please find my contact info " +
                        "in the legal notice.");

        //Get Subscribe button element text
        WebElement subscribeButton = mainPage.getSubscribeButton();
        String subscribeButtonText = mainPage.getAttributeValue(subscribeButton, "value");
        String subscribeButtonTextStyle = mainPage.getCssStyleValue(subscribeButton, "text-transform");

        //Check text on the 'SUBSCRIBE' button
        softAssertions.assertThat(subscribeButtonText)
                .as("Subscribe text is not equals expected.")
                .isEqualTo("Subscribe");

        //Check text on the 'SUBSCRIBE' button is uppercase
        softAssertions.assertThat(subscribeButtonTextStyle)
                .as("Subscribe text on the button is not upper case.")
                .isEqualTo("uppercase");

        softAssertions.assertAll();
    }
}