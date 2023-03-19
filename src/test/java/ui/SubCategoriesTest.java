package ui;

import framework.enums.MenuItems;
import framework.enums.SubMenuItems;
import framework.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SubCategoriesTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    public void checkSubCategoriesTest() {
        //check clothes sub menu
        mainPage.getMenuComponent().hoverOver(MenuItems.CLOTHES);
        WebElement clothesSubMenu = mainPage.getMenuComponent().getSubMenu(MenuItems.CLOTHES);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(clothesSubMenu.isDisplayed())
                .as("Clothes subMenu is not visible.");

        List<String> clothesSubMenuExceptedNames = Arrays.asList(
                SubMenuItems.MEN.getValueName(),
                SubMenuItems.WOMEN.getValueName()
        );
        List<String> clothesSubMenuNames = mainPage.getMenuComponent().getSubMenuNames();

        softAssertions.assertThat(clothesSubMenuExceptedNames)
                .as("Clothes sub menu names is not equals expected list.")
                .containsExactlyElementsOf(clothesSubMenuNames);

        //check accessories sub menu
        mainPage.getMenuComponent().hoverOver(MenuItems.ACCESSORIES);
        WebElement accessoriesSubMenu = mainPage.getMenuComponent().getSubMenu(MenuItems.ACCESSORIES);

        softAssertions.assertThat(accessoriesSubMenu.isDisplayed())
                .as("Accessories subMenu is not visible.");

        List<String> accessoriesSubMenuExceptedNames = Arrays.asList(
                SubMenuItems.STATIONERY.getValueName(),
                SubMenuItems.HOMEACCESSORIES.getValueName()
        );
        List<String> accessoriesSubMenuNames = mainPage.getMenuComponent().getSubMenuNames();

        softAssertions.assertThat(accessoriesSubMenuExceptedNames)
                .as("Accessories sub menu names is not equals expected list")
                .containsExactlyElementsOf(accessoriesSubMenuNames);

        //check art sub menu
        mainPage.getMenuComponent().hoverOver(MenuItems.ART);
        boolean isArtSubMenuExist = mainPage.getMenuComponent().isArtSubMenuVisible();

        softAssertions.assertThat(!isArtSubMenuExist)
                .as("Art sub menu visible, and it is not excepted");

        softAssertions.assertAll();
    }
}
