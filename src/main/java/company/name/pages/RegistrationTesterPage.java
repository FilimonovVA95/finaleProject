package company.name.pages;

import company.name.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Регистрация тестера
*/
public class RegistrationTesterPage extends AbstractPage {

    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public RegistrationTesterPage() {
        super(DriverManager.getDriver());
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

    @FindBy(id = "logout")                          // Кнопка выйти
    private WebElement clickLogOut;


    @Step("Открыть тестовый стенд")
    public void openTestStand(){
        DriverManager.getDriver().get(getStand());
        checkAndScreenShot("Проверяем активность кнопки 'Войти'", checkLoginButton(), "Open test stand exception");
    }

    @Step("Открыть окно авторизации")
    public void openPopUp(){
        loginButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Забыли пароль'", checkForgotPassword(), "The 'Forgot Password' button is inactive");
    }

    @Step("Открыть окно регистрации")
    public void clickRegistration() {
        startRegistrationButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Стать Тестировщиком'", checkStartRegistrationTesterButton(),"Button registration tester exception");
    }

    @Step("Начать регистрацию тестера")
    public void clickRegistrationTester(){
        startRegistrationTesterButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Зарегистрироваться'", checkClickFinishRegistration(),"Click finish registration exception");
    }

    @Step("Ввести емайл для регистрации")
    public void inputEmail(String email){
        registrationEmailField.sendKeys(email);
        checkAndScreenShot("Поле заполненно почтой", checkRegistrationEmailField(email), "'Mail' field is empty");
    }

    @Step("Завершить регистрацию")
    public void clickFinishRegistration() {
        clickFinishRegistration.click();
        checkAndScreenShot("Элемент 'галочка' активна", checkmark(), "'Checkmark' not active");
    }

    @Step("Ввести в поле 'Почта' почту")
    public void inputEmailTester (String email) {
        loginFiled.sendKeys(email);
        checkAndScreenShot("Поле заполненно почтой", checkLoginFiled(email), "'Mail' field is empty");
    }

    @Step("Ввести в поле 'Пароль' пароль")
    public void inputPasswordTester (String password) {
        passwordField.sendKeys(password);
        checkAndScreenShot("Поле заполненно паролем", checkPasswordField(password), "'Password' field is empty");
    }

    @Step("Нажать кнопку 'Войти'")
    public void logInClick() {
        clickLogIn.click();
        checkAndScreenShot("Проверяем активность кнопки 'Выйти'", checkClickLogOut(), "'Login' button not active");
    }

    @Step("Выйти из зарегестрированного профиля")
    public void logOut(){
        clickLogOut.click();
        checkAndScreenShot("Проверяем активность кнопки 'Войти'", checkLoginButton(), "'Logout' button not active");
    }

    /**
     * проверка кнопки открытия PopUp
     * @return возвращает true если найден объект
     */
    public boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    /**
     * проверка кнопки 'Зарегестрироваться'
     * @return возвращает true если найден объект
     */
    public boolean checkStartRegistrationButton() {
        return startRegistrationButton.isEnabled();
    }

    /**
     * проверка кнопки 'Востановить пароль'
     * @return возвращает true если найден объект
     */
    public boolean checkForgotPassword() {
        return forgotPassword.isEnabled();
    }

    /**
     * проверка кнопки 'Зарегестрировать тестера'
     * @return возвращает true если найден объект
     */
    public boolean checkStartRegistrationTesterButton() {
        return startRegistrationTesterButton.isEnabled();
    }

    /**
     * проверка поля email
     * @param email корректный email
     * @return возвращает true если совпадает email
     */
    public boolean checkRegistrationEmailField(String email) {
        return registrationEmailField.getAttribute("value").equals(email);
    }

    /**
     * проверка кнопки 'Зарегестрировать'
     * @return возвращает true если найден объект
     */
    public boolean checkClickFinishRegistration() {
        return clickFinishRegistration.isEnabled();
    }

    /**
     * проверка успешной регистрации
     * @return возвращает true если найден объект
     */
    public boolean checkmark() {
        return check.isEnabled();
    }

    /**
     * проверка поля email
     * @param email корректный email
     * @return возвращает true если совпадает email
     */
    public boolean checkLoginFiled(String email) {
        return loginFiled.getAttribute("value").equals(email);
    }

    /**
     * проверка поля пароля
     * @param password корректный пароль
     * @return возвращает true если совпадает пароль
     */
    public boolean checkPasswordField(String password) {
        return passwordField.getAttribute("value").equals(password);
    }

    /**
     * проверка кнопки 'Выход'
     * @return возвращает true если найден объект
     */
    public boolean checkClickLogOut() {
        return clickLogOut.isEnabled();
    }
}
