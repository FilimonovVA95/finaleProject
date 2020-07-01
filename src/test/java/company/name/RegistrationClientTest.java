package company.name;

import company.name.pages.OneOffMailPageThroughRequests;
import company.name.pages.RegistrationClient;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.step;

/**
 *
 * @author
 */
public class RegistrationClientTest {

    String name = "Name";
    String position = "Position";
    String company = "Company";
    String phone = "+7 999 435-34-44";
    String siteTest = "https://test.uxcrowd.ru/";
    String emailTest = OneOffMailPageThroughRequests.getNewEmail();
    int timeWait = 5000;

    WebDriver driver = DriverManager.getDriver();
    RegistrationClient registrationClient = new RegistrationClient(driver);
    String passwordTest;

    public RegistrationClientTest() throws IOException {
    }

    @Test
    public void createTestClient() throws IOException{
        openTestStand();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(registrationClient.getLoginButton().isEnabled(), "\"Login\" button not active");
        });
        openPopUpStep();
        new WebDriverWait(driver, timeWait).withMessage("Click register exception")
                .until((d) -> registrationClient.getStartRegistrationButton().isDisplayed());
        step("Проверяем активность кнопки \"Забыли пароль\"", () -> {
            Assert.assertTrue(registrationClient.getForgotPassword().isEnabled(), "The \"Forgot Password\" button is inactive");
        });
        clickRegistrationStep();
        step("Проверяем активность кнопки \"Стать клиентом\"", () -> {
            Assert.assertTrue(registrationClient.getNewRegistrationClientButton().isEnabled(),"The \"Become a customer\" button is inactive");
        });
        clickRegistrationClientStep();
        step("Проверяем активность кнопки \"Зарегистрироватся\"", () -> {
            Assert.assertTrue(registrationClient.getRegistrationClientOnFieldRegistration().isEnabled(), "\"Register\" button is not active");
        });
        inputPersonNameStep();
        step("Поле заполненно именем", () -> {
            Assert.assertTrue(registrationClient.getRegistrationNameField().getAttribute("value").equals(name), "\"Name\" field is empty");
        });
        inputPositionStep();
        step("Поле заполненно должностью", () -> {
            Assert.assertTrue(registrationClient.getRegistrationPositionField().getAttribute("value").equals(position), "The field \"Position\" is not filled");
        });
        inputCompanyNameStep();
        step("Поле заполненно компанией", () -> {
            Assert.assertTrue(registrationClient.getRegistrationCompanyField().getAttribute("value").equals(company), "Field \"Company\" is not filled");
        });
        inputEmailStep();
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationClient.getRegistrationEmailField().getAttribute("value").equals(emailTest), "\"Mail\" field is empty");
        });
        inputPhoneStep();
        step("Поле заполненно номером", () -> {
            Assert.assertTrue(registrationClient.getRegistrationPhoneNumberField().getAttribute("value").equals(phone), "\"Number\" field is empty");
        });
        inputSiteStep();
        step("Поле заполненно ссылкой", ()-> {
            Assert.assertTrue(registrationClient.getRegistrationSiteField().getAttribute("value").equals(siteTest), "The \"link to the site\" field is empty");
        });
        clickFinishRegistrationStep();
        step("Элемент \"галочка\" активна");
        Assert.assertTrue(registrationClient.getCheck().isEnabled(), "\"Checkmark\" not active");
        loginButtonClickStep();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step("Проверяем активность кнопки \"Зарегистрироватся\"", () -> {
            Assert.assertTrue(registrationClient.getStartRegistrationButton().isEnabled(), "\"Register\" button is not active");
        });
        loginFieldStep();
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationClient.getLoginFiled().getAttribute("value").equals(emailTest), "\"Mail\" field is empty");
        });
        passwordFieldStep();
        step("Поле заполненно паролем", () -> {
            Assert.assertTrue(registrationClient.getPasswordField().getAttribute("value").equals(passwordTest), "\"Password\" field is empty");
        });
        inButtonStep();
        step("Проверяем активность кнопки \"Выйти\"", () -> {
            Assert.assertTrue(registrationClient.getLogout().isEnabled(), "\"Login\" button not active");
        });
        logOutStep();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(registrationClient.getLoginButton().isEnabled(), "\"Logout\" button not active");
        });
    }

    @Step("Открыть тестовый стенд")
    private void openTestStand(){
        registrationClient.openTestStand();
    }

    @Step("Нажать кнопку \"Войти\"")
    private void openPopUpStep(){
        registrationClient.openPopUp();
    }

    @Step("Нажать кнопку \"Зарегистрироватся\"")
    private void clickRegistrationStep(){
        registrationClient.clickRegistration();
    }

    @Step("Нажать кнопку \"Стать клиентом\"")
    private void clickRegistrationClientStep(){
        registrationClient.clickRegistrationClient();
    }

    @Step("Ввести в поле \"Ваше имя\" имя")
    private void inputPersonNameStep(){
        registrationClient.inputPersonName(name);
    }

    @Step ("Ввести в поле \"Должность\" должность")
    private void inputPositionStep(){
        registrationClient.inputPosition(position);
    }

    @Step("Ввести в поле \"Компания\" компанию")
    private void inputCompanyNameStep(){
        registrationClient.inputCompanyName(company);
    }

    @Step("Ввести в поле \"Почта\" почту")
    private void inputEmailStep(){
        registrationClient.inputEmail(emailTest);
    }

    @Step("Ввести в поле \"Номер\" номер")
    private void inputPhoneStep(){
        registrationClient.inputPhone(phone);
    }

    @Step ("Ввести в поле \"Ссылка на сайт\"")
    private void inputSiteStep(){
        registrationClient.inputSite(siteTest);
    }

    @Step ("Нажать кнопку \"Зарегистрироватся\"")
    private void clickFinishRegistrationStep(){
        registrationClient.clickFinishRegistration();
    }

    @Step("Нажать кнопку \"Войти\"")
    private void loginButtonClickStep(){
        registrationClient.getLoginButton().click();
    }

    @Step("Ввести в поле \"Почта\" почту")
    private void loginFieldStep(){
        registrationClient.getLoginFiled().sendKeys(emailTest);
    }

    @Step("Ввести в поле \"Пароль\" пароль")
    private void passwordFieldStep(){
        registrationClient.getPasswordField().sendKeys(passwordTest);
    }

    @Step("Нажать кнопку \"Войти\"")
    private void inButtonStep(){
        registrationClient.getInButton().click();
    }

    @Step("Нажать кнопку \"Выйти\"")
    private void logOutStep(){
        registrationClient.logOut();
    }

}
