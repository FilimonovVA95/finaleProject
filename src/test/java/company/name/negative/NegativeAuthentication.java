package company.name.negative;

import company.name.DriverManager;
import company.name.negative.steps.AuthenticationNegativeStep;
import org.junit.jupiter.api.Test;

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

    private AuthenticationNegativeStep step = new AuthenticationNegativeStep();

    @Test
    public void autentificationTester() {
        step.openTestStand();
        step.openPopUpStep();
        step.inputEmailStep(correctEmail);
        step.clickAuthenticationPasswordNullStep();
        step.inputPasswordStep(noCorrectPassword1);
        step.clickAuthenticationErrorStep();
        step.clearPasswordStep();
        step.inputPasswordStep(noCorrectPassword2);
        step.clickAuthenticationErrorStep();
        step.clearPasswordStep();
        step.inputPasswordStep(correctPassword);
        step.clearEmailStep();
        step.inputEmailStep(noCorrectEmail1);
        step.clickAuthenticationErrorStep();
        step.clearEmailStep();
        step.inputEmailStep(noCorrectEmail2);
        step.clickAuthenticationErrorStep();
        step.clearEmailStep();
        step.clickAuthenticationEmailNullStep();
        step.clearEmailStep();
        step.clearPasswordStep();
        step.inputEmailStep(correctEmail);
        step.inputPasswordStep(correctPassword);
        step.clickAuthenticationStep();
        step.logOutStep();
        DriverManager.quit();
    }
}