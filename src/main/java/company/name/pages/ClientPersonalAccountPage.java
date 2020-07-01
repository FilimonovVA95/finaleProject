package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс личного кабинета пользователя
 * @author Rostislav Efimov
 */
public class ClientPersonalAccountPage extends AbstractPage {

    /**
     * Локаторы поиска на стартовой странице
     */

    @FindBy(id = "header-lk-button")
    private WebElement loginButton;             //Кнопка открытия окна входа

    @FindBy(id = "login")
    private WebElement loginFiled;              //Поле для ввода логина при входе

    @FindBy(css = "[for=registrationLk]") // кнопка регистрации нового пользователя
    private WebElement startRegistrationButton;

    @FindBy(css = "[type=password]")
    private WebElement passwordField;           //Поле для ввода пароля

    @FindBy(css = "#form_auth button")
    private WebElement submitButton;            //Кнопка для входа

    /**
     * Локаторы поиска для личного кабинета клииента
     */

    @FindBy(id = "logout")
    private WebElement exitButton;             // Кнопка выхода из личного кабинета

    @FindBy(className = "inline-btn btn_settings")
    private WebElement profileSettingsButton;  //Кнопка входа в настройки профиля

    @FindBy(css = "[ng-model=\"customerProfile.username\"]")
    private WebElement userNameField;          // Поле логин пользователя yedake3020, пароль HJobXi

    @FindBy(className = "customer-form-control ng-pristine ng-untouched ng-valid ng-not-empty")
    private WebElement emailAddressField;      //Поле email пользователя yedake3020@mijumail.com

    @FindBy(xpath = "//div[@class='uxc_custom_input filled']//input[@name='fio'")
    private WebElement fioField;               //Поле ФИО пользователя Rost

    /**
     *
     * @param driver
     */
    public ClientPersonalAccountPage(WebDriver driver) {
        super(driver);
        this.testStand = super.testStand;
        this.driver = driver;
    }

    /**
     *        //по хорошему описание параметров
     */
    private String testStand;
    private WebDriver driver;
    private int timeWait = 10;
    private final String login = "yedake3020";
    private final String password = "HJobXi";
    private final String email = "yedake3020@mijumail.com";
    private final String FIO = "Rost";

    /**
     * Открытие тестового стэнда
     */
    public void openTestStand(){
        driver.get(testStand);
    }

    /**
     * Открыть окошко для входа
     */
//    public void logIn(){
//        loginButton.click();
//        loginFiled.sendKeys(login);
//        passwordField.sendKeys(password);
//        submitButton.click();
//    }
    public void logIn(String email, String password) {
        loginButton.click();
        new WebDriverWait(driver, timeWait).withMessage("Click register exception")
                .until((d) -> startRegistrationButton.isDisplayed());
        loginFiled.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    /**
     * Открыть настройки профиля клиента
     */
    public void profilInfoIn(){
        profileSettingsButton.click();
    }

    /**
     * Проверка поля логин
     */
    public void checkLogin(){
        userNameField.getText().equals(login);
    }

    /**
     * Проверка поля email
     */
    public void checkEmail(){
        emailAddressField.getText().equals(email);
    }

    /**
     * Проверка поля ФИО
     */
    public void chekFIO(){
        fioField.getText().equals(FIO);
    }

    /**
     * Выйти из личного кабинета клиента
     */
    public void logOut(){
        exitButton.click();
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

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getExitButton() {
        return exitButton;
    }

    public WebElement getProfileSettingsButton() {
        return profileSettingsButton;
    }

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getEmailAddressField() {
        return emailAddressField;
    }

    public WebElement getFioField() {
        return fioField;
    }
}
