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
            Assert.assertTrue(registrationClient.getLoginButton().isEnabled());
        });
        openPopUpStep();
        new WebDriverWait(driver, timeWait).withMessage("Click register exception")
                .until((d) -> registrationClient.getStartRegistrationButton().isDisplayed());
        step("Проверяем активность кнопки \"Забыли пароль\"", () -> {
            Assert.assertTrue(registrationClient.getForgotPassword().isEnabled());
        });
        clickRegistrationStep();
        step("Проверяем активность кнопки \"Стать клиентом\"", () -> {
            Assert.assertTrue(registrationClient.getNewRegistrationClientButton().isEnabled());
        });
        clickRegistrationClientStep();
        step("Проверяем активность кнопки \"Зарегистрироватся\"", () -> {
            Assert.assertTrue(registrationClient.getRegistrationClientOnFieldRegistration().isEnabled());
        });
        inputPersonNameStep();
        step("Поле заполненно именем", () -> {
            Assert.assertFalse(registrationClient.getFieldText().equals(name));
        });
        inputPositionStep();
        step("Поле заполненно должностью", () -> {
            Assert.assertFalse(registrationClient.getRegistrationPositionField().getText().equals(position));
        });
        inputCompanyNameStep();
        step("Поле заполненно компанией", () -> {
            Assert.assertFalse(registrationClient.getRegistrationCompanyField().getText().equals(company));
        });
        inputEmailStep();
        step("Поле заполненно почтой", () -> {
            Assert.assertFalse(registrationClient.getRegistrationEmailField().getText().equals(emailTest));
        });
        inputPhoneStep();
        step("Поле заполненно номером", () -> {
            Assert.assertFalse(registrationClient.getRegistrationPhoneNumberField().getText().equals(phone));
        });
        inputSiteStep();
        step("Поле заполненно ссылкой", ()-> {
            Assert.assertFalse(registrationClient.getRegistrationSiteField().getText().equals(siteTest));
        });
        clickFinishRegistrationStep();
        step("Элемент \"галочка\" активна");
        Assert.assertTrue(registrationClient.getCheck().isEnabled());
        loginButtonClickStep();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step("Проверяем активность кнопки \"Зарегистрироватся\"", () -> {
            Assert.assertTrue(registrationClient.getStartRegistrationButton().isEnabled());
        });
        loginFieldStep();
        step("Поле заполненно почтой", () -> {
            Assert.assertFalse(registrationClient.getLoginFiled().getText().equals(emailTest));
        });
        passwordFieldStep();
        step("Поле заполненно паролем", () -> {
            Assert.assertFalse(registrationClient.getPasswordField().getText().equals(passwordTest));
        });
        inButtonStep();
        step("Проверяем активность кнопки \"Выйти\"", () -> {
            Assert.assertTrue(registrationClient.getLogout().isEnabled());
        });
        logOutStep();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(registrationClient.getLoginButton().isEnabled());
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
