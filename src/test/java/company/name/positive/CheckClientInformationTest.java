package company.name.positive;

import company.name.DriverManager;
import company.name.pages.ClientPersonalAccountPage;
import org.testng.annotations.Test;

/**
 * Класс теста проверки информации о клиенте
 * @see company.name.pages.ClientPersonalAccountPage
 */
public class CheckClientInformationTest {

    /**
     * @parem step ресурс, который тестируем
     * @param login логин для входа в личный кабинет
     * @param password пароль для входа в личный кабинет
     * @param email адресс почты в настройках профиля для проверки данных поля
     * @param FIO ФИО пользователя для проверки данных поля
     */
    private ClientPersonalAccountPage step = new ClientPersonalAccountPage();
    private String login = "yedake3020";
    private String password = "HJobXi";
    private String email = "yedake3020@mijumail.com";
    private String FIO = "Rost";

    /**
     * Тест, тестирует возможность заказать тестирование своего сайта
     */
    @Test
    public void checkClientInfo() {
        step.openTestStand();
        step.logIn(login, password);
        step.profileInfoIn();
        step.checkLogin(login);
        step.checkEmail(email);
        step.checkFIO(FIO);
        step.logOut();
        DriverManager.quit();
    }

}
