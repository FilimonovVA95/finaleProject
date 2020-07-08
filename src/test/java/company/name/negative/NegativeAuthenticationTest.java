package company.name.negative;

import company.name.DriverManager;
import company.name.pages.AuthenticationPage;
import org.testng.annotations.Test;


/**
 * Тест проверяет возможность войти с заданными логином и паролем
 * @see AuthenticationPage
 */
public class NegativeAuthenticationTest {

    private String correctEmail = "iplctsju16@post-shift.ru";           // Почта заранее зарагестрированного пользователя
    private String correctPassword = "Koafn3";                          // Пароль от личного кабинета клиента

    private String noCorrectEmail1 = "iplctsju16post-shift.ru";         // Некорректный email, забыли @
    private String noCorrectEmail2 = "noCorrectEmail@post-shift.ru";    // Другая почта

    private String noCorrectPassword1 = "Лщфат3";                       // Неправильная раскладка
    private String noCorrectPassword2 = "Ko3shd";                       // Неверный пароль

    private AuthenticationPage step = new AuthenticationPage();

    @Test
    public void authenticationTester() {
        step.openTestStand();
        step.openPopUp();
        step.inputEmail(correctEmail);
        step.clickAuthenticationPasswordNull();
        step.inputPassword(noCorrectPassword1);
        step.clickAuthenticationError();
        step.clearPassword();
        step.inputPassword(noCorrectPassword2);
        step.clickAuthenticationError();
        step.clearPassword();
        step.inputPassword(correctPassword);
        step.clearEmail();
        step.inputEmail(noCorrectEmail1);
        step.clickAuthenticationError();
        step.clearEmail();
        step.inputEmail(noCorrectEmail2);
        step.clickAuthenticationError();
        step.clearEmail();
        step.clickAuthenticationEmailNull();
        step.clearEmail();
        step.clearPassword();
        step.inputEmail(correctEmail);
        step.inputPassword(correctPassword);
        step.clickAuthentication();
        step.logOut();
        DriverManager.quit();
    }
}