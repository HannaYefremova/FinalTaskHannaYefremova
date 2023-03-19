package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class LoginPage extends BasePage {
    private static final By noAccountCreateOneHereLinkLocator = By.xpath("//div[@class='no-account']/a");

    @Step("Click on the 'No account? Create one here' link")
    public CreateAccountPage clickCreateAccountLink() {
        log.info("Click on the 'Create Account' Link");
        find(noAccountCreateOneHereLinkLocator).click();
        return new CreateAccountPage();
    }
}