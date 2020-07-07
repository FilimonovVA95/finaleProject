package company.name.positive.steps;

import company.name.pages.ClientPersonalAccountPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import static io.qameta.allure.Allure.step;

/**
 *
 */
public class CheckClientInformationPositiveStep extends AbstractPositiveStep {

    private ClientPersonalAccountPage clientPersonalAccountPage  = new ClientPersonalAccountPage();

    @Step("Открыть тестовый стенд")
    public void openTestStandStep() {
        clientPersonalAccountPage.openTestStand();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue( clientPersonalAccountPage.checkLoginButton(), "Open test stand exception");
        });
        screenShotStep();
    }

    @Step("Войти в личный кабинет клиента")
    public void logInStep(String login, String password) {
        clientPersonalAccountPage.logIn(login, password);
        step("Проверяем активность кнопки 'Выйти'", () -> {
            Assert.assertTrue( clientPersonalAccountPage.checkExitButton(), "Log In exception");
        });
        screenShotStep();
    }

    @Step("Войти в профиль клиента")
    public void profileInfoInStep() {
        clientPersonalAccountPage.profileInfoIn();
        step("Проверяем активность кнопки 'Изменить пароль'", () -> {
            Assert.assertTrue( clientPersonalAccountPage.checkChangePasswordButton(), "Passed to profile exception");
        });
        screenShotStep();
    }

    @Step("Проверить логин клиента")
    public void checkLoginStep(String login) {
        step("Проверяем данные в поле логин", () -> {
            Assert.assertTrue( clientPersonalAccountPage.checkLogin(login), "Login display exception");
        });
    }

    @Step("Проверить email клиента")
    public void checkEmailStep(String email) {
        step("Проверяем данные в поле email", () -> {
            Assert.assertTrue( clientPersonalAccountPage.checkEmail(email), "Email display exception");
        });
    }

    @Step("Проверить ФИО клиента")
    public void checkFIOStep(String FIO) {
        step("Проверяем данные в поле ФИО", () -> {
            Assert.assertTrue( clientPersonalAccountPage.checkFIO(FIO), "Full name display exception");
        });
    }

    @Step("Выйти из личного кабинета")
    public void logOutStep() {
        clientPersonalAccountPage.logOut();
        step("Проверяем активность кнопки 'Вход'", () -> {
            Assert.assertTrue( clientPersonalAccountPage.checkLoginButton(), "Logout exception");
        });
        screenShotStep();
    }

}
