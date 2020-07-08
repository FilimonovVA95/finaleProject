package company.name.positive;

import company.name.DriverManager;
import company.name.pages.ClientOrderTestPage;
import org.testng.annotations.Test;


/**
 * Класс теста проверки функционала клиента. Проверяет возможность заказать новый тест
 * @see ClientOrderTestPage
 */
public class OrderTestFromClientTest {

    private ClientOrderTestPage step = new ClientOrderTestPage();

    /**
     * Поля переменных, необходимых при тестировании. Данные полей вводятся при создании теста
     */
    private String login = "tisise5283@mailres.net"; // Почта заранее зарагестрированного пользователя
    private String password = "OXvpUm"; // Пароль от личного кабинета клиента
    private String nameTest = "Name";
    private String siteTest = "test.uxcrowd.ru/";
    private String information = "Information";
    private String segmentName = "SegmentName";
    private String task = "Task";

    /**
     * Тест, тестирует возможность заказать тестирование своего сайта
     */
    @Test
    public void createTestClient() {

        step.openTestStand();
        step.logIn(login, password);
        step.createTest();
        step.inputNameTest(nameTest);
        step.inputSiteTest(siteTest);
        step.inputIntroductoryInformation(information);
        step.clickNext();
        step.inputSegmentName(segmentName);
        step.clickTasks();
        step.inputTask(task);
        step.clickAddTask();
        step.clickCheckAndRun();
        step.clickRunFreeTest();
        step.clickGoToListTests(nameTest);
        step.closeTest();
        step.logout();
        DriverManager.quit();
    }

}
