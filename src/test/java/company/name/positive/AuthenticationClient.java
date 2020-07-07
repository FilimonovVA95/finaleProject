package company.name.positive;

import company.name.DriverManager;
import company.name.positive.steps.AuthenticationClientPositiveStep;
import org.junit.jupiter.api.Test;


/**
 * Тест проверяет возможность войти с заданными логином и паролем
 * @author Aleksander Dmitriev
 * @see company.name.pages.Authentication
 */
public class AuthenticationClient {

    private String email = "kicoti9729@kartk5.com";  // Почта заранее зарагестрированного пользователя
    private String password = "QlwS1Z";  // Пароль от личного кабинета клиента

    private AuthenticationClientPositiveStep step = new AuthenticationClientPositiveStep();

    @Test
    public void autentificationClient() {
        step.openTestStandStep();
        step.openPopUpStep();
        step.inputEmailStep(email);
        step.inputPasswordStep(password);
        step.clickAuthenticationStep();
        step.logOutStep();
        DriverManager.quit();
    }

}
