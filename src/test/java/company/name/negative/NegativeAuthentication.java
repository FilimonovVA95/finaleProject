package company.name.negative;

import company.name.DriverManager;
import company.name.pages.Authentication;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.qameta.allure.Allure.step;

/**
 * Тест проверяет возможность войти с заданными логином и паролем
 * @author Филимонов Виктор
 * @see company.name.pages.Authentication
 */
public class NegativeAuthentication {

    private String correctEmail = "iplctsju16@post-shift.ru";           // Почта заранее зарагестрированного пользователя
    private String correctPassword = "Koafn3";                          // Пароль от личного кабинета клиента

    private String noCorrectEmail1 = "iplctsju16post-shift.ru";         // Некорректный email, забыли @
    private String noCorrectEmail2 = "noCorrectEmail@post-shift.ru";    // Другая почта

    private String noCorrectPassword1 = "Лщфат3";                       // Неправильная раскладка
    private String noCorrectPassword2 = "Ko3shd";                       // Неверный пароль

    private WebDriver driver = DriverManager.getDriver();
    private Authentication authentication = new Authentication(driver);

    @Test
    public void autentificationTester() {
        openTestStand();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(authentication.getLoginButton().isEnabled(), "Open test stand exception");
        });

        openPopUpStep();
        step("Проверяем открытие окна авторизации", () -> {
            Assert.assertTrue(authentication.getClickLogIn().isEnabled(), "Open popUp exception");
        });

        inputEmailStep(correctEmail);
        step("Проверяем правильность ввода email", () -> {
            Assert.assertTrue(authentication.getLoginFiled().getAttribute("value").equals(correctEmail), "Input email exception");
        });

        clickAuthenticationStep();
        step("Проверяем наличие ошибки о некорректности введенных данных. Пустой пароль", () -> {
            Assert.assertTrue(authentication.getInCorrectEmailOrPasswordNull().getText()
                    .equals("Введите пароль"), "Error expected null password");
        });

        inputPasswordStep(noCorrectPassword1);
        step("Проверяем правильность ввода пароля", () -> {
            Assert.assertTrue(authentication.getPasswordField().getAttribute("value").equals(noCorrectPassword1), "Input password exception");
        });

        clickAuthenticationStep();
        step("Проверяем наличие ошибки о некорректности введенных данных. Вводим некорректный пароль(кирилица)", () -> {
            Assert.assertTrue(authentication.getInCorrectEmailOrPasswordError().getText()
                    .equals("Неверная почта или пароль"), "Error expected no correct password");
        });

        clearField(authentication.getPasswordField());

        inputPasswordStep(noCorrectPassword2);
        step("Проверяем правильность ввода пароля", () -> {
            Assert.assertTrue(authentication.getPasswordField().getAttribute("value").equals(noCorrectPassword2), "Input password exception");
        });

        clickAuthenticationStep();
        step("Проверяем наличие ошибки о некорректности введенных данных. Вводим некорректный пароль(неправильный)", () -> {
            Assert.assertTrue(authentication.getInCorrectEmailOrPasswordError().getText()
                    .equals("Неверная почта или пароль"), "Error expected no correct password");
        });

        clearField(authentication.getPasswordField());

        inputPasswordStep(correctPassword);
        step("Проверяем правильность ввода пароля", () -> {
            Assert.assertTrue(authentication.getPasswordField().getAttribute("value")
                    .equals(correctPassword), "Input password exception");
        });

        clearField(authentication.getLoginFiled());

        inputEmailStep(noCorrectEmail1);
        step("Проверяем правильность ввода email", () -> {
            Assert.assertTrue(authentication.getLoginFiled().getAttribute("value").equals(noCorrectEmail1), "Input email exception");
        });

        clickAuthenticationStep();
        step("Проверяем наличие ошибки о некорректности введенных данных. Вводим некорректный email(забыли@)", () -> {
            Assert.assertTrue(authentication.getInCorrectEmailOrPasswordError().getText()
                    .equals("Неверная почта или пароль"), "Error expected no correct email");
        });

        clearField(authentication.getLoginFiled());

        inputEmailStep(noCorrectEmail2);
        step("Проверяем правильность ввода email", () -> {
            Assert.assertTrue(authentication.getLoginFiled().getAttribute("value").equals(noCorrectEmail2), "Input email exception");
        });

        clickAuthenticationStep();
        step("Проверяем наличие ошибки о некорректности введенных данных. Вводим некорректный email(другой email)", () -> {
            Assert.assertTrue(authentication.getInCorrectEmailOrPasswordError().getText()
                    .equals("Неверная почта или пароль"), "Error expected no correct email");
        });

        clearField(authentication.getLoginFiled());

        clickAuthenticationStep();
        step("Проверяем наличие ошибки о некорректности введенных данных. Пустой email", () -> {
            Assert.assertTrue(authentication.getInCorrectEmailOrPasswordNull().getText()
                    .equals("Введите почту"), "Error expected null email");
        });

        clearField(authentication.getLoginFiled());
        clearField(authentication.getPasswordField());

        inputEmailStep(correctEmail);
        step("Проверяем правильность ввода email", () -> {
            Assert.assertTrue(authentication.getLoginFiled().getAttribute("value").equals(correctEmail), "Input email exception");
        });

        inputPasswordStep(correctPassword);
        step("Проверяем правильность ввода пароля", () -> {
            Assert.assertTrue(authentication.getPasswordField().getAttribute("value").equals(correctPassword), "Input password exception");
        });

        clickAuthenticationStep();
        step("Проверяем активность кнопки \"Выйти\" ", () -> {
            Assert.assertTrue(authentication.getClickLogOut().isEnabled(), "LogIn exception");
        });

        logOutStep();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(authentication.getLoginButton().isEnabled(), "LogOut exception");
        });

        DriverManager.quit();
    }

    @Step("Открыть тестовый стенд")
    private void openTestStand(){
        authentication.openTestStand();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Войти\"")
    private void openPopUpStep(){
        authentication.openPopUp();
        screenShotStep();
    }

    @Step("Ввести e-mail")
    private void inputEmailStep(String email){
        authentication.inputEmail(email);
        screenShotStep();
    }

    @Step("Ввести пароль")
    private void inputPasswordStep(String password){
        authentication.inputPassword(password);
        screenShotStep();
    }

    @Step("Нажать кнопку войти")
    private void clickAuthenticationStep(){
        authentication.clickAuthentication();
        screenShotStep();
    }

    @Step("Нажать кнопку выйти")
    private void logOutStep(){
        authentication.logOut();
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

    private void clearField(WebElement element) {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        element.sendKeys(del);
    }



}