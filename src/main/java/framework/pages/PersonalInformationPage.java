package framework.pages;

import framework.enums.Genders;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;

@Log4j2
public class PersonalInformationPage extends BasePage {
    private static final By genderMrRadioButtonLocator = By.xpath("//input[@id='field-id_gender-1']");
    private static final By genderMrsRadioButtonLocator = By.xpath("//input[@id='field-id_gender-2']");
    private static final By firstNameInputLocator = By.xpath("//input[@id='field-firstname']");
    private static final By lastNameInputLocator = By.xpath("//input[@id='field-lastname']");
    private static final By emailInputLocator = By.xpath("//input[@id='field-email']");
    private static final By birthdayInputLocator = By.xpath("//input[@id='field-birthday']");
    private static final By customerPrivacyCheckBoxLocator = By.xpath("//input[@name='customer_privacy']");
    private static final By agreeCheckBoxLocator = By.xpath("//input[@name='psgdpr']");
    private static final By addressInputLocator = By.xpath("//input[@id='field-address1']");
    private static final By zipCodeInputLocator = By.xpath("//input[@id='field-postcode']");
    private static final By cityInputLocator = By.xpath("//input[@id='field-city']");
    private static final By personalInformationContinueButtonLocator = By.xpath("//form[@id='customer-form" +
            "']//button[@type='submit']");
    private static final By deliveryAddressContinueButtonLocator = By.xpath("//div[@id='delivery-address']//button[@type='submit']");
    private static final By shippingMethodContinueButtonLocator = By.xpath("//div[@class='delivery-options-list" +
            "']//button[@type='submit']");
    private static final By myCarrierOptionLocator = By.xpath("//div[@class='delivery-options']//div[@class='row delivery-option js-delivery-option'][2]/div");
    private static final By payByCheckOptionLocator = By.xpath("//input[@id='payment-option-1']");
    private static final By amountLocator = By.xpath("//div[@id='payment-option-1-additional-information']//dd[1]");
    private static final By subTotalLocator = By.xpath("//div[@id='cart-subtotal-products']//span[@class='value']");
    private static final By placeOrderButtonLocator = By.xpath("//div[@id='payment-confirmation']//button");
    private static final By agreeWithTermsCheckboxLocator = By.xpath("//input[@id='conditions_to_approve[terms-and" +
            "-conditions]']");
    private static final By shippingLocator = By.xpath("//div[@id='cart-subtotal-shipping']//span[@class='value" +
            "']");


    @Step("Set gender")
    public PersonalInformationPage setGender(Genders gender) {
        log.info("Set gender radio button");
        switch (gender) {
            case MR:
                find(genderMrRadioButtonLocator).click();
                break;
            case MRS:
                find(genderMrsRadioButtonLocator).click();
                break;
        }
        return this;
    }

    @Step("Set valid first name")
    public PersonalInformationPage setFirstName(String firstName) {
        log.info("Set valid first name");
        find(firstNameInputLocator).sendKeys(firstName);
        return this;
    }

    @Step("Set valid last name")
    public PersonalInformationPage setLastName(String lastName) {
        log.info("Set valid last name");
        find(lastNameInputLocator).sendKeys(lastName);
        return this;
    }

    @Step("Set valid email")
    public PersonalInformationPage setEmail(String email) {
        log.info("Set valid email");
        find(emailInputLocator).sendKeys(email);
        return this;
    }

    @Step("Set valid Birthday in format DD/MM/YYYY")
    public PersonalInformationPage setBirthday(String birthday) {
        log.info("Set valid Birthday in format DD/MM/YYYY");
        find(birthdayInputLocator).sendKeys(birthday);
        return this;
    }

    @Step("Click to the Customer Privacy checkbox")
    public PersonalInformationPage checkCustomerPrivacy() {
        log.info("Click to the Customer Privacy checkbox");
        find(customerPrivacyCheckBoxLocator).click();
        return this;
    }

    @Step("Click to the Agree checkbox")
    public PersonalInformationPage checkAgree() {
        log.info("Click to the Agree checkbox");
        find(agreeCheckBoxLocator).click();
        return this;
    }

    @Step("Click on the 'Save' button")
    public PersonalInformationPage clickPersonalInformationContinueButton() {
        log.info("Click on the 'Continue' button");
        find(personalInformationContinueButtonLocator).click();
        return this;
    }

    @Step("Set address")
    public PersonalInformationPage setAddress(String address) {
        log.info("Set address");
        find(addressInputLocator).sendKeys(address);
        return this;
    }

    @Step("Set postal code")
    public PersonalInformationPage setPostalCode(String postalCode) {
        log.info("Set postal code");
        find(zipCodeInputLocator).sendKeys(postalCode);
        return this;
    }

    @Step("Set city")
    public PersonalInformationPage setCity(String city) {
        log.info("Set city");
        find(cityInputLocator).sendKeys(city);
        return this;
    }

    @Step("Click on the 'Continue' button")
    public PersonalInformationPage clickAddressContinueButton() {
        log.info("Click on the 'Continue' button");
        find(deliveryAddressContinueButtonLocator).click();
        return this;
    }

    @Step("Click on the 'My carrier' option button")
    public PersonalInformationPage clickMyCarrierOptionButton() {
        log.info("Click on the 'My carrier' option button");
        BasePage.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(myCarrierOptionLocator));
        find(myCarrierOptionLocator).click();
        return this;
    }

    @Step("Click on the 'Continue' button")
    public PersonalInformationPage clickDeliveryContinueButton() {
        log.info("Click on the 'Continue' button");
        find(shippingMethodContinueButtonLocator).click();
        return this;
    }

    @Step("Click on the 'Pay by check' option")
    public PersonalInformationPage clickPayByCheckOption() {
        log.info("Click on the 'Pay by check' option");
        find(payByCheckOptionLocator).click();
        return this;
    }

    @Step("Check agree checkbox")
    public PersonalInformationPage checkAgreeCheckbox() {
        log.info("Check agree checkbox");
        find(agreeWithTermsCheckboxLocator).click();
        return this;
    }

    @Step("Click place order button")
    public OrderConfirmationPage clickPlaceOrderButton() {
        log.info("Click place order button");
        find(placeOrderButtonLocator).click();
        return new OrderConfirmationPage();
    }

    public BigDecimal getPaymentAmount() {
        return new BigDecimal(find(amountLocator).getText().replace(" (tax incl.)", "").trim().substring(1));
    }

    public BigDecimal getSubtotal() {
        return new BigDecimal(find(subTotalLocator).getText().substring(1));
    }

    public BigDecimal getShipping() {
        return new BigDecimal(find(shippingLocator).getText().substring(1));
    }
}