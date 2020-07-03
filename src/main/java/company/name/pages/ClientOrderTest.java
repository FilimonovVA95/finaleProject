package company.name.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Author Aleksander Dmitriev
 * @mail shdmi.2010@gmail.com
 */
public class ClientOrderTest extends AbstractPage {

    private String testStand;
    private WebDriver driver;
    private int timeWait = 5;
    private String login = "tisise5283@mailres.net"; // Почта заранее зарагестрированного пользователя
    private String password = "OXvpUm"; // Пароль от личного кабинета клиента

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

    @FindBy(css = "[class=\"sc-gPWkxV dwPzxl\"] [class=\"sc-bxivhb bJUtjD\"]")
    private WebElement checkCreateOneMoreTest;   // Кнопка создания еще одного теста

    @FindBy(css = ":nth-child(2).iaxSpn")
    private WebElement testListClick;            // Перейти к списку тестов

    @FindBy(xpath = "//tr[1]//td[1]//a[1]//span[1]//span[1]")
    private WebElement checkLastTestName;        // Проверка имени последнего теста

    @FindBy(linkText = "Завершить")
    private WebElement deleteLastTest;           // Закрытие последнего теста

    @FindBy(className = "irdQhg")
    private WebElement yesDeleteButtonClick;     // Подтвердить закрытие теста

    @FindBy(xpath = "//div[5]//span[2]")
    private WebElement checkDeleteLastTest;      // Проверка закрытия последнего теста



    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     *
     * @param driver вебдрайвер с которым мы работаем
     */
    public ClientOrderTest(WebDriver driver) {
        super(driver);
        this.testStand = super.testStand;
        this.driver = driver;
    }

    /**
     * открывает тестовый стенд
     */
    public void openTestStand() {
        driver.get(testStand);
    }

    /**
     * вход в личный кабинет
     */
    public void logIn() {
        loginButton.click();

        new WebDriverWait(driver, timeWait).withMessage("Click logIn exception")
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
     * список геттеров
     */

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getExitButton() {
        return exitButton;
    }

    public WebElement getTestNameField() {
        return testNameField;
    }

    public WebElement getSiteNameField() {
        return siteNameField;
    }

    public WebElement getInformationField() {
        return informationField;
    }

    public WebElement getToPeopleGroup() {
        return toPeopleGroup;
    }

    public WebElement getSegmentNameField() {
        return segmentNameField;
    }

    public WebElement getTaskClick() {
        return taskClick;
    }

    public WebElement getTaskField() {
        return taskField;
    }

    public WebElement getCheckTaskDelete() {
        return checkTaskDelete;
    }

    public WebElement getCheckAndRunButton() {
        return checkAndRunButton;
    }

    public WebElement getRunFreeTestButton() {
        return runFreeTestButton;
    }

    public WebElement getCheckCreateOneMoreTest() {
        return checkCreateOneMoreTest;
    }

    public WebElement getCheckLastTestName() {
        return checkLastTestName;
    }

    public WebElement getCheckDeleteLastTest() {
        return checkDeleteLastTest;
    }
}
