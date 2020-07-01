package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @Author Aleksander Dmitriev
 * @mail shdmi.2010@gmail.com
 */
public class ClientOrderTest extends AbstractPage {

    private String testStand;
    private WebDriver driver;
    private String login; // здесь надо ввести нужный логин
    private String password; // здесь нужно ввести нужный пароль

    @FindBy(id = "header-lk-button")
    private WebElement loginButton;

    @FindBy(id = "login")
    private WebElement loginFiled;

    @FindBy(css = "[type=password]")
    private WebElement passwordField;

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"]")
    private WebElement submitButton;

    @FindBy(id = "logout")
    private WebElement exitButton;

    @FindBy(css = "MuiButton-label")
    private WebElement createTest;

    @FindBy(css = "data-autotest-id=\"text_input_testNameInput\"")
    private WebElement testName;

    @FindBy(css = "data-autotest-id=\"text_input_testTargetURL\"")
    private WebElement siteName;

    @FindBy(css = "data-autotest-id=\"text_input_testDescriptionTextarea\"")
    private WebElement informationField;

    @FindBy(css = "class=\"sc-bxivhb bJUtjD\"")
    private WebElement toPeopleGroup;

    @FindBy(css = "data-autotest-id=\"text_input_groupName_0\"")
    private WebElement peopleGroup;

    @FindBy(css = "bJUtjD")
    private WebElement taskClick;

    @FindBy(css = "data-autotest-id=\"text_input_tasks_task_question\"")
    private WebElement addTask;

    @FindBy(css = "data-autotest-id=\"tasks_submit_task\"")
    private WebElement confirmButton;

    @FindBy(css = "class=\"sc-bxivhb bJUtjD\"")
    private WebElement commitButton;

    @FindBy(css = "data-autotest-id=\"checkout_start_button\"")
    private WebElement runFree;

    @FindBy(css = "class=\"sc-bxivhb iaxSpn\"")
    private WebElement testList;


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
     * окно входа в личный кабинет
     */
    public void logIn() {
        loginButton.click();
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
        testName.sendKeys(nameTest);
    }

    /**
     * ввод имени тестируемого сайта
     *
     * @param SiteTest - имя тестируемого сайта
     */
    public void inputSiteTest(String SiteTest) {
        siteName.sendKeys(SiteTest);
    }

    /**
     * Вводная информация для респондента
     *
     * @param information - информация для респондента
     */
    public void inputIntroductoryInformation(String information) {
        this.informationField.sendKeys(information);
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
        peopleGroup.sendKeys(segmentName);
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
        addTask.sendKeys(task);
    }

    /**
     * подтверждение добавления задания
     */
    public void clickAddTask() {
        confirmButton.click();
    }

    /**
     * проверка и запуск теста
     */
    public void clickCheckAndRun() {
        commitButton.click();
    }

    /**
     * запуск бесплатного теста
     */
    public void clickRunFreeTest() {
        runFree.click();
    }

    /**
     * переход к списку тестов
     */
    public void clickGoToListTests() {
        testList.click();
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

    public WebElement getCreateTest() {
        return createTest;
    }

    public WebElement getTestName() {
        return testName;
    }

    public WebElement getSiteName() {
        return siteName;
    }

    public WebElement getInformationField() {
        return this.informationField;
    }

    public WebElement getToPeopleGroup() {
        return toPeopleGroup;
    }

    public WebElement getPeopleGroup() {
        return peopleGroup;
    }

    public WebElement getTaskClick() {
        return taskClick;
    }

    public WebElement getAddTask() {
        return addTask;
    }

    public WebElement getNest() {
        return confirmButton;
    }

    public WebElement getCommitButton() {
        return commitButton;
    }

    public WebElement getRunFree() {
        return runFree;
    }

    public WebElement getTestList() {
        return testList;
    }

}
