package company.name.pages;

import company.name.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс личного кабинета пользователя
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


    @Step("Открыть тестовый стенд")
    public void openTestStand(){
        DriverManager.getDriver().get(getStand());
        checkAndScreenShot("Проверяем активность кнопки 'Войти'", checkLoginButton(), "Open test stand exception");
    }

    @Step("Войти в личный кабинет клиента")
    public void logIn(String login, String password) {
        loginButton.click();
        loginFiled.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Выйти'", checkExitButton(), "Log In exception");
    }

    @Step("Войти в настройки профиля клиента")
    public void profileInfoIn(){
        profileSettingsButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Изменить пароль'", checkChangePasswordButton(), "Passed to profile exception");
    }

    @Step("Проверить логин клиента")
    public void checkLogin(String login){
        checkAndScreenShot("Проверяем данные в поле логин", userNameField.getAttribute("value").equals(login), "Login display exception");

    }

    @Step("Проверить email клиента")
    public void checkEmail(String email){
        checkAndScreenShot("Проверяем данные в поле email", emailAddressField.getAttribute("value").equals(email), "Email display exception");
    }

    @Step("Проверить ФИО клиента")
    public void checkFIO(String FIO){
        checkAndScreenShot("Проверяем данные в поле ФИО", fioField.getAttribute("value").equals(FIO), "Full name display exception");
    }

    @Step("Выйти из личного кабинета")
    public void logOut(){
        exitButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Вход'", checkLoginButton(), "Logout exception");
    }

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
