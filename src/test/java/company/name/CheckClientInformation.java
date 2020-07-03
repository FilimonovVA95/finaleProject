package company.name;

import company.name.pages.ClientPersonalAccountPage;
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
 * Класс теста проверки информации о клиенте
 * @see company.name.pages.ClientPersonalAccountPage
 * @author Филимонов Виктор
 */
public class CheckClientInformation {

    /**
     * Поля вебдрайвера и ресурса, который тестируем
     */
    private WebDriver driver = DriverManager.getDriver();
    private ClientPersonalAccountPage clientPersonalAccountPage  = new ClientPersonalAccountPage(driver);

    /**
     * Тест, тестирует возможность заказать тестирование своего сайта
     */
    @Test
    public void checkClientInfo() {

        openTestStandStep();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue( clientPersonalAccountPage.getLoginButton().isEnabled(), "Open test stand exception");
        });

        logInStep();
        step("Проверяем активность кнопки \"Выйти\"", () -> {
            Assert.assertTrue( clientPersonalAccountPage.getExitButton().isEnabled(), "Log In exception");
        });

        profileInfoInStep();
        step("Проверяем активность кнопки \"Изменить пароль\"", () -> {
            Assert.assertTrue( clientPersonalAccountPage.getChangePasswordButton().isEnabled(), "Passed to profile exception");
        });

        step("Проверяем данные в поле логин", () -> {
            Assert.assertTrue( checkLoginStep(), "Login display exception");
        });

        step("Проверяем данные в поле email", () -> {
            Assert.assertTrue( checkEmailStep(), "Email display exception");
        });

        step("Проверяем данные в поле ФИО", () -> {
            Assert.assertTrue( checkFIOStep(), "Full name display exception");
        });

        logOutStep();

        step("Проверяем активность кнопки \"Вход\"", () -> {
            Assert.assertTrue( clientPersonalAccountPage.getLoginButton().isEnabled(), "Logout exception");
        });

        DriverManager.quit();
    }

    @Step("Открыть тестовый стенд")
    private void openTestStandStep() {
        clientPersonalAccountPage.openTestStand();
        screenShotStep();
    }

    @Step("Войти в личный кабинет клиента")
    private void logInStep() {
        clientPersonalAccountPage.logIn();
        screenShotStep();
    }

    @Step("Войти в профиль клиента")
    private void profileInfoInStep() {
        clientPersonalAccountPage.profileInfoIn();
        screenShotStep();
    }

    @Step("Проверить логин клиента")
    private boolean checkLoginStep() {
        return clientPersonalAccountPage.checkLogin();
    }

    @Step("Проверить email клиента")
    private boolean checkEmailStep() {
        return clientPersonalAccountPage.checkEmail();
    }

    @Step("Проверить ФИО клиента")
    private boolean checkFIOStep() {
        return clientPersonalAccountPage.checkFIO();
    }

    @Step("Выйти из личного кабинета")
    private void logOutStep() {
        clientPersonalAccountPage.logOut();
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
