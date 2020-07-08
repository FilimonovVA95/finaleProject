package company.name.pages;

import company.name.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientOrderTestPage extends AbstractPage {


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
    public ClientOrderTestPage() {
        super(DriverManager.getDriver());
    }

    @Step("Открыть тестовый стенд")
    public void openTestStand() {
        DriverManager.getDriver().get(getStand());
        checkAndScreenShot("Проверяем активность кнопки 'Войти'", checkLoginButton(), "Open test stand exception");
    }

    @Step("Войти в личный кабинет клиента")
    public void logIn(String  login, String password) {
        loginButton.click();
        loginFiled.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Выйти'", checkExitButton(), "Log In exception");
    }

    @Step("Нажать кнопку 'Выход'")
    public void logout() {
        exitButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Вход'", checkLoginButton(), "Logout exception");
    }

    @Step("Нажать кнопку 'Новый тест'")
    public void createTest() {
        createTest.click();
        checkAndScreenShot("Проверяем активность кнопки 'К выбору аудитории'", checkToPeopleGroup(), "Create test exception");
    }

    @Step("Ввести название теста")
    public void inputNameTest(String nameTest) {
        testNameField.sendKeys(nameTest);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Название теста'", checkTestNameField(nameTest), "Input name test exception");
    }

    @Step("Ввести адрес тестируемого сайта")
    public void inputSiteTest(String siteTest) {
        siteNameField.sendKeys(siteTest);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Адрес тестируемого сайта'",
                checkSiteNameField("https://" + siteTest), "Input site test exception");
    }

    @Step("Ввести вводную информацию")
    public void inputIntroductoryInformation(String information) {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        informationField.sendKeys(del);
        informationField.sendKeys(information);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Вводная информация'",
                checkInformationField(information), "Input introductory information exception");
    }

    @Step("Нажать кнопку 'К выбору аудитории'")
    public void clickNext() {
        toPeopleGroup.click();
        checkAndScreenShot("Проверяем активность кнопки 'К заданиям'", checkTaskClick(), "Passing to audience exception");
    }

    @Step("Ввести название сегмента")
    public void inputSegmentName(String segmentName) {
        segmentNameField.sendKeys(segmentName);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Название сегмента'",
                checkSegmentNameField(segmentName), "Input segment name exception");
    }

    @Step("Нажать кнопку 'К заданиям'")
    public void clickTasks() {
        taskClick.click();
        checkAndScreenShot("Проверяем активность кнопки 'Проверка и запуск'", checkAndRunButton(), "Passing to tasks exception");
    }

    @Step("Ввести вопросы")
    public void inputTask(String task) {
        taskField.sendKeys(task);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Вопросы'", checkTaskField(task), "Input task exception");
    }

    @Step("Нажать кнопку 'Добавить'")
    public void clickAddTask() {
        addTask.click();
        checkAndScreenShot("Проверяем активность кнопки 'Удалить'", checkTaskDelete(), "Add task exception");
    }

    @Step("Нажать кнопку 'Проверка и запуск'")
    public void clickCheckAndRun() {
        checkAndRunButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Запустить бесплатный тест'", checkRunFreeTestButton(), "Check and run exception");
    }

    @Step("Нажать кнопку 'Запустить бесплатный тест'")
    public void clickRunFreeTest() {
        runFreeTestButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Создать еще один тест'", checkCreateOneMoreTest(), "Run free test exception");
    }

    @Step("Нажать кнопку 'Вернуться к списку тестов'")
    public void clickGoToListTests(String nameTest) {
        testListClick.click();
        checkAndScreenShot("Проверяем наличие последнего теста", checkLastTestName(nameTest), "Test list exception");
    }

    @Step("Закрываем последний тест")
    public void closeTest() {
        checkLastTestName.click();
        deleteLastTest.click();
        yesDeleteButtonClick.click();
        checkAndScreenShot("Проверяем закрытие последнего теста", checkDeleteLastTest("Завершен"), "Test delete exception");
    }


    /**
     * проверка кнопки открытия PopUp
     * @return возвращает true если найден объект
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
     * проверка имени пользователя
     * @param name корректное имя пользователя
     * @return возвращает true если совпадает имя
     */
    public boolean checkTestNameField(String name) {
        return testNameField.getAttribute("value").equals(name);
    }

    /**
     * проверка сайта компании пользователя
     * @param site корректный сайт компании
     * @return возвращает true если совпадает сайт
     */
    public boolean checkSiteNameField(String site) {
        return siteNameField.getAttribute("value").equals(site);
    }

    /**
     * проверка введенной информации о тесте
     * @param information корректная информация
     * @return возвращает true если совпадает информация
     */
    public boolean checkInformationField(String information) {
        return informationField.getAttribute("value").equals(information);
    }

    /**
     * проверка активности кнопки 'К выбору аудитории'
     * @return возвращает true если найден объект
     */
    public boolean checkToPeopleGroup() {
        return toPeopleGroup.isEnabled();
    }

    /**
     * проверки введенного имени сегмента
     * @param segmentName корректное имя сегмента
     * @return возвращает true если совпадает имя сегмента
     */
    public boolean checkSegmentNameField(String segmentName) {
        return segmentNameField.getAttribute("value").equals(segmentName);
    }

    /**
     * проверка активности кнопки 'К задачам'
     * @return возвращает true если найден объект
     */
    public boolean checkTaskClick() {
        return taskClick.isEnabled();
    }

    /**
     * проверка введенного задания
     * @param task корректное задание
     * @return возвращает true если совпадает задание
     */
    public boolean checkTaskField(String task) {
        return taskField.getAttribute("value").equals(task);
    }

    /**
     * проверка активности кнопки 'Удалить задачу'
     * @return возвращает true если найден объект
     */
    public boolean checkTaskDelete() {
        return checkTaskDelete.isEnabled();
    }

    /**
     * проверка активности кнопки 'Проверка и запуск'
     * @return возвращает true если найден объект
     */
    public boolean checkAndRunButton() {
        return checkAndRunButton.isEnabled();
    }

    /**
     * проверка активности кнопки 'Запустить бесплатный тест'
     * @return возвращает true если найден объект
     */
    public boolean checkRunFreeTestButton() {
        return runFreeTestButton.isEnabled();
    }

    /**
     * проверка активности кнопки 'Создания еще одного теста'
     * @return возвращает true если найден объект
     */
    public boolean checkCreateOneMoreTest() {
        return checkCreateOneMoreTest.isEnabled();
    }

    /**
     * проверка совпадения имени последенго теста в списке тестов с созданым тестом
     * @param nameTest имя созданного теста
     * @return возвращает true если совпадает имя последнего теста
     */
    public boolean checkLastTestName(String nameTest) {
        return checkLastTestName.getText().equals(nameTest);
    }

    /**
     * проверка завершения теста
     * @param text надпись о завершении теста
     * @return возвращает true если тест завершен
     */
    public boolean checkDeleteLastTest(String text) {
        return checkDeleteLastTest.getText().equals(text);
    }
}
