package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientOrderTest extends AbstractPage {
    /**
     * написал ClientOrderTest
     * @Author Aleksander Dmitriev
     * @mail shdmi.2010@gmail.com
     */
    private String testStand;
    private WebDriver driver;
    private String login; // здесь надо ввести нужный логин
    private String password; // здесь нужно ввести нужный пароль

    @FindBy(id = "header-lk-button")
    private WebElement loginButton;

    @FindBy(id = "logout")
    private WebElement exitButton;

    @FindBy(css = ".MuiButton-label")
    private WebElement createTest;

    @FindBy(css = ".sc-dxgOiQ:nth-child(1) .sc-fjdhpX")
    private WebElement naming;

    @FindBy(css = ".sc-dxgOiQ:nth-child(3) .sc-fjdhpX")
    private WebElement siteName;

    @FindBy(css = ".sc-iwsKbI")
    private WebElement Information;

    @FindBy(css = ".sc-bxivhb")
    private WebElement Next;

    @FindBy(css = ".bHWJDm")
    private WebElement Segment;

    @FindBy(css = ".bJUtjD")
    private WebElement TaskClick;

    @FindBy(css = ".sc-iwsKbI")
    private WebElement AddTask;

    @FindBy(css = ".sc-bxivhb:nth-child(1)")
    private WebElement Nest;

    @FindBy(css = ".sc-kAzzGY:nth-child(2) > .sc-cSHVUG")
    private WebElement Commit;

    @FindBy(css = ".sc-bxivhb:nth-child(6)")
    private WebElement RunFree;

    @FindBy(css = ".bJUtjD")
    private WebElement TestList;



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

    public void openTestStand() //открыть тестовый стенд
    {
        driver.get(testStand);
    }

    public void logIn()   //войти в личный кабинет
    {
        loginButton.click();
        loginFiled.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void logout()    //выйти из личного кабинета
    {
        exitButton.click();
    }

    public void createTest()  // начать создание теста
    {
        createTest.click();
    }

    public void inputNameTest(String nameTest)  // ввести назхвание теста
    {
        naming.sendKeys(nameTest);
    }

    public void inputSiteTest(String SiteTest) // ввести имя тестируемого сайта
    {
        siteName.sendKeys(SiteTest);
    }

    public void inputIntroductoryInformation(String information) {
        Information.sendKeys(information);
    }

    public void clickNext()  // переход к выбору аудитории
    {
        Next.click();
    }

    public void inputSegmentName(String segmentName)  //ввести название сегмента
    {
        Segment.sendKeys(segmentName);
    }

    public void clickTasks()   //Перейти к заданиям
    {
        TaskClick.click();
    }

    public void inputTask(String task)   // добавить задание
    {
        AddTask.sendKeys(task);
    }

    public void clickAddTask()   //добавить задачу
    {
        Nest.click();
    }

    public void clickCheckAndRun()   //запустить проверку и запуск
    {
        Commit.click();
    }

    public void clickRunFreeTest()  // запустить бесплатный тест
    {
        RunFree.click();
    }

    public void clickGoToListTests()  // перейти к листу тестов
    {
        TestList.click();
    }


    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getExitButton() {
        return exitButton;
    }

    public WebElement getCreateTest() {
        return createTest;
    }

    public WebElement getNaming() {
        return naming;
    }

    public WebElement getSiteName() {
        return siteName;
    }

    public WebElement getInformation() {
        return Information;
    }

    public WebElement getNext() {
        return Next;
    }

    public WebElement getSegment() {
        return Segment;
    }

    public WebElement getTaskClick() {
        return TaskClick;
    }

    public WebElement getAddTask() {
        return AddTask;
    }

    public WebElement getNest() {
        return Nest;
    }

    public WebElement getCommit() {
        return Commit;
    }

    public WebElement getRunFree() {
        return RunFree;
    }

    public WebElement getTestList() {
        return TestList;
    }

}
