package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
@author Akmataliev Almaz
Регистрация клиента
 */

public class RegistrationClient extends AbstractPage {

    private String testStand;
    private WebDriver driver;

    public RegistrationClient(WebDriver driver) {
        super(driver);
        this.testStand = super.testStand;
        this.driver = driver;
    }

    @FindBy(id = "header-lk-button")   //кнопка открытия окна входа
    private WebElement loginButton;

    @FindBy(css = "[for=registrationLk]") // кнопка регистрации нового пользователя
    private WebElement startRegistrationButton;

    @FindBy(css = "[ng-tr=\"WHE1.WHE12\"]")// кнопка зарегистрировать клиента
    private WebElement startRegistrationClientButton;

    @FindBy(id = "name")
    private WebElement registrationNameField;       //поле для ввода имени

    @FindBy(id = "position")
    private WebElement registrationPositionField;       //поле для ввода должности

    @FindBy(id = "company")
    private WebElement registrationCompanyField;       //поле для ввода компания

    @FindBy(id = "emails")
    private WebElement registrationEmailField;       //поле для ввода емайла

    @FindBy(id = "phoneNumber")
    private WebElement registrationPhoneNumberField;       //поле для ввода номера телефона

    @FindBy(id = "site")
    private WebElement registrationSiteField;       //поле для ввода ссылки на сайт

    @FindBy(css = "[ng-tr=\"WHE.WHE26\"]") //кнопка "Зарегистрироваться" клиента
    private WebElement registrationButton;

    @FindBy(id = "Галочка")
    private WebElement check; // Проверка что клиент зарегистрирован

    @FindBy(id = "login")
    private WebElement loginFiled;         //поле для ввода логина при входе

    @FindBy(css = "[type=password]")
    private WebElement passwordField;           //поле для ввода пароля

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"")
    private WebElement inButton;            // кнопка для входа в аккаунт


    @FindBy(id = "logout")
    private WebElement logout;      //кнопка выхода после успешного входа

    /*
    нажатие кнопки входа на стартовой странице
     */
    public void openPopUp(){
        loginButton.click();
    }
    /*
    нажатие кнопки регистрация
     */
    public void clickRegistration(){
        startRegistrationButton.click();
    }
    /*
    нажатие кнопки "Зарегистрироватся
     */
    public void clickRegistrationClient(){
        startRegistrationButton.click();
    }
    /*
    Ввод в поле имя
     */
    public void inputPersonName(String personName) {
        registrationNameField.sendKeys(personName);
    }
    /*
    ввод в поле должность
     */
    public void inputPosition(String position) {
        registrationPositionField.sendKeys(position);
    }
    /*
    ввод в поле имя номпании
     */
    public void inputCompanyName(String companyName) {
        registrationCompanyField.sendKeys(companyName);
    }
    /*
    ввод в поле email
     */
    public void inputEmail(String email) {
        registrationEmailField.sendKeys(email);
    }
    /*
    ввод в поле номер
     */
    public void inputPhone(String phone) {
        registrationPhoneNumberField.sendKeys(phone);
    }
    /*
    ввод в поле адресс
     */
    public void inputSite(String site) {
        registrationSiteField.sendKeys(site);
    }
    /*
    нажатие кнопки регистрация клиента
     */
    public void clickFinishRegistration(){
        registrationButton.click();
    }
    /*
    авторизация клиента
     */
    public void logIn(String email, String password){
        loginButton.click();
        loginFiled.sendKeys(email);
        passwordField.sendKeys(password);
        inButton.click();
    }
    /*
    выход из аккаунта
     */
    public void logOut(){
        logout.click();
    }
    /*
    открытие тестового стенда
     */
    public void openTestStand(){
        driver.get(testStand);
    }

    public String getTestStand() {
        return testStand;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getStartRegistrationButton() {
        return startRegistrationButton;
    }

    public WebElement getStartRegistrationClientButton() {
        return startRegistrationClientButton;
    }

    public WebElement getRegistrationNameField() {
        return registrationNameField;
    }

    public WebElement getRegistrationPositionField() {
        return registrationPositionField;
    }

    public WebElement getRegistrationCompanyField() {
        return registrationCompanyField;
    }

    public WebElement getRegistrationEmailField() {
        return registrationEmailField;
    }

    public WebElement getRegistrationPhoneNumberField() {
        return registrationPhoneNumberField;
    }

    public WebElement getRegistrationSiteField() {
        return registrationSiteField;
    }

    public WebElement getRegistrationButton() {
        return registrationButton;
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

    public WebElement getLogout() {
        return logout;
    }
}