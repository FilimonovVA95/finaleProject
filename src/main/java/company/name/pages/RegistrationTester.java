package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Akmataliev Almaz
 * Регистрация тестера
*/
public class RegistrationTester extends AbstractPage {

    private String testStand;
    private WebDriver driver;
    private int timeWait = 10000;

    /**
     *
     * @param driver
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

    @FindBy(css = "[ng-tr=\"WHE.WHE23\"]")
    private WebElement forgotPassword;              // кнопка "Забыли пароль"

    @FindBy(css = "[ng-tr=\"WHE1.WHE13\"]")         // кнопка регистрации тестировщика
    private WebElement startRegistrationTesterButton;

    @FindBy(id = "emails")                          // поле ввода email
    private WebElement registrationEmailField;

    @FindBy(css = "[ng-tr=\"WHE.WHE26\"]")
    private WebElement clickFinishRegistration;     // кнопка регистрации

    @FindBy(id = "Галочка")
    private WebElement check;                       // Проверка что клиент зарегистрирован

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"]")          // Кнопка войти в аккаунт
    private WebElement clickLogIn;

    @FindBy(id = "login")
    private WebElement loginFiled;                  //поле для ввода логина при входе

    @FindBy(css = "[type=password]")
    private WebElement passwordField;               //поле для ввода пароля

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"")
    private WebElement inButton;                    // кнопка для входа в аккаунт

    @FindBy(id = "logout")                          // Кнопка выйти
    private WebElement clickLogOut;


    /**
     *
     */
    public void openTestStand(){
        driver.get(testStand);
    }

    /**
     *
     */
    public void openPopUp(){
        loginButton.click();
    }

    /**
     *
     */
    public void clickRegistration() {
        startRegistrationButton.click();
    }

    /**
     *
     */
    public void inputRegistrationTester(){
        startRegistrationTesterButton.click();
    }

    /**
     *
     * @param email
     */
    public void inputEmail(String email){
        registrationEmailField.sendKeys(email);
    }

    /**
     *
     */
    public void clickFinishRegistrationOnFieldRegistration()
    {
        clickFinishRegistration.click();
    }
    /**
     * авторизация Тестера
     */
    public void logIn(String email, String password){
        loginButton.click();
        new WebDriverWait(driver, timeWait).withMessage("Click register exception")
                .until((d) -> startRegistrationButton.isDisplayed());
        loginFiled.sendKeys(email);
        passwordField.sendKeys(password);
        inButton.click();
    }

    /**
     *
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

    public WebElement getClickLogIn() {
        return clickLogIn;
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
