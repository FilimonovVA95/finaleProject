package company.name;

import company.name.pages.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

/**
 * Класс теста проверки функционала клиента. Проверяет возможность заказать новый тест
 * @see company.name.pages.ClientOrderTest
 * @author Филимонов Виктор
 */
public class OrderTestFromClient {

    /**
     * Поля вебдрайвера и страницы, которую тестируем
     */
    private WebDriver driver = DriverManager.getDriver();
    private ClientOrderTest clientOrderTest = new ClientOrderTest();

    /**
     * Поля переменных, необходимых при тестировании. Данные полей вводятся при создании теста
     */
    String nameTest = "Name";
    String siteTest = "https://test.uxcrowd.ru/";
    String information = "Information";
    String segmentName = "SegmentName";
    String task = "Task";

    /**
     * Тест, тестирует возможность заказать тестирование своего сайта
     */
    @Test
    public void createTestClient() {

        openTestStandStep();
        step("Проверяем активность кнопки \"Войти\"", () -> {
            Assert.assertTrue(clientOrderTest.  .isEnabled(), "Open test stand exception");
        });

        logInStep();
        step("Проверяем активность кнопки \"Выйти\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Log In exception");
        });

        createTestStep();
        step("Проверяем активность кнопки \"К выбору аудитории\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Create test exception");
        });

        inputNameTestStep(nameTest);
        step("Проверяем правильность ввода в поле \"Название теста\"", () -> {
            Assert.assertTrue( clientOrderTest.  .getText().equals(nameTest), "Input name test exception");
        });

        inputSiteTestStep(siteTest);
        step("Проверяем правильность ввода в поле \"Адрес тестируемого сайта\"", () -> {
            Assert.assertTrue( clientOrderTest.  .getText().equals(siteTest), "Input site test exception");
        });

        inputIntroductoryInformationStep(information);
        step("Проверяем правильность ввода в поле \"Вводная информация\"", () -> {
            Assert.assertTrue( clientOrderTest.  .getText().equals(information), "Input introductory information exception");
        });

        clickNextStep();
        step("Проверяем активность кнопки \"К заданиям\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Passing to audience exception");
        });

        inputSegmentNameStep(segmentName);
        step("Проверяем правильность ввода в поле \"Название сегмента\"", () -> {
            Assert.assertTrue( clientOrderTest.  .getText().equals(segmentName), "Input segment name exception");
        });

        clickTasksStep();
        step("Проверяем активность кнопки \"Проверка и запуск\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Passing to tasks exception");
        });

        inputTaskStep(task);
        step("Проверяем правильность ввода в поле \"Вопросы\"", () -> {
            Assert.assertTrue( clientOrderTest.  .getText().equals(task), "Input task exception");
        });

        clickAddTaskStep();
        step("Проверяем активность кнопки \"Удалить\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Add task exception");
        });

        clickCheckAndRunStep();
        step("Проверяем активность кнопки \"Запустить бесплатный тест\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Check and run exception");
        });

        clickRunFreeTestStep();
        step("Проверяем активность кнопки \"Вернуться к списку тестов\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Run free test exception");
        });

        clickGoToListTestsStep();
        step("Проверяем активность кнопки \"Копировать\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Test list exception");
        });

        logoutStep();
        step("Проверяем активность кнопки \"Вход\"", () -> {
            Assert.assertTrue( clientOrderTest.  .isEnabled(), "Logout exception");
        });
    }


    @Step("Открыть тестовый стенд")
    private void openTestStandStep() {
        clientOrderTest.openTestStand();
    }

    @Step("Войти в профиль клиента")
    private void logInStep() {
        clientOrderTest.logIn();
    }

    @Step("Нажать кнопку \"Новый тест\"")
    private void createTestStep() {
        clientOrderTest.createTest();
    }

    @Step("Ввести название теста")
    private void inputNameTestStep(String nameTest) {
        clientOrderTest.inputNameTest(nameTest);
    }

    @Step("Ввести адрес тестируемого сайта")
    private void inputSiteTestStep(String siteTest) {
        clientOrderTest.inputSiteTest(siteTest);
    }

    @Step("Ввести вводную информацию")
    private void inputIntroductoryInformationStep(String information) {
        clientOrderTest.inputIntroductoryInformation(information);
    }

    @Step("Нажать кнопку \"К выбору аудитории\"")
    private void clickNextStep() {
        clientOrderTest.clickNext();
    }

    @Step("Ввести название сегмента")
    private void inputSegmentNameStep(String segmentName) {
        clientOrderTest.inputSegmentName(segmentName);
    }

    @Step("Нажать кнопку \"К заданиям\"")
    private void clickTasksStep() {
        clientOrderTest.clickTasks();
    }

    @Step("Ввести вопросы")
    private void inputTaskStep(String task) {
        clientOrderTest.inputTask(task);
    }

    @Step("Нажать кнопку \"Добавить\"")
    private void clickAddTaskStep() {
        clientOrderTest.clickAddTask();
    }

    @Step("Нажать кнопку \"Проверка и запуск\"")
    private void clickCheckAndRunStep() {
        clientOrderTest.clickCheckAndRun();
    }

    @Step("Нажать кнопку \"Запустить бесплатный тест\"")
    private void clickRunFreeTestStep() {
        clientOrderTest.clickRunFreeTest();
    }

    @Step("Нажать кнопку \"Вернуться к списку тестов\"")
    private void clickGoToListTestsStep() {
        clientOrderTest.clickGoToListTests();
    }

    @Step("Нажать кнопку \"Выход\"")
    private void logoutStep() {
        clientOrderTest.logout();
    }

}
