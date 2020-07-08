package company.name.pages;

import company.name.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Регистрация клиента
 */
public class RegistrationClientPage extends AbstractPage {

    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public RegistrationClientPage() {
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


    @Step("Открыть тестовый стенд")
    public void openTestStand(){
        DriverManager.getDriver().get(getStand());
        checkAndScreenShot("Проверяем активность кнопки 'Войти'", checkLoginButton(), "'Login' button not active");
    }

    @Step("Нажать кнопку 'Войти'")
    public void openPopUp(){
        loginButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Забыли пароль'", checkForgotPassword(), "The 'Forgot Password' button is inactive");
    }

    @Step("Нажать кнопку 'Зарегистрироватся'")
    public void clickRegistration(){
        startRegistrationButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Стать клиентом'",
                checkNewRegistrationClientButton(),"The 'Become a customer' button is inactive");
    }

    @Step("Нажать кнопку 'Стать клиентом'")
    public void clickRegistrationClient(){
        newRegistrationClientButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Зарегистрироватся'",
                checkRegistrationClientOnFieldRegistration(), "'Register' button is not active");
    }

    @Step("Ввести в поле 'Ваше имя' имя")
    public void inputPersonName(String personName) {
        registrationNameField.sendKeys(personName);
        checkAndScreenShot("Поле заполненно именем", checkRegistrationNameField(personName), "'Name' field is empty");
    }

    @Step ("Ввести в поле 'Должность' должность")
    public void inputPosition(String position) {
        registrationPositionField.sendKeys(position);
        checkAndScreenShot("Поле заполненно должностью", checkRegistrationPositionField(position), "The field 'Position' is not filled");
    }

    @Step("Ввести в поле 'Компания' компанию")
    public void inputCompanyName(String companyName) {
        registrationCompanyField.sendKeys(companyName);
        checkAndScreenShot("Поле заполненно компанией", checkRegistrationCompanyField(companyName), "Field 'Company' is not filled");
    }

    @Step("Ввести в поле 'Почта' почту")
    public void inputEmail(String email) {
        registrationEmailField.sendKeys(email);
        checkAndScreenShot("Поле заполненно почтой", checkRegistrationEmailField(email), "'Mail' field is empty");
    }

    @Step("Ввести в поле 'Номер' номер телефона")
    public void inputPhone(String phone) {
        registrationPhoneNumberField.sendKeys(phone);
        checkAndScreenShot("Поле заполненно номером телефона", checkRegistrationPhoneNumberField(phone), "'Number' field is empty");
    }

    @Step ("Ввести в поле 'Ссылка на сайт'")
    public void inputSite(String site) {
        registrationSiteField.sendKeys(site);
        checkAndScreenShot("Поле заполненно ссылкой", checkRegistrationSiteField(site), "The 'link to the site' field is empty");
    }

    @Step ("Нажать кнопку 'Зарегистрироватся'")
    public void clickFinishRegistration(){
        registrationClientOnFieldRegistration.click();
        checkAndScreenShot("Элемент 'галочка' активна", checkmark(), "'Checkmark' not active");
    }

    @Step("Ввести в поле 'Почта' email")
    public void inputEmailClient(String emailTest) {
        loginFiled.sendKeys(emailTest);
        checkAndScreenShot("Поле заполненно почтой", checkLoginFiled(emailTest), "'Mail' field is empty");
    }

    @Step("Ввести в поле 'Пароль' пароль")
    public void inputPasswordClient(String passwordTest){
        passwordField.sendKeys(passwordTest);
        checkAndScreenShot("Поле заполненно паролем", checkPasswordField(passwordTest), "'Password' field is empty");
    }

    @Step("Нажать кнопку 'Войти'")
    public void logInClient() {
        inButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Выйти'", checkLogout(), "'Login' button not active");
    }

    @Step("Нажать кнопку 'Выйти'")
    public void logOut(){
        logout.click();
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
     * проверка кнопки 'Востановить пароль'
     * @return возвращает true если найден объект
     */
    public boolean checkForgotPassword() {
        return forgotPassword.isEnabled();
    }

    /**
     * проверка кнопки 'Зарегестрировать клиента'
     * @return возвращает true если найден объект
     */
    public boolean checkNewRegistrationClientButton() {
        return newRegistrationClientButton.isEnabled();
    }

    /**
     * проверка поля имя
     * @param name корректное имя
     * @return возвращает true если совпадает имя
     */
    public boolean checkRegistrationNameField(String name) {
        return registrationNameField.getAttribute("value").equals(name);
    }

    /**
     * проверка поля должность
     * @param position корректная должность
     * @return возвращает true если совпадает должность
     */
    public boolean checkRegistrationPositionField(String position) {
        return registrationPositionField.getAttribute("value").equals(position);
    }

    /**
     * проверка поля имя компании
     * @param company корректное имя компании
     * @return возвращает true если совпадает имя компании
     */
    public boolean checkRegistrationCompanyField(String company) {
        return registrationCompanyField.getAttribute("value").equals(company);
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
     * проверка поля номера телефона
     * @param phone корректный номер телефона
     * @return возвращает true если совпадает номер телефона
     */
    public boolean checkRegistrationPhoneNumberField(String phone) {
        return registrationPhoneNumberField.getAttribute("value").equals(phone);
    }

    /**
     * проверка поля сайта компании
     * @param site корректный сайт компании
     * @return возвращает true если совпадает сайт компании
     */
    public boolean checkRegistrationSiteField(String site) {
        return registrationSiteField.getAttribute("value").equals(site);
    }

    /**
     * проверка кнопки 'Зарегестрировать'
     * @return возвращает true если найден объект
     */
    public boolean checkRegistrationClientOnFieldRegistration() {
        return registrationClientOnFieldRegistration.isEnabled();
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
    public boolean checkLogout() {
        return logout.isEnabled();
    }
}