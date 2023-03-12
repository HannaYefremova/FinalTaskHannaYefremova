package UI;

import Framework.Components.LanguageComponent;
import Framework.Helpers.HeaderHelpers;
import Framework.Listeners.TestListeners;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;

@Listeners(TestListeners.class)
public class LanguagesTest extends BaseTest {

    @Test
    public void checkLanguagesDropdown() {
        HeaderHelpers.ClickOnLanguages();
        List<LanguageComponent> languageComponents = HeaderHelpers.getAllLanguages();
        int languageCount = languageComponents.size();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(languageCount)
                .as("The count of language is different than  ")
                .isEqualTo(44);

        List<String> languageNames = HeaderHelpers.getLanguageNames(languageComponents);

        softAssertions.assertThat(languageNames)
                .as(" Language Українська is not exist in languages dropdown")
                .contains("Українська");

        softAssertions.assertAll();

    }
}
