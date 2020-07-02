package company.name;

import company.name.pages.Authentication;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.qameta.allure.Allure.step;

/**
 * Тест проверяет возможность войти с заданными логином и паролем
 * @author Aleksander Dmitriev
 */
public class AuthenticationClient {

    private String email = "kicoti9729@kartk5.com";  // Почта заранее зарагестрированного пользователя
    private String password = "QlwS1Z";  // Пароль от личного кабинета клиента

    private WebDriver driver = DriverManager.getDriver();
    private Authentication authentication = new Authentication(driver);

    @Test
    public void AutentificationClient() {
        openTestStand();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(authentication.getLoginButton().isEnabled(), "Open test stand exception");
        });

        openPopUpStep();
        step("Проверяем открытие окна авторизации", () -> {
            Assert.assertTrue(authentication.getClickLogIn().isEnabled(), "Open popUp exception");
        });

        inputEmailStep(email);
        step("Проверяем правильность ввода email", () -> {
            Assert.assertTrue(authentication.getLoginFiled().getAttribute("value").equals(email), "Input email exception");
        });

        inputPasswordStep(password);
        step("Проверяем правильность ввода пароля", () -> {
            Assert.assertTrue(authentication.getPasswordField().getAttribute("value").equals(password), "Input password exception");
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
}
