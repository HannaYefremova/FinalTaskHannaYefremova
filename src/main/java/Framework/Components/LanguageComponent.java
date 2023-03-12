package Framework.Components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public class LanguageComponent {
    private final String languageName;


    public LanguageComponent(WebElement container) {
        this.languageName = container.findElement(By.xpath("./a")).getText();
    }

    public String GetName() {
        return languageName;
    }
}
