package company.name.positive;


import company.name.DriverManager;
import company.name.positive.steps.CheckClientInformationPositiveStep;
import org.junit.jupiter.api.Test;

/**
 * Класс теста проверки информации о клиенте
 * @see company.name.pages.ClientPersonalAccountPage
 * @author Филимонов Виктор
 */
public class CheckClientInformation {

    /**
     * @parem step ресурс, который тестируем
     * @param login логин для входа в личный кабинет
     * @param password пароль для входа в личный кабинет
     * @param email адресс почты в настройках профиля для проверки данных поля
     * @param FIO ФИО пользователя для проверки данных поля
     */
    private CheckClientInformationPositiveStep step = new CheckClientInformationPositiveStep();
    private String login = "yedake3020";
    private String password = "HJobXi";
    private String email = "yedake3020@mijumail.com";
    private String FIO = "Rost";

    /**
     * Тест, тестирует возможность заказать тестирование своего сайта
     */
    @Test
    public void checkClientInfo() {
        step.openTestStandStep();
        step.logInStep(login, password);
        step.profileInfoInStep();
        step.checkLoginStep(login);
        step.checkEmailStep(email);
        step.checkFIOStep(FIO);
        step.logOutStep();
        DriverManager.quit();
    }

}
