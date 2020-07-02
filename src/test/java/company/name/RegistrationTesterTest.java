package company.name;

import company.name.pages.OneOffMailPageThroughRequests;
import company.name.pages.RegistrationTester;
import io.qameta.allure.Step;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

import static io.qameta.allure.Allure.step;

public class RegistrationTesterTest {
    String emailTest = OneOffMailPageThroughRequests.getNewEmail();
    String passwordTest= OneOffMailPageThroughRequests.getPassword();
    private int timeWait = 10;

    WebDriver driver = DriverManager.getDriver();
    RegistrationTester registrationTester = new RegistrationTester(driver);

    public RegistrationTesterTest() throws IOException {}

    @Test
    public void registrationTesterTest() throws IOException, InterruptedException {
        openTestStandStep();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(registrationTester.getLoginButton().isEnabled(), "Open test stand exception");
        });
        openPopUpStep();
        step("Проверяем активность кнопки \"Зарегистрироваться\"", () -> {
            Assert.assertTrue(registrationTester.getStartRegistrationButton().isEnabled(), "Open pop up exception");
        });
        clickRegistrationStep();
        step("Проверяем активность кнопки \"Регистрация тестера\"", () -> {
            Assert.assertTrue(registrationTester.getStartRegistrationTesterButton().isEnabled(),"Button registration tester exception");
        });
        clickRegistrationTesterStep();
        step("Проверяем активность кнопки \"Зарегистрироваться\"", () -> {
            Assert.assertTrue(registrationTester.getClickFinishRegistration().isEnabled(),"Click finish registration exception");
        });
        inputEmailStep();
        step("Проверяем правильность ввода в поле \"Почта\"", () -> {
            Assert.assertTrue(registrationTester.getRegistrationEmailField().getText().equals(emailTest),"Input mail exception");
        });
        new WebDriverWait(driver, timeWait).withMessage("Click register exception")
                .until((d) -> registrationTester.getRegistrationEmailField().getText().equals(emailTest));
        clickFinishRegistrationStep();
        step("Проверяем наличие Галочки", () -> {
            Assert.assertTrue(registrationTester.getCheck().isEnabled(), "Exception message");
        });
        logInStep();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step("Проверяем активность кнопки \"Зарегистрироватся\"", () -> {
            Assert.assertTrue(registrationTester.getStartRegistrationButton().isEnabled(),"Exception message");
        });
        logOutStep();
        step("Проверяем активность кнопки \"Вход\"", () -> {
            Assert.assertTrue(registrationTester.getLoginButton().isEnabled(),"Logout exception");
        });

    }
    @Step("Открыть тестовый стенд")
    private void openTestStandStep() {
        registrationTester.openTestStand();
    }

    @Step("Открыть окно авторизации")
    public void openPopUpStep(){
        registrationTester.openPopUp();
    }
    @Step("Открыть окно регистрации")
    public void clickRegistrationStep(){
        registrationTester.clickRegistration();
    }
    @Step("Начать регистрацию тестера")
    public void clickRegistrationTesterStep(){
        registrationTester.inputRegistrationTester();
    }
    @Step("Ввести емайл для регистрации")
    public void inputEmailStep(){
        registrationTester.inputEmail(emailTest);
    }
    @Step("Завершить регистрацию")
    public void clickFinishRegistrationStep() {
        registrationTester.clickFinishRegistration();
    }
    @Step("Войти в зарегестрированный профиль")
    public void logInStep(){
        registrationTester.logIn(emailTest, passwordTest);
    }
    @Step("Выйти из зарегестрированного профиля")
    public void logOutStep(){
        registrationTester.logOut();
    }
}