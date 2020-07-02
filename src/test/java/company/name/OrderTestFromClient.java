package company.name;

import company.name.pages.ClientOrderTest;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.qameta.allure.Allure.step;

/**
 * Класс теста проверки функционала клиента. Проверяет возможность заказать новый тест
 * @see ClientOrderTest
 * @author Филимонов Виктор
 */
public class OrderTestFromClient {

    /**
     * Поля вебдрайвера и ресурса, который тестируем
     */
    private WebDriver driver = DriverManager.getDriver();
    private ClientOrderTest clientOrderTest = new ClientOrderTest(driver);

    /**
     * Поля переменных, необходимых при тестировании. Данные полей вводятся при создании теста
     */
    String nameTest = "Name";
    String siteTest = "test.uxcrowd.ru/";
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
            Assert.assertTrue( clientOrderTest.getLoginButton().isEnabled(), "Open test stand exception");
        });

        logInStep();
        step("Проверяем активность кнопки \"Выйти\"", () -> {
            Assert.assertTrue( clientOrderTest.getExitButton().isEnabled(), "Log In exception");
        });

        createTestStep();
        step("Проверяем активность кнопки \"К выбору аудитории\"", () -> {
            Assert.assertTrue( clientOrderTest.getToPeopleGroup().isEnabled(), "Create test exception");
        });

        inputNameTestStep(nameTest);
        step("Проверяем правильность ввода в поле \"Название теста\"", () -> {
            Assert.assertTrue( clientOrderTest.getTestNameField().getAttribute("value").equals(nameTest), "Input name test exception");
        });

        inputSiteTestStep(siteTest);
        step("Проверяем правильность ввода в поле \"Адрес тестируемого сайта\"", () -> {
            Assert.assertTrue( clientOrderTest.getSiteNameField().getAttribute("value").equals("https://" + siteTest), "Input site test exception");
        });

        inputIntroductoryInformationStep(information);
        step("Проверяем правильность ввода в поле \"Вводная информация\"", () -> {
            Assert.assertTrue( clientOrderTest.getInformationField().getAttribute("value").equals(information), "Input introductory information exception");
        });

        clickNextStep();
        step("Проверяем активность кнопки \"К заданиям\"", () -> {
            Assert.assertTrue( clientOrderTest.getTaskClick().isEnabled(), "Passing to audience exception");
        });

        inputSegmentNameStep(segmentName);
        step("Проверяем правильность ввода в поле \"Название сегмента\"", () -> {
            Assert.assertTrue( clientOrderTest.getSegmentNameField().getAttribute("value").equals(segmentName), "Input segment name exception");
        });

        clickTasksStep();
        step("Проверяем активность кнопки \"Проверка и запуск\"", () -> {
            Assert.assertTrue( clientOrderTest.getCheckAndRunButton().isEnabled(), "Passing to tasks exception");
        });

        inputTaskStep(task);
        step("Проверяем правильность ввода в поле \"Вопросы\"", () -> {
            Assert.assertTrue( clientOrderTest.getTaskField().getAttribute("value").equals(task), "Input task exception");
        });

        clickAddTaskStep();
        step("Проверяем активность кнопки \"Удалить\"", () -> {
            Assert.assertTrue( clientOrderTest.getCheckTaskDelete().isEnabled(), "Add task exception");
        });

        clickCheckAndRunStep();
        step("Проверяем активность кнопки \"Запустить бесплатный тест\"", () -> {
            Assert.assertTrue( clientOrderTest.getRunFreeTestButton().isEnabled(), "Check and run exception");
        });

        clickRunFreeTestStep();
        step("Проверяем активность кнопки \"Создать еще один тест\"", () -> {
            Assert.assertTrue( clientOrderTest.getCheckCreateOneMoreTest().isEnabled(), "Run free test exception");
        });

        clickGoToListTestsStep();
        step("Проверяем наличие последнего теста", () -> {
            Assert.assertTrue( clientOrderTest.getCheckLastTestName().getText().equals(nameTest), "Test list exception");
        });

        deleteLastTestStep();
        step("Проверяем закрытие последнего теста", () -> {
            Assert.assertTrue( clientOrderTest.getCheckDeleteLastTest().getText().equals("Завершен"), "Test delete exception");
        });

        logoutStep();
        step("Проверяем активность кнопки \"Вход\"", () -> {
            Assert.assertTrue( clientOrderTest.getLoginButton().isEnabled(), "Logout exception");
        });

        DriverManager.quit();
    }

    @Step("Открыть тестовый стенд")
    private void openTestStandStep() {
        clientOrderTest.openTestStand();
        screenShotStep();
    }

    @Step("Войти в профиль клиента")
    private void logInStep() {
        clientOrderTest.logIn();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Новый тест\"")
    private void createTestStep() {
        clientOrderTest.createTest();
        screenShotStep();
    }

    @Step("Ввести название теста")
    private void inputNameTestStep(String nameTest) {
        clientOrderTest.inputNameTest(nameTest);
        screenShotStep();
    }

    @Step("Ввести адрес тестируемого сайта")
    private void inputSiteTestStep(String siteTest) {
        clientOrderTest.inputSiteTest(siteTest);
        screenShotStep();
    }

    @Step("Ввести вводную информацию")
    private void inputIntroductoryInformationStep(String information) {
        clientOrderTest.inputIntroductoryInformation(information);
        screenShotStep();
    }

    @Step("Нажать кнопку \"К выбору аудитории\"")
    private void clickNextStep() {
        clientOrderTest.clickNext();
        screenShotStep();
    }

    @Step("Ввести название сегмента")
    private void inputSegmentNameStep(String segmentName) {
        clientOrderTest.inputSegmentName(segmentName);
        screenShotStep();
    }

    @Step("Нажать кнопку \"К заданиям\"")
    private void clickTasksStep() {
        clientOrderTest.clickTasks();
        screenShotStep();
    }

    @Step("Ввести вопросы")
    private void inputTaskStep(String task) {
        clientOrderTest.inputTask(task);
        screenShotStep();
    }

    @Step("Нажать кнопку \"Добавить\"")
    private void clickAddTaskStep() {
        clientOrderTest.clickAddTask();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Проверка и запуск\"")
    private void clickCheckAndRunStep() {
        clientOrderTest.clickCheckAndRun();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Запустить бесплатный тест\"")
    private void clickRunFreeTestStep() {
        clientOrderTest.clickRunFreeTest();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Вернуться к списку тестов\"")
    private void clickGoToListTestsStep() {
        clientOrderTest.clickGoToListTests();
        screenShotStep();
    }

    @Step("Закрываем последний тест")
    private void deleteLastTestStep() {
        clientOrderTest.closeTest();
        screenShotStep();
    }

    @Step("Нажать кнопку \"Выход\"")
    private void logoutStep() {
        clientOrderTest.logout();
        screenShotStep();
    }

    /**
     * Метод для получения скриншота и сохранения его в папке screenShots
     */
    private void screenShotStep() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screen = ts.getScreenshotAs(OutputType.FILE);
        String screenName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        try {
            FileUtils.copyFile(screen, new File("./ScreenShots/"+screenName+"_Screenshot.png"));
        } catch (IOException e) {
            System.out.println("Exception while taking ScreenShot "+e.getMessage());
            e.printStackTrace();
        }
    }
}
