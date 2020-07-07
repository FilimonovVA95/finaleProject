package company.name.positive.steps;

import company.name.pages.ClientOrderTest;
import io.qameta.allure.Step;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

/**
 *
 */
public class OrderTestFromClientPositiveStep extends AbstractPositiveStep {

    private ClientOrderTest clientOrderTest = new ClientOrderTest();

    @Step("Открыть тестовый стенд")
    public void openTestStandStep() {
        clientOrderTest.openTestStand();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue( clientOrderTest.checkLoginButton(), "Open test stand exception");
        });
        screenShotStep();
    }

    @Step("Войти в профиль клиента")
    public void logInStep(String login, String password) {
        clientOrderTest.logIn(login, password);
        step("Проверяем активность кнопки 'Выйти'", () -> {
            Assert.assertTrue( clientOrderTest.checkExitButton(), "Log In exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Новый тест'")
    public void createTestStep() {
        clientOrderTest.createTest();
        step("Проверяем активность кнопки 'К выбору аудитории'", () -> {
            Assert.assertTrue( clientOrderTest.checkToPeopleGroup(), "Create test exception");
        });
        screenShotStep();
    }

    @Step("Ввести название теста")
    public void inputNameTestStep(String nameTest) {
        clientOrderTest.inputNameTest(nameTest);
        step("Проверяем правильность ввода в поле 'Название теста'", () -> {
            Assert.assertTrue( clientOrderTest.checkTestNameField(nameTest), "Input name test exception");
        });
        screenShotStep();
    }

    @Step("Ввести адрес тестируемого сайта")
    public void inputSiteTestStep(String siteTest) {
        clientOrderTest.inputSiteTest(siteTest);
        step("Проверяем правильность ввода в поле 'Адрес тестируемого сайта'", () -> {
            Assert.assertTrue( clientOrderTest.checkSiteNameField("https://" + siteTest), "Input site test exception");
        });
        screenShotStep();
    }

    @Step("Ввести вводную информацию")
    public void inputIntroductoryInformationStep(String information) {
        clientOrderTest.inputIntroductoryInformation(information);
        step("Проверяем правильность ввода в поле 'Вводная информация'", () -> {
            Assert.assertTrue( clientOrderTest.checkInformationField(information), "Input introductory information exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'К выбору аудитории'")
    public void clickNextStep() {
        clientOrderTest.clickNext();
        step("Проверяем активность кнопки 'К заданиям'", () -> {
            Assert.assertTrue( clientOrderTest.checkTaskClick(), "Passing to audience exception");
        });
        screenShotStep();
    }

    @Step("Ввести название сегмента")
    public void inputSegmentNameStep(String segmentName) {
        clientOrderTest.inputSegmentName(segmentName);
        step("Проверяем правильность ввода в поле 'Название сегмента'", () -> {
            Assert.assertTrue( clientOrderTest.checkSegmentNameField(segmentName), "Input segment name exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'К заданиям'")
    public void clickTasksStep() {
        clientOrderTest.clickTasks();
        step("Проверяем активность кнопки 'Проверка и запуск'", () -> {
            Assert.assertTrue( clientOrderTest.checkAndRunButton(), "Passing to tasks exception");
        });
        screenShotStep();
    }

    @Step("Ввести вопросы")
    public void inputTaskStep(String task) {
        clientOrderTest.inputTask(task);
        step("Проверяем правильность ввода в поле 'Вопросы'", () -> {
            Assert.assertTrue( clientOrderTest.checkTaskField(task), "Input task exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Добавить'")
    public void clickAddTaskStep() {
        clientOrderTest.clickAddTask();
        step("Проверяем активность кнопки 'Удалить'", () -> {
            Assert.assertTrue( clientOrderTest.checkTaskDelete(), "Add task exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Проверка и запуск'")
    public void clickCheckAndRunStep() {
        clientOrderTest.clickCheckAndRun();
        step("Проверяем активность кнопки 'Запустить бесплатный тест'", () -> {
            Assert.assertTrue( clientOrderTest.checkRunFreeTestButton(), "Check and run exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Запустить бесплатный тест'")
    public void clickRunFreeTestStep() {
        clientOrderTest.clickRunFreeTest();
        step("Проверяем активность кнопки 'Создать еще один тест'", () -> {
            Assert.assertTrue( clientOrderTest.checkCheckCreateOneMoreTest(), "Run free test exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Вернуться к списку тестов'")
    public void clickGoToListTestsStep(String nameTest) {
        clientOrderTest.clickGoToListTests();
        step("Проверяем наличие последнего теста", () -> {
            Assert.assertTrue( clientOrderTest.checkCheckLastTestName(nameTest), "Test list exception");
        });
        screenShotStep();
    }

    @Step("Закрываем последний тест")
    public void deleteLastTestStep() {
        clientOrderTest.closeTest();
        step("Проверяем закрытие последнего теста", () -> {
            Assert.assertTrue( clientOrderTest.checkCheckDeleteLastTest("Завершен"), "Test delete exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Выход'")
    public void logoutStep() {
        clientOrderTest.logout();
        step("Проверяем активность кнопки 'Вход'", () -> {
            Assert.assertTrue( clientOrderTest.checkLoginButton(), "Logout exception");
        });
        screenShotStep();
    }

}
