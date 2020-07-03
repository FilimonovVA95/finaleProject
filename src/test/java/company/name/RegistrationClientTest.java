package company.name;

import company.name.pages.OneOffMailPageThroughRequests;
import company.name.pages.RegistrationClient;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static io.qameta.allure.Allure.step;

/**
 * Класс теста регистрации клиента
 * @author Akmataliev Almaz
 * @see company.name.pages.RegistrationClient
 * @see OneOffMailPageThroughRequests
 */
public class RegistrationClientTest {

    /**
     * Поля, используемые при регистрации клиента
     */
    private String name = "Name";
    private String position = "Position";
    private String company = "Company";
    private String phone = "+7 999 435-34-44";
    private String siteTest = "https://test.uxcrowd.ru/";
    private String emailTest = OneOffMailPageThroughRequests.getNewEmail();

    private WebDriver driver = DriverManager.getDriver();
    private RegistrationClient registrationClient = new RegistrationClient(driver);
    private String passwordTest;

    @Test
    public void createTestClient(){
        openTestStand();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(registrationClient.getLoginButton().isEnabled(), "\"Login\" button not active");
        });

        openPopUpStep();
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

        openPopUpStep();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step("Проверяем активность кнопки \"Зарегистрироватся\"", () -> {
            Assert.assertTrue(registrationClient.getStartRegistrationButton().isEnabled(), "\"Register\" button is not active");
        });

        loginFieldStep(emailTest);
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationClient.getLoginFiled().getAttribute("value").equals(emailTest), "\"Mail\" field is empty");
        });

        passwordFieldStep(passwordTest);
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

        OneOffMailPageThroughRequests.deleteEmail();
        DriverManager.quit();
    }

    @Step("Открыть тестовый стенд")
    private void openTestStand(){
        registrationClient.openTestStand();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Войти\"")
    private void openPopUpStep(){
        registrationClient.openPopUp();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Зарегистрироватся\"")
    private void clickRegistrationStep(){
        registrationClient.clickRegistration();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Стать клиентом\"")
    private void clickRegistrationClientStep(){
        registrationClient.clickRegistrationClient();
        screenShotStep();
    }

    @Step("Ввести в поле \"Ваше имя\" имя")
    private void inputPersonNameStep(){
        registrationClient.inputPersonName(name);
        screenShotStep();
    }

    @Step ("Ввести в поле \"Должность\" должность")
    private void inputPositionStep(){
        registrationClient.inputPosition(position);
        screenShotStep();
    }

    @Step("Ввести в поле \"Компания\" компанию")
    private void inputCompanyNameStep(){
        registrationClient.inputCompanyName(company);
        screenShotStep();
    }

    @Step("Ввести в поле \"Почта\" почту")
    private void inputEmailStep(){
        registrationClient.inputEmail(emailTest);
        screenShotStep();
    }

    @Step("Ввести в поле \"Номер\" номер")
    private void inputPhoneStep(){
        registrationClient.inputPhone(phone);
        screenShotStep();
    }

    @Step ("Ввести в поле \"Ссылка на сайт\"")
    private void inputSiteStep(){
        registrationClient.inputSite(siteTest);
        screenShotStep();
    }

    @Step ("Нажать кнопку \"Зарегистрироватся\"")
    private void clickFinishRegistrationStep(){
        registrationClient.clickFinishRegistration();
        screenShotStep();
    }

    @Step("Ввести в поле \"Почта\" почту")
    private void loginFieldStep(String emailTest){
        registrationClient.inputEmailClient(emailTest);
        screenShotStep();
    }

    @Step("Ввести в поле \"Пароль\" пароль")
    private void passwordFieldStep(String passwordTest){
        registrationClient.inputPasswordClient(passwordTest);
        screenShotStep();
    }

    @Step("Нажать кнопку \"Войти\"")
    private void inButtonStep(){
        registrationClient.logInClient();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Выйти\"")
    private void logOutStep(){
        registrationClient.logOut();
        screenShotStep();
    }

    /**
     * Метод для получения скриншота и сохранения его в папке screenShots
     */
    private void screenShotStep() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screen = ts.getScreenshotAs(OutputType.FILE);
        String screenName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        try {
            FileUtils.copyFile(screen, new File("./ScreenShots/"+screenName+"_Screenshot.png"));
        } catch (IOException e) {
            System.out.println("Exception while taking ScreenShot "+e.getMessage());
            e.printStackTrace();
        }
    }
}
