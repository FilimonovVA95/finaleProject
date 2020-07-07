package company.name.negative.steps;

import company.name.pages.Authentication;
import io.qameta.allure.Step;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

/**
 *
 */
public class AuthenticationNegativeStep extends AbstractNegativeStep {

    private Authentication authentication = new Authentication();

    @Step("Открыть тестовый стенд")
    public void openTestStand(){
        authentication.openTestStand();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(authentication.checkLoginButton(), "Open test stand exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку \"Войти\"")
    public void openPopUpStep(){
        authentication.openPopUp();
        step("Проверяем открытие окна авторизации", () -> {
            Assert.assertTrue(authentication.checkClickLogIn(), "Open popUp exception");
        });
        screenShotStep();
    }

    @Step("Ввести e-mail")
    public void inputEmailStep(String email){
        authentication.inputEmail(email);
        step("Проверяем правильность ввода email", () -> {
            Assert.assertTrue(authentication.checkLoginFiled(email), "Input email exception");
        });
        screenShotStep();
    }

    @Step("Ввести пароль")
    public void inputPasswordStep(String password){
        authentication.inputPassword(password);
        step("Проверяем правильность ввода пароля", () -> {
            Assert.assertTrue(authentication.checkPasswordField(password), "Input password exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку войти")
    public void clickAuthenticationPasswordNullStep(){
        authentication.clickAuthentication();
        step("Проверяем наличие ошибки о некорректности введенных данных. Пустой пароль", () -> {
            Assert.assertTrue(authentication.checkInCorrectEmailOrPasswordNull("Введите пароль"), "Error expected null password");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку войти")
    public void clickAuthenticationEmailNullStep(){
        authentication.clickAuthentication();
        step("Проверяем наличие ошибки о некорректности введенных данных. Пустой email", () -> {
            Assert.assertTrue(authentication.checkInCorrectEmailOrPasswordNull("Введите почту"), "Error expected null email");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку войти")
    public void clickAuthenticationErrorStep(){
        authentication.clickAuthentication();
        step("Проверяем наличие ошибки о некорректности введенных данных. Вводим некорректный пароль(кирилица)", () -> {
            Assert.assertTrue(authentication.checkInCorrectEmailOrPasswordError(), "Error expected no correct password");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку войти")
    public void clickAuthenticationStep(){
        authentication.clickAuthentication();
        step("Проверяем активность кнопки \"Выйти\" ", () -> {
            Assert.assertTrue(authentication.checkClickLogOut(), "LogIn exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку выйти")
    public void logOutStep(){
        authentication.logOut();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(authentication.checkLoginButton(), "LogOut exception");
        });
        screenShotStep();
    }

    @Step("Очистить поле email")
    public void clearEmailStep() {
        authentication.clearFieldEmail();
        screenShotStep();
    }

    @Step("Очистить поле пароля")
    public void clearPasswordStep() {
        authentication.clearFieldPassword();
        screenShotStep();
    }

}
