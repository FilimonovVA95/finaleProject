package company.name;

import company.name.pages.Authentication;
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
 * данный тест проверяет возможность войти с заданными логином и паролем
 * @Author Aleksander Dmitriev
 */
public class AuthenticationClient {

    String email = "";//ввести логин
    String password = "";//ввести пароль

    WebDriver driver = DriverManager.getDriver();
    Authentication authentication = new Authentication(driver);

    @Test
    public void AutentificationClient() throws IOException{
        openTestStandStep();

        screenShotStep()
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(Authentication.getLoginButton().isEnabled(), "Open test stand exception");
        });
        openPopUpStep();

        screenShotStep()
        step("Проверяем активность поля ввода e-mail", () -> {
            Assert.assertTrue(Authentication.getLoginFiled().isEnabled(), "Нет поля ввода e-mail");
        });
        inputEmailStep(email);

        screenShotStep()
        step("Проверяем активность поля ввода пароля", () -> {
            Assert.assertTrue(Authentication.getPasswordField().isEnabled(), "Нет поля ввода пароля");
        });
        inputPasswordStep(password);

        screenShotStep()
        step("Проверяем активность кнопки \"Войти\" ", () -> {
            Assert.assertTrue(Authentication.getClickLogIn().isEnabled(), "Нет кнопки \"Войти\"");
        });
        clickAuthenticationStep();

        screenShotStep()
        step("Проверяем активность кнопки \"Выйти\" ", () -> {
            Assert.assertTrue(Authentication.getClickLogOut().isEnabled(), "Нет кнопки \"Выйти\"");
        });
        logOutStep();

        screenShotStep()
    }

    @Step("Открыть тестовый стенд")
    private void openTestStand(){
        Authentication.openTestStand();
    }

    @Step("Нажать кнопку \"Войти\"")
    private void openPopUpStep(){
        Authentication.openPopUp();
    }

    @Step("Ввести e-mail")
    private void inputEmailStep(String email){
        Authentication.inputEmail(email);
    }

    @Step("Ввести пароль")
    private void inputPasswordStep(String password){
        Authentication.inputPassword(password);
    }

    @Step("Нажать кнопку войти")
    private void clickAuthenticationStep(){
        Authentication.clickAuthentication();
    }

    @Step("Нажать кнопку выйти")
    private void logOutStep(){
        Authentication.logOut();
    }

    private void screenShotStep() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screen = ts.getScreenshotAs(OutputType.FILE);
        String screenName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
        try {
            FileUtils.copyFile(screen, new File("./ScreenShots/"+screenName+"Screenshot.png"));
        } catch (IOException e) {
            System.out.println("Exception while taking ScreenShot "+e.getMessage());
            e.printStackTrace();
        }
    }
}
