package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Akmataliev Almaz
 * Регистрация тестера
*/
public class RegistrationTester extends AbstractPage {

    private String testStand;
    private WebDriver driver;

    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     * @param driver вебдрайвер с которым мы работаем
     */
    public RegistrationTester(WebDriver driver) {
        super(driver);
        this.testStand = super.testStand;
        this.driver = driver;
    }

    @FindBy(id = "header-lk-button")                //кнопка открытия окна входа
    private WebElement loginButton;

    @FindBy(css = "[for=registrationLk]")           // кнопка регистрации нового пользователя
    private WebElement startRegistrationButton;

    @FindBy(css = "[ng-tr=\"WHE.WHE23\"]")          // кнопка "Забыли пароль"
    private WebElement forgotPassword;

    @FindBy(css = "[ng-tr=\"WHE1.WHE13\"]")         // кнопка регистрации тестировщика
    private WebElement startRegistrationTesterButton;

    @FindBy(id = "emails")                          // поле ввода email
    private WebElement registrationEmailField;

    @FindBy(css = "[ng-tr=\"WHE.WHE26\"]")          // кнопка регистрации
    private WebElement clickFinishRegistration;

    @FindBy(id = "Галочка")                         // Проверка что клиент зарегистрирован
    private WebElement check;

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"]")          // Кнопка войти в аккаунт
    private WebElement clickLogIn;

    @FindBy(id = "login")                           //поле для ввода логина при входе
    private WebElement loginFiled;

    @FindBy(css = "[type=password]")                //поле для ввода пароля
    private WebElement passwordField;

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"")           // кнопка для входа в аккаунт
    private WebElement inButton;

    @FindBy(id = "logout")                          // Кнопка выйти
    private WebElement clickLogOut;


    /**
     * открыть тестовый стенд
     */
    public void openTestStand(){
        driver.get(testStand);
    }

    /**
     * открыть окно авторизации
     */
    public void openPopUp(){
        loginButton.click();
    }

    /**
     * открыть окно регистрации
     */
    public void clickRegistration() {
        startRegistrationButton.click();
    }

    /**
     * начать регистрацию тестера
     */
    public void inputRegistrationTester(){
        startRegistrationTesterButton.click();
    }

    /**
     * ввести email для регистрации
     * @param email почта для регистрации
     */
    public void inputEmail(String email){
        registrationEmailField.sendKeys(email);
    }

    /**
     * завершить регистрацию
     */
    public void clickFinishRegistrationOnFieldRegistration()
    {
        clickFinishRegistration.click();
    }

    /**
     * ввести email для авторизации
     * @param email почта, использованная для регистрации
     */
    public void inputEmailTester (String email) {
        getLoginFiled().sendKeys(email);
    }

    /**
     * ввести пароль для авторизации
     * @param password пароль, полученный из письма
     */
    public void inputPasswordTester (String password) {
        getPasswordField().sendKeys(password);
    }

    /**
     * войти в личный кабинет
     */
    public void logInClick() {
        getInButton().click();
    }

    /**
     * выйти из личного кабинета
     */
    public void logOut(){
        clickLogOut.click();
    }


    /**
     * Геттеры для вебэлементов
     */

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getStartRegistrationButton() {
        return startRegistrationButton;
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }

    public WebElement getStartRegistrationTesterButton() {
        return startRegistrationTesterButton;
    }

    public WebElement getRegistrationEmailField() {
        return registrationEmailField;
    }

    public WebElement getClickFinishRegistration() {
        return clickFinishRegistration;
    }

    public WebElement getCheck() {
        return check;
    }

    public WebElement getLoginFiled() {
        return loginFiled;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getInButton() {
        return inButton;
    }

    public WebElement getClickLogOut() {
        return clickLogOut;
    }
}
