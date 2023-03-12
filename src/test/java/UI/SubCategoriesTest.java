package UI;

import Framework.Listeners.TestListeners;
import Framework.Pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

@Listeners(TestListeners.class)
public class SubCategoriesTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    public void checkSubCategoriesTest() {
        //check clothes sub menu
        mainPage.hoverOverByClothesMenu();
        WebElement clothesSubMenu = mainPage.getClothesSubMenu();
        String cssValueClothesSubMenu = clothesSubMenu.getCssValue("visibility");

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(cssValueClothesSubMenu)
                .as("CSS style visibility not equals expected")
                .isEqualTo("visible");

        List<String> clothesSubMenuExceptedNames = Arrays.asList("MEN", "WOMEN");
        List<String> clothesSubMenuNames = MainPage.getSubMenuNames(clothesSubMenu);

        softAssertions.assertThat(clothesSubMenuExceptedNames)
                .as("Clothes sub menu names is not equals expected list")
                .containsExactlyElementsOf(clothesSubMenuNames);

        //check accessories sub menu
        mainPage.hoverOverByAccessoriesMenu();
        WebElement accessoriesSubMenu = mainPage.getAccessoriesSubMenu();
        String cssValueAccessoriesSubMenu = accessoriesSubMenu.getCssValue("visibility");

        softAssertions.assertThat(cssValueAccessoriesSubMenu)
                .as("CSS style visibility not equals expected")
                .isEqualTo("visible");

        List<String> accessoriesSubMenuExceptedNames = Arrays.asList("STATIONERY", "HOME ACCESSORIES");
        List<String> accessoriesSubMenuNames = MainPage.getSubMenuNames(accessoriesSubMenu);

        softAssertions.assertThat(accessoriesSubMenuExceptedNames)
                .as("Accessories sub menu names is not equals expected list")
                .containsExactlyElementsOf(accessoriesSubMenuNames);

        //check art sub menu
        mainPage.hoverOverByArtMenu();
        boolean isArtSubMenuExist = mainPage.checkArtSubMenuForVisible();

        softAssertions.assertThat(isArtSubMenuExist)
                .as("Art sub menu visible is not excepted")
                .isEqualTo(false);

        softAssertions.assertAll();
    }
}
