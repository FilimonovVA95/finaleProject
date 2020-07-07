package company.name.pages;

import company.name.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Akmataliev Almaz
 * Регистрация клиента
 */
public class RegistrationClient extends AbstractPage {

    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public RegistrationClient() {
        super(DriverManager.getDriver());
    }

    @FindBy(id = "header-lk-button")                                //кнопка открытия окна входа
    private WebElement loginButton;

    @FindBy(css = "[for=registrationLk]")                           //кнопка регистрации нового пользователя
    private WebElement startRegistrationButton;

    @FindBy(css = "[ng-tr=\"WHE1.WHE12\"]")                         //кнопка зарегистрировать клиента
    private WebElement newRegistrationClientButton;

    @FindBy(css = "[ng-tr=\"WHE.WHE23\"]")                          //кнопка "Забыли пароль"
    private WebElement forgotPassword;
    
    @FindBy(id = "name")                                            //поле для ввода имени
    private WebElement registrationNameField;

    @FindBy(id = "position")                                        //поле для ввода должности
    private WebElement registrationPositionField;

    @FindBy(id = "company")                                         //поле для ввода компания
    private WebElement registrationCompanyField;

    @FindBy(id = "emails")                                          //поле для ввода емайла
    private WebElement registrationEmailField;

    @FindBy(id = "phoneNumber")                                     //поле для ввода номера телефона
    private WebElement registrationPhoneNumberField;

    @FindBy(id = "site")                                            //поле для ввода ссылки на сайт
    private WebElement registrationSiteField;

    @FindBy(css = "[ng-tr=\"WHE.WHE26\"]")                          //кнопка "Зарегистрироваться" клиента
    private WebElement registrationClientOnFieldRegistration;

    @FindBy(id = "Галочка")                                         //проверка что клиент зарегистрирован
    private WebElement check;

    @FindBy(id = "login")                                           //поле для ввода логина при входе
    private WebElement loginFiled;

    @FindBy(css = "[type=password]")                                //поле для ввода пароля
    private WebElement passwordField;

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"")                           //кнопка для входа в аккаунт
    private WebElement inButton;

    @FindBy(id = "logout")                                          //кнопка выхода после успешного входа
    private WebElement logout;

    /**
     * нажатие кнопки входа на стартовой странице
     */
    public void openPopUp(){
        loginButton.click();
    }

    /**
     * нажатие кнопки регистрация
     */
    public void clickRegistration(){
        startRegistrationButton.click();
    }

    /**
     * нажатие кнопки "Зарегистрироватся"
     */
    public void clickRegistrationClient(){
        newRegistrationClientButton.click();
    }

    /**
     * Ввод в поле имя
     */
    public void inputPersonName(String personName) {
        registrationNameField.sendKeys(personName);
    }

    /**
     * ввод в поле должность
     */
    public void inputPosition(String position) {
        registrationPositionField.sendKeys(position);
    }

    /**
     * ввод в поле имя компании
     */
    public void inputCompanyName(String companyName) {
        registrationCompanyField.sendKeys(companyName);
    }

    /**
     * ввод в поле email
     */
    public void inputEmail(String email) {
        registrationEmailField.sendKeys(email);
    }

    /**
     * ввод в поле номер
     */
    public void inputPhone(String phone) {
        registrationPhoneNumberField.sendKeys(phone);
    }

    /**
     * ввод в поле адрес
     */
    public void inputSite(String site) {
        registrationSiteField.sendKeys(site);
    }

    /**
     * нажатие кнопки регистрация клиента
     */
    public void clickFinishRegistration(){
        registrationClientOnFieldRegistration.click();
    }

    /**
     * вводим email клиента для авторизации
     * @param emailTest email пользователя
     */
    public void inputEmailClient(String emailTest) {
        loginFiled.sendKeys(emailTest);
    }

    /**
     * вводим email пароль для авторизации
     * @param passwordTest пароль пользователя
     */
    public void inputPasswordClient(String passwordTest){
        passwordField.sendKeys(passwordTest);
    }

    /**
     * нажимает кнопку входа в аккаунт
     */
    public void logInClient() {
        inButton.click();
    }

    /**
     * выход из аккаунта
     */
    public void logOut(){
        logout.click();
    }

    /**
     * открытие тестового стенда
     */
    public void openTestStand(){
        DriverManager.getDriver().get(testStand);
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
     * @return
     */
    public boolean checkForgotPassword() {
        return forgotPassword.isEnabled();
    }

    /**
     *
     * @return
     */
    public boolean checkNewRegistrationClientButton() {
        return newRegistrationClientButton.isEnabled();
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean checkRegistrationNameField(String name) {
        return registrationNameField.getAttribute("value").equals(name);
    }

    /**
     *
     * @param position
     * @return
     */
    public boolean checkRegistrationPositionField(String position) {
        return registrationPositionField.getAttribute("value").equals(position);
    }

    /**
     *
     * @param company
     * @return
     */
    public boolean checkRegistrationCompanyField(String company) {
        return registrationCompanyField.getAttribute("value").equals(company);
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean checkRegistrationEmailField(String email) {
        return registrationEmailField.getAttribute("value").equals(email);
    }

    /**
     *
     * @param phone
     * @return
     */
    public boolean checkRegistrationPhoneNumberField(String phone) {
        return registrationPhoneNumberField.getAttribute("value").equals(phone);
    }

    /**
     *
     * @param site
     * @return
     */
    public boolean checkRegistrationSiteField(String site) {
        return registrationSiteField.getAttribute("value").equals(site);
    }

    /**
     *
     * @return
     */
    public boolean checkRegistrationClientOnFieldRegistration() {
        return registrationClientOnFieldRegistration.isEnabled();
    }

    /**
     *
     * @return
     */
    public boolean checkmark() {
        return check.isEnabled();
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
    public boolean checkLogout() {
        return logout.isEnabled();
    }
}