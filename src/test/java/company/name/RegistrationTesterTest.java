package company.name;

import company.name.pages.OneOffMailPageThroughRequests;
import company.name.pages.RegistrationClient;
import company.name.pages.RegistrationTester;
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
 * Класс теста регистрации тестера
 * @see RegistrationClient
 * @see OneOffMailPageThroughRequests
 */
public class RegistrationTesterTest {
    private String emailTest = OneOffMailPageThroughRequests.getNewEmail();

    private WebDriver driver = DriverManager.getDriver();
    private RegistrationTester registrationTester = new RegistrationTester(driver);
    private String passwordTest;

    @Test
    public void registrationTesterTest() {

        openTestStandStep();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(registrationTester.getLoginButton().isEnabled(), "Open test stand exception");
        });

        openPopUpStep();
        step("Проверяем активность кнопки \"Забыли пароль\"", () -> {
            Assert.assertTrue(registrationTester.getForgotPassword().isEnabled(), "The \"Forgot Password\" button is inactive");
        });

        clickRegistrationStep();
        step("Проверяем активность кнопки \"Стать Тестировщиком\"", () -> {
            Assert.assertTrue(registrationTester.getStartRegistrationTesterButton().isEnabled(),"Button registration tester exception");
        });

        clickRegistrationTesterStep();
        step("Проверяем активность кнопки \"Зарегистрироваться\"", () -> {
            Assert.assertTrue(registrationTester.getClickFinishRegistration().isEnabled(),"Click finish registration exception");
        });

        inputEmailStep();
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationTester.getRegistrationEmailField().getAttribute("value").equals(emailTest), "\"Mail\" field is empty");
        });

        clickFinishRegistrationStep();
        step("Элемент \"галочка\" активна", () -> {
            Assert.assertTrue(registrationTester.getCheck().isEnabled(), "\"Checkmark\" not active");
        });

        loginButtonClickStep();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step("Проверяем активность кнопки \"Зарегистрироватся\"", () -> {
            Assert.assertTrue(registrationTester.getStartRegistrationButton().isEnabled(), "\"Register\" button is not active");
        });

        loginFieldStep(emailTest);
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationTester.getLoginFiled().getAttribute("value").equals(emailTest), "\"Mail\" field is empty");
        });

        passwordFieldStep(passwordTest);
        step("Поле заполненно паролем", () -> {
            Assert.assertTrue(registrationTester.getPasswordField().getAttribute("value").equals(passwordTest), "\"Password\" field is empty");
        });

        inButtonStep();
        step("Проверяем активность кнопки \"Выйти\"", () -> {
            Assert.assertTrue(registrationTester.getClickLogOut().isEnabled(), "\"Login\" button not active");
        });

        logOutStep();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(registrationTester.getLoginButton().isEnabled(), "\"Logout\" button not active");
        });

        OneOffMailPageThroughRequests.deleteEmail();
        DriverManager.quit();
    }

    @Step("Открыть тестовый стенд")
    private void openTestStandStep() {
        registrationTester.openTestStand();
        screenShotStep();
    }

    @Step("Открыть окно авторизации")
    public void openPopUpStep(){
        registrationTester.openPopUp();
        screenShotStep();
    }

    @Step("Открыть окно регистрации")
    public void clickRegistrationStep(){
        registrationTester.clickRegistration();
        screenShotStep();
    }

    @Step("Начать регистрацию тестера")
    public void clickRegistrationTesterStep(){
        registrationTester.inputRegistrationTester();
        screenShotStep();
    }

    @Step("Ввести емайл для регистрации")
    public void inputEmailStep(){
        registrationTester.inputEmail(emailTest);
        screenShotStep();
    }

    @Step("Завершить регистрацию")
    public void clickFinishRegistrationStep() {
        registrationTester.clickFinishRegistrationOnFieldRegistration();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Войти\"")
    private void loginButtonClickStep(){
        registrationTester.getLoginButton().click();
        screenShotStep();
    }

    @Step("Ввести в поле \"Почта\" почту")
    private void loginFieldStep(String emailTest){
        registrationTester.inputEmailTester(emailTest);
        screenShotStep();
    }

    @Step("Ввести в поле \"Пароль\" пароль")
    private void passwordFieldStep(String passwordTest){
        registrationTester.inputPasswordTester(passwordTest);
        screenShotStep();
    }

    @Step("Нажать кнопку \"Войти\"")
    private void inButtonStep(){
        registrationTester.logInClick();
        screenShotStep();
    }

    @Step("Выйти из зарегестрированного профиля")
    public void logOutStep(){
        registrationTester.logOut();
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