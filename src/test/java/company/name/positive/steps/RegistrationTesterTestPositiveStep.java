package company.name.positive.steps;


import company.name.pages.RegistrationTester;
import io.qameta.allure.Step;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

public class RegistrationTesterTestPositiveStep extends AbstractPositiveStep {

    private RegistrationTester registrationTester = new RegistrationTester();


    @Step("Открыть тестовый стенд")
    public void openTestStandStep() {
        registrationTester.openTestStand();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue(registrationTester.checkLoginButton(), "Open test stand exception");
        });
        screenShotStep();
    }

    @Step("Открыть окно авторизации")
    public void openPopUpStep(){
        registrationTester.openPopUp();
        step("Проверяем активность кнопки 'Забыли пароль'", () -> {
            Assert.assertTrue(registrationTester.checkForgotPassword(), "The 'Forgot Password' button is inactive");
        });
        screenShotStep();
    }

    @Step("Открыть окно регистрации")
    public void clickRegistrationStep(){
        registrationTester.clickRegistration();
        step("Проверяем активность кнопки 'Стать Тестировщиком'", () -> {
            Assert.assertTrue(registrationTester.checkStartRegistrationTesterButton(),"Button registration tester exception");
        });
        screenShotStep();
    }

    @Step("Начать регистрацию тестера")
    public void clickRegistrationTesterStep(){
        registrationTester.inputRegistrationTester();
        step("Проверяем активность кнопки 'Зарегистрироваться'", () -> {
            Assert.assertTrue(registrationTester.checkClickFinishRegistration(),"Click finish registration exception");
        });
        screenShotStep();
    }

    @Step("Ввести емайл для регистрации")
    public void inputEmailStep(String  emailTest){
        registrationTester.inputEmail(emailTest);
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationTester.checkRegistrationEmailField(emailTest), "'Mail' field is empty");
        });
        screenShotStep();
    }

    @Step("Завершить регистрацию")
    public void clickFinishRegistrationStep() {
        registrationTester.clickFinishRegistrationOnFieldRegistration();
        step("Элемент 'галочка' активна", () -> {
            Assert.assertTrue(registrationTester.checkmark(), "'Checkmark' not active");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Войти'")
    public void loginButtonClickStep(){
        registrationTester.openPopUp();
        step("Проверяем активность кнопки 'Зарегистрироватся'", () -> {
            Assert.assertTrue(registrationTester.checkStartRegistrationButton(), "'Register' button is not active");
        });
        screenShotStep();
    }

    @Step("Ввести в поле 'Почта' почту")
    public void loginFieldStep(String emailTest){
        registrationTester.inputEmailTester(emailTest);
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationTester.checkLoginFiled(emailTest), "'Mail' field is empty");
        });
        screenShotStep();
    }

    @Step("Ввести в поле 'Пароль' пароль")
    public void passwordFieldStep(String passwordTest){
        registrationTester.inputPasswordTester(passwordTest);
        step("Поле заполненно паролем", () -> {
            Assert.assertTrue(registrationTester.checkPasswordField(passwordTest), "'Password' field is empty");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Войти'")
    public void inButtonStep(){
        registrationTester.logInClick();
        step("Проверяем активность кнопки 'Выйти'", () -> {
            Assert.assertTrue(registrationTester.checkClickLogOut(), "'Login' button not active");
        });
        screenShotStep();
    }

    @Step("Выйти из зарегестрированного профиля")
    public void logOutStep(){
        registrationTester.logOut();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue(registrationTester.checkLoginButton(), "'Logout' button not active");
        });

        screenShotStep();
    }

}
