package Framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ProductsPage extends BasePage {
    private final By sortByDropdownLocator = By.xpath("//button[@class='btn-unstyle select-title']");
    private final By sortByDropdownItemsLocator = By.xpath("//div[@class='dropdown-menu']/a");

    public ProductsPage clickOnSortBy() {
        find(sortByDropdownLocator).click();
        return this;
    }

    public ProductsPage clickOnDropdownItemByName(String name) {
        List<WebElement> dropDownItems = findAll(sortByDropdownItemsLocator);
        WebElement dropDown = find(sortByDropdownLocator);

        for (WebElement e : dropDownItems) {
            if (e.getText().equals(name)) {
                e.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='spinner']")));
                return this;
            }
        }
        return this;
    }
}
