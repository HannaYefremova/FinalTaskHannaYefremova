package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class HeaderPage extends BasePage {
    private static final By signInButtonLocator = By.xpath("//div[@id='_desktop_user_info']//span[@class='hidden-sm-down']");
    private static final By accountNameLocator = By.xpath("//a[@class='account']/span");

    @Step("Click on the 'Sign in' button")
    public LoginPage clickSignInButton() {
        log.info("Click on the 'Sign in' button");
        find(signInButtonLocator).click();
        return new LoginPage();
    }

    @Step("Get Account name")
    public String getAccountName() {
        log.info("Get Account name");
        return find(accountNameLocator).getText();
    }
}