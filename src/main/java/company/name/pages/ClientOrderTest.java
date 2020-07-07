package company.name.pages;

import company.name.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Author Aleksander Dmitriev
 * @mail shdmi.2010@gmail.com
 */
public class ClientOrderTest extends AbstractPage {

    private int timeWait = 5;

    @FindBy(id = "header-lk-button")
    private WebElement loginButton;             // Открыть окно авторизации

    @FindBy(id = "login")
    private WebElement loginFiled;              // Поле ввода email

    @FindBy(css = "[type=password]")
    private WebElement passwordField;           // Поле ввода пароля

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"]")
    private WebElement submitButton;            // Кнопка авторизации

    @FindBy(id = "logout")
    private WebElement exitButton;              // Кнопка выхода

    @FindBy(className = "new_test")
    private WebElement createTest;              // Открыть окно создания нового теста

    @FindBy(css = "[data-testid=\"Test name input\"]")
    private WebElement testNameField;           // Поле ввода названия теста

    @FindBy(css = "[data-testid=\"Address site input\"]")
    private WebElement siteNameField;           // Поле ввода тестируемого сайта

    @FindBy(css = "[data-testid=\"Information textarea\"]")
    private WebElement informationField;        // Поле ввода информации для респондента

    @FindBy(css = "[data-testid=\"Submit button\"]")
    private WebElement toPeopleGroup;           // Кнопка перехода к выбору аудитории

    @FindBy(css = "[data-testid=\"Segment name input 0\"]")
    private WebElement segmentNameField;        // Поле для ввода названия сегмента

    @FindBy(css = "[data-testid=\"Tasks button\"]")
    private WebElement taskClick;               // Кнопка перехода к заданиям

    @FindBy(css = "[data-testid=\"Tasks task question\"]")
    private WebElement taskField;               // Поле для ввода вопросов

    @FindBy(css = "[data-testid=\"Tasks submit task\"]")
    private WebElement addTask;                 // Кнопка добавления задания

    @FindBy(css = "[fill=\"url(#trashIconPattern)\"]")
    private WebElement checkTaskDelete;         // Кнопка удаления задания

    @FindBy(css = "[data-testid=\"Check button\"]")
    private WebElement checkAndRunButton;        // Кнопка перехода к проверке и запуску теста

    @FindBy(css = "[data-testid=\"Checkout start button\"]")
    private WebElement runFreeTestButton;        // Запуск бесплатного теста

    @FindBy(xpath = "//*[contains(text(),'Тест создан')]")
    private WebElement checkCreateOneMoreTest;   // Кнопка создания еще одного теста

    @FindBy(css = ":nth-child(2).iaxSpn")
    private WebElement testListClick;            // Перейти к списку тестов

    @FindBy(css = "[class=\"MuiTable-root\"] [class=\"MuiTableBody-root\"] tr:first-child td:first-child a")
    private WebElement checkLastTestName;        // Проверка имени последнего теста

    @FindBy(linkText = "Завершить")
    private WebElement deleteLastTest;           // Закрытие последнего теста

    @FindBy(className = "irdQhg")
    private WebElement yesDeleteButtonClick;     // Подтвердить закрытие теста

    @FindBy(xpath = "//div[5]//span[2]")
    private WebElement checkDeleteLastTest;      // Проверка закрытия последнего теста


    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public ClientOrderTest() {
        super(DriverManager.getDriver());
    }

    /**
     * открывает тестовый стенд
     */
    public void openTestStand() {
        DriverManager.getDriver().get(testStand);
    }

    /**
     * вход в личный кабинет
     */
    public void logIn(String  login, String password) {
        loginButton.click();

        new WebDriverWait(DriverManager.getDriver(), timeWait).withMessage("Click logIn exception")
                .until((d) -> submitButton.isDisplayed());

        loginFiled.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    /**
     * выход из личного кабинета
     */
    public void logout() {
        exitButton.click();
    }

    /**
     * начало создания нового теста
     */
    public void createTest() {
        createTest.click();
    }

    /**
     * ввод названия теста
     *
     * @param nameTest - само название теста
     */
    public void inputNameTest(String nameTest) {
        testNameField.sendKeys(nameTest);
    }

    /**
     * ввод имени тестируемого сайта
     *
     * @param SiteTest - имя тестируемого сайта
     */
    public void inputSiteTest(String SiteTest) {
        siteNameField.sendKeys(SiteTest);
    }

    /**
     * Вводная информация для респондента
     *
     * @param information - информация для респондента
     */
    public void inputIntroductoryInformation(String information) {

        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        informationField.sendKeys(del);

        informationField.sendKeys(information);
    }

    /**
     * переход к аудитории, которая будет проходить тест
     */
    public void clickNext() {
        toPeopleGroup.click();
    }

    /**
     * ввод названия тестовой группы
     *
     * @param segmentName - имя тестовой группы
     */
    public void inputSegmentName(String segmentName) {
        segmentNameField.sendKeys(segmentName);
    }

    /**
     * переход к заданиям
     */
    public void clickTasks() {
        taskClick.click();
    }

    /**
     * добавление задания тестерам
     *
     * @param task - задание тестерам
     */
    public void inputTask(String task) {
        taskField.sendKeys(task);
    }

    /**
     * подтверждение добавления задания
     */
    public void clickAddTask() {
        addTask.click();
    }

    /**
     * проверка и запуск теста
     */
    public void clickCheckAndRun() {
        checkAndRunButton.click();
    }

    /**
     * запуск бесплатного теста
     */
    public void clickRunFreeTest() {
        runFreeTestButton.click();
    }

    /**
     * переход к списку тестов
     */
    public void clickGoToListTests() {
        testListClick.click();
    }

    /**
     * закрываем тест
     */
    public void closeTest() {
        checkLastTestName.click();
        deleteLastTest.click();
        yesDeleteButtonClick.click();
    }


    /**
     *
     * @return
     */
    public boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    /**
     *
     * @return
     */
    public boolean checkExitButton() {
        return exitButton.isEnabled();
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean checkTestNameField(String name) {
        return testNameField.getAttribute("value").equals(name);
    }

    /**
     *
     * @param site
     * @return
     */
    public boolean checkSiteNameField(String site) {
        return siteNameField.getAttribute("value").equals(site);
    }

    /**
     *
     * @param information
     * @return
     */
    public boolean checkInformationField(String information) {
        return informationField.getAttribute("value").equals(information);
    }

    /**
     *
     * @return
     */
    public boolean checkToPeopleGroup() {
        return toPeopleGroup.isEnabled();
    }

    /**
     *
     * @param segmentName
     * @return
     */
    public boolean checkSegmentNameField(String segmentName) {
        return segmentNameField.getAttribute("value").equals(segmentName);
    }

    /**
     *
     * @return
     */
    public boolean checkTaskClick() {
        return taskClick.isEnabled();
    }

    /**
     *
     * @param task
     * @return
     */
    public boolean checkTaskField(String task) {
        return taskField.getAttribute("value").equals(task);
    }

    /**
     *
     * @return
     */
    public boolean checkTaskDelete() {
        return checkTaskDelete.isEnabled();
    }

    /**
     *
     * @return
     */
    public boolean checkAndRunButton() {
        return checkAndRunButton.isEnabled();
    }

    /**
     *
     * @return
     */
    public boolean checkRunFreeTestButton() {
        return runFreeTestButton.isEnabled();
    }

    /**
     *
     * @return
     */
    public boolean checkCheckCreateOneMoreTest() {
        return checkCreateOneMoreTest.isEnabled();
    }

    /**
     *
     * @param nameTest
     * @return
     */
    public boolean checkCheckLastTestName(String nameTest) {
        return checkLastTestName.getText().equals(nameTest);
    }

    /**
     *
     * @param text
     * @return
     */
    public boolean checkCheckDeleteLastTest(String text) {
        return checkDeleteLastTest.getText().equals(text);
    }
}
