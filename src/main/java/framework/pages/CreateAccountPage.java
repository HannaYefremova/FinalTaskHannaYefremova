package framework.pages;

import framework.enums.Genders;
import framework.helpers.Helpers;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class CreateAccountPage extends BasePage {
    private static final By genderMrRadioButtonLocator = By.xpath("//input[@id='field-id_gender-1']");
    private static final By genderMrsRadioButtonLocator = By.xpath("//input[@id='field-id_gender-2']");
    private static final By firstNameInputLocator = By.xpath("//input[@id='field-firstname']");
    private static final By lastNameInputLocator = By.xpath("//input[@id='field-lastname']");
    private static final By emailInputLocator = By.xpath("//input[@id='field-email']");
    private static final By passwordInputLocator = By.xpath("//input[@id='field-password']");
    private static final By birthdayInputLocator = By.xpath("//input[@id='field-birthday']");
    private static final By customerPrivacyCheckBoxLocator = By.xpath("//input[@name='customer_privacy']");
    private static final By agreeCheckBoxLocator = By.xpath("//input[@name='psgdpr']");
    private static final By submitButtonLocator = By.xpath("//button[@type='submit']");
    private static final By invalidNamePopUpLocator = By.xpath("//li[@class='alert alert-danger']");

    @Step("Set gender")
    public CreateAccountPage setGender(Genders gender) {
        switch (gender) {
            case MR:
                log.info("Set gender radio button to 'mr'.");
                find(genderMrRadioButtonLocator).click();
                break;
            case MRS:
                log.info("Set gender radio button to 'mrs'.");
                find(genderMrsRadioButtonLocator).click();
                break;
        }
        return this;
    }

    @Step("Set valid first name")
    public CreateAccountPage setFirstName(String firstName) {
        log.info("Set valid first name");
        find(firstNameInputLocator).sendKeys(firstName);
        return this;
    }

    @Step("Set valid last name")
    public CreateAccountPage setLastName(String lastName) {
        log.info("Set valid last name");
        find(lastNameInputLocator).sendKeys(lastName);
        return this;
    }

    @Step("Set valid email")
    public CreateAccountPage setEmail(String email) {
        log.info("Set valid email");
        find(emailInputLocator).sendKeys(email);
        return this;
    }

    @Step("Set valid Password")
    public CreateAccountPage setPassword(String password) {
        log.info("Set valid Password");
        find(passwordInputLocator).sendKeys(password);
        return this;
    }

    @Step("Set valid Birthday in format DD/MM/YYYY")
    public CreateAccountPage setBirthday(String birthday) {
        log.info("Set valid Birthday in format DD/MM/YYYY");
        find(birthdayInputLocator).sendKeys(birthday);
        return this;
    }

    @Step("Click to the Customer Privacy checkbox")
    public CreateAccountPage checkCustomerPrivacy() {
        log.info("Click to the Customer Privacy checkbox");
        find(customerPrivacyCheckBoxLocator).click();
        return this;
    }

    @Step("Click to the Agree checkbox")
    public CreateAccountPage checkAgree() {
        log.info("Click to the Agree checkbox");
        find(agreeCheckBoxLocator).click();
        return this;
    }

    @Step("Click on the 'Save' button")
    public MainPage clickSaveButton() {
        log.info("Click on the 'Save' button");
        find(submitButtonLocator).click();
        return new MainPage();
    }

    public String getFirstNameOutlineColorValue() {
        String value = find(firstNameInputLocator).getCssValue("outline")
                .replaceAll("^.*?\\((.*?)\\).*$", "$1");
        String[] numbersAsString = value.split(",");
        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i].trim());
        }
        return Helpers.rgbToHex(numbers[0], numbers[1], numbers[2]);
    }

    public String getNameErrorPopupText() {
        return find(invalidNamePopUpLocator).getText();
    }
}