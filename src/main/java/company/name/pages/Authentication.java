package company.name.pages;

import company.name.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * класс для авторизации
 * @author Акматалиев Алмаз
 */
public class Authentication extends AbstractPage {

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
     */
    public Authentication () {
        super(DriverManager.getDriver());
    }

    /**
     * открыть тестовый стенд
     */
    public void openTestStand(){
        DriverManager.getDriver().get(testStand);
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
     *
     * @return
     */
    public boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean checkLoginFiled(String email) {
        return loginFiled.getAttribute("value").equals(email);
    }

    /**
     *
     * @param password
     * @return
     */
    public boolean checkPasswordField(String password) {
        return passwordField.getAttribute("value").equals(password);
    }

    /**
     *
     * @return
     */
    public boolean checkClickLogIn() {
        return clickLogIn.isEnabled();
    }

    /**
     *
     * @return
     */
    public boolean checkClickLogOut() {
        return clickLogOut.isEnabled();
    }

    /**
     *
     * @return
     */
    public boolean checkInCorrectEmailOrPasswordError() {
        new WebDriverWait(DriverManager.getDriver(), 5).until((d) -> InCorrectEmailOrPasswordError.isDisplayed());
        return InCorrectEmailOrPasswordError.getText().equals("Неверная почта или пароль");
    }

    /**
     *
     * @param message
     * @return
     */
    public boolean checkInCorrectEmailOrPasswordNull(String message) {
        return InCorrectEmailOrPasswordNull.getText().equals(message);
    }

    /**
     *
     */
    public void clearFieldEmail() {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        loginFiled.sendKeys(del);
    }

    /**
     *
     */
    public void clearFieldPassword() {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        passwordField.sendKeys(del);
    }

}
