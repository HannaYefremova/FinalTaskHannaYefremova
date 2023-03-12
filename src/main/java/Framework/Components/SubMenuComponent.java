package Framework.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


public class SubMenuComponent {
    public final By subMenuValueLocator = By.xpath(".//li[@class='category']/a");
    private List<WebElement> subMenuElements;

    public SubMenuComponent(WebElement webElement) {
        this.subMenuElements = webElement.findElements(subMenuValueLocator);
    }

    public List<String> getSubMenuNames() {
        List<String> list = new ArrayList<>();
        for (WebElement element : subMenuElements) {
            list.add(element.getText());
        }
        return list;
    }

}
