package company.name.positive;

import company.name.DriverManager;
import company.name.positive.steps.OrderTestFromClientPositiveStep;
import org.junit.jupiter.api.Test;

/**
 * Класс теста проверки функционала клиента. Проверяет возможность заказать новый тест
 * @see company.name.pages.ClientOrderTest
 * @author Филимонов Виктор
 */
public class OrderTestFromClient {

    private OrderTestFromClientPositiveStep step = new OrderTestFromClientPositiveStep();

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

        step.openTestStandStep();
        step.logInStep(login, password);
        step.createTestStep();
        step.inputNameTestStep(nameTest);
        step.inputSiteTestStep(siteTest);
        step.inputIntroductoryInformationStep(information);
        step.clickNextStep();
        step.inputSegmentNameStep(segmentName);
        step.clickTasksStep();
        step.inputTaskStep(task);
        step.clickAddTaskStep();
        step.clickCheckAndRunStep();
        step.clickRunFreeTestStep();
        step.clickGoToListTestsStep(nameTest);
        step.deleteLastTestStep();
        step.logoutStep();
        DriverManager.quit();
    }

}
