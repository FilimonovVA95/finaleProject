package company.name.pages;

import company.name.DriverManager;
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
     */
    public ClientPersonalAccountPage() {
        super(DriverManager.getDriver());
    }

    /**
     * @param timeWait принимает время ожидания в секундах
     * @param login логин для входа в личный кабинет
     * @param password пароль для входа в личный кабинет
     * @param email адресс почты в настройках профиля для проверки данных поля
     * @param FIO ФИО пользователя для проверки данных поля
     */

    /**
     * Открытие тестового стэнда
     */
    public void openTestStand(){
        DriverManager.getDriver().get(testStand);
    }

    /**
     * вход в личный кабинет
     */
    public void logIn(String login, String password) {
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
    public boolean checkLogin(String login){
        return userNameField.getAttribute("value").equals(login);
    }

    /**
     * Проверка поля email
     */
    public boolean checkEmail(String email){
        return emailAddressField.getAttribute("value").equals(email);
    }

    /**
     * Проверка поля ФИО
     */
    public boolean checkFIO(String FIO){
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

    public boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    public boolean checkExitButton() {
        return exitButton.isEnabled();
    }

    public boolean checkChangePasswordButton() {
        return changePasswordButton.isEnabled();
    }
}
