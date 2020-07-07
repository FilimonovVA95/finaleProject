package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * класс для авторизации
 * @author Акматалиев Алмаз
 */
public class Authentication extends AbstractPage {

    private String testStand;
    private WebDriver driver;
    private int timeWait = 5;

    @FindBy(id = "header-lk-button")                    //кнопка открытия окна авторизации
    private WebElement loginButton;

    @FindBy(id = "login")
    private WebElement loginFiled;                      //поле для ввода логина при входе

    @FindBy(css = "[type=password]")
    private WebElement passwordField;                   //поле для ввода пароля

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"]")              // Кнопка войти в аккаунт
    private WebElement clickLogIn;

    @FindBy(id = "logout")                              // Кнопка выйти
    private WebElement clickLogOut;

    @FindBy(className = "error-block")                  // Поле ошибки при неверном указании email или пароля
    private WebElement InCorrectEmailOrPasswordError;

    @FindBy(css = ".validation-invalid")                // Поле ошибки при пустом email или пароле
    private WebElement InCorrectEmailOrPasswordNull;


    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     *
     * @param driver вебдрайвер с которым мы работаем
     */
    public Authentication (WebDriver driver) {
        super(driver);
        this.testStand = super.testStand;
        this.driver = driver;
    }

    /**
     * открыть тестовый стенд
     */
    public void openTestStand(){
        driver.get(testStand);
    }

    /**
     * открыть всплывающее окно входа
     */
    public void openPopUp() {
        loginButton.click();
    }

    /**
     * ввести email
     */
    public void inputEmail (String email){
        loginFiled.sendKeys(email);
    }

    /**
     * ввесьи пароль
     */
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    /**
     * нажать кнопку войти
     */
    public void clickAuthentication(){
        clickLogIn.click();
    }

    /**
     * нажать кнопку выйти
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

    public WebElement getLoginFiled() {
        return loginFiled;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getClickLogIn() {
        return clickLogIn;
    }

    public WebElement getClickLogOut() {
        return clickLogOut;
    }

    public WebElement getInCorrectEmailOrPasswordError() {
        return InCorrectEmailOrPasswordError;
    }

    public WebElement getInCorrectEmailOrPasswordNull() {
        return InCorrectEmailOrPasswordNull;
    }

}
