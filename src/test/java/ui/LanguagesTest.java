package ui;

import framework.helpers.HeaderHelpers;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

public class LanguagesTest extends BaseTest {

    @Test
    public void checkLanguagesDropdown() {
        HeaderHelpers.ClickOnLanguages();
        List<String> languages = HeaderHelpers.getLanguages();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(languages.size())
                .as("The count of language is different than expected.")
                .isEqualTo(44);

        softAssertions.assertThat(languages)
                .as(" Language Українська is not exist in languages dropdown.")
                .contains("Українська");

        softAssertions.assertAll();
    }
}