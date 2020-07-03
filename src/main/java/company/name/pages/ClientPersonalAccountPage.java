package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс личного кабинета пользователя
 * @author Rostislav Efimov
 */
public class ClientPersonalAccountPage extends AbstractPage {

    /**
     * Локаторы поиска на стартовой странице
     */

    @FindBy(id = "header-lk-button")
    private WebElement loginButton;                     //Кнопка открытия окна входа

    @FindBy(id = "login")
    private WebElement loginFiled;                      //Поле для ввода логина при входе

    @FindBy(css = "[for=registrationLk]")
    private WebElement startRegistrationButton;         //Кнопка регистрации нового пользователя

    @FindBy(css = "[type=password]")
    private WebElement passwordField;                   //Поле для ввода пароля

    @FindBy(css = "#form_auth button")
    private WebElement submitButton;                    //Кнопка для входа

    /**
     * Локаторы поиска для личного кабинета клииента
     */

    @FindBy(id = "logout")
    private WebElement exitButton;             // Кнопка выхода из личного кабинета

    @FindBy(css = "[ng-tr=\"MTP.MTP4\"]")
    private WebElement profileSettingsButton;  //Кнопка входа в настройки профиля

    @FindBy(css = "[ng-model=\"customerProfile.username\"]")
    private WebElement userNameField;          // Поле логин пользователя yedake3020, пароль HJobXi

    @FindBy(css = "[ng-model=\"customerProfile.email\"]")
    private WebElement emailAddressField;      //Поле email пользователя yedake3020@mijumail.com

    @FindBy(css = "[required-error-message=\"Введите ФИО\"]")
    private WebElement fioField;               //Поле ФИО пользователя Rost

    @FindBy(css = "[ng-tr=\"PRV.PRV71\"]")
    private WebElement changePasswordButton;   //Кнопка изменения пароля

    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     * @param driver вебдрайвер с которым мы работаем
     */
    public ClientPersonalAccountPage(WebDriver driver) {
        super(driver);
        this.testStand = super.testStand;
        this.driver = driver;
    }

    /**
     * @param timeWait принимает время ожидания в секундах
     * @param login логин для входа в личный кабинет
     * @param password пароль для входа в личный кабинет
     * @param email адресс почты в настройках профиля для проверки данных поля
     * @param FIO ФИО пользователя для проверки данных поля
     */
    private String testStand;
    private WebDriver driver;
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
     * вход в личный кабинет
     */
    public void logIn() {
        loginButton.click();
        loginFiled.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    /**
     * Открыть настройки профиля клиента
     */
    public void profileInfoIn(){
        profileSettingsButton.click();
    }

    /**
     * Проверка поля логин
     */
    public boolean checkLogin(){
        return userNameField.getAttribute("value").equals(login);
    }

    /**
     * Проверка поля email
     */
    public boolean checkEmail(){
        return emailAddressField.getAttribute("value").equals(email);
    }

    /**
     * Проверка поля ФИО
     */
    public boolean checkFIO(){
        return fioField.getAttribute("value").equals(FIO);
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

    public WebElement getExitButton() {
        return exitButton;
    }

    public WebElement getChangePasswordButton() {
        return changePasswordButton;
    }
}
