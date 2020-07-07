package company.name.positive.steps;

import company.name.pages.RegistrationClient;
import io.qameta.allure.Step;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

public class RegistrationClientTestPositiveStep extends AbstractPositiveStep {

    private RegistrationClient registrationClient = new RegistrationClient();


    @Step("Открыть тестовый стенд")
    public void openTestStand(){
        registrationClient.openTestStand();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue(registrationClient.checkLoginButton(), "'Login' button not active");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Войти'")
    public void openPopUpStep(){
        registrationClient.openPopUp();
        step("Проверяем активность кнопки 'Забыли пароль'", () -> {
            Assert.assertTrue(registrationClient.checkForgotPassword(), "The 'Forgot Password' button is inactive");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Зарегистрироватся'")
    public void clickRegistrationStep(){
        registrationClient.clickRegistration();
        step("Проверяем активность кнопки 'Стать клиентом'", () -> {
            Assert.assertTrue(registrationClient.checkNewRegistrationClientButton(),"The 'Become a customer' button is inactive");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Стать клиентом'")
    public void clickRegistrationClientStep(){
        registrationClient.clickRegistrationClient();
        step("Проверяем активность кнопки 'Зарегистрироватся'", () -> {
            Assert.assertTrue(registrationClient.checkRegistrationClientOnFieldRegistration(), "'Register' button is not active");
        });
        screenShotStep();
    }

    @Step("Ввести в поле 'Ваше имя' имя")
    public void inputPersonNameStep(String  name){
        registrationClient.inputPersonName(name);
        step("Поле заполненно именем", () -> {
            Assert.assertTrue(registrationClient.checkRegistrationNameField(name), "'Name' field is empty");
        });
        screenShotStep();
    }

    @Step ("Ввести в поле 'Должность' должность")
    public void inputPositionStep(String position){
        registrationClient.inputPosition(position);
        step("Поле заполненно должностью", () -> {
            Assert.assertTrue(registrationClient.checkRegistrationPositionField(position), "The field 'Position' is not filled");
        });
        screenShotStep();
    }

    @Step("Ввести в поле 'Компания' компанию")
    public void inputCompanyNameStep(String company){
        registrationClient.inputCompanyName(company);
        step("Поле заполненно компанией", () -> {
            Assert.assertTrue(registrationClient.checkRegistrationCompanyField(company), "Field 'Company' is not filled");
        });
        screenShotStep();
    }

    @Step("Ввести в поле 'Почта' почту")
    public void inputEmailStep(String emailTest){
        registrationClient.inputEmail(emailTest);
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationClient.checkRegistrationEmailField(emailTest), "'Mail' field is empty");
        });
        screenShotStep();
    }

    @Step("Ввести в поле 'Номер' номер")
    public void inputPhoneStep(String phone){
        registrationClient.inputPhone(phone);
        step("Поле заполненно номером", () -> {
            Assert.assertTrue(registrationClient.checkRegistrationPhoneNumberField(phone), "'Number' field is empty");
        });
        screenShotStep();
    }

    @Step ("Ввести в поле 'Ссылка на сайт'")
    public void inputSiteStep(String  siteTest){
        registrationClient.inputSite(siteTest);
        step("Поле заполненно ссылкой", ()-> {
            Assert.assertTrue(registrationClient.checkRegistrationSiteField(siteTest), "The 'link to the site' field is empty");
        });
        screenShotStep();
    }

    @Step ("Нажать кнопку 'Зарегистрироватся'")
    public void clickFinishRegistrationStep(){
        registrationClient.clickFinishRegistration();
        step("Элемент 'галочка' активна", () -> {
            Assert.assertTrue(registrationClient.checkmark(), "'Checkmark' not active");
        });
        screenShotStep();
    }

    @Step("Ввести в поле 'Почта' почту")
    public void loginFieldStep(String emailTest){
        registrationClient.inputEmailClient(emailTest);
        step("Поле заполненно почтой", () -> {
            Assert.assertTrue(registrationClient.checkLoginFiled(emailTest), "'Mail' field is empty");
        });
        screenShotStep();
    }

    @Step("Ввести в поле 'Пароль' пароль")
    public void passwordFieldStep(String passwordTest){
        registrationClient.inputPasswordClient(passwordTest);
        step("Поле заполненно паролем", () -> {
            Assert.assertTrue(registrationClient.checkPasswordField(passwordTest), "'Password' field is empty");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Войти'")
    public void inButtonStep(){
        registrationClient.logInClient();
        step("Проверяем активность кнопки 'Выйти'", () -> {
            Assert.assertTrue(registrationClient.checkLogout(), "'Login' button not active");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Выйти'")
    public void logOutStep(){
        registrationClient.logOut();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue(registrationClient.checkLoginButton(), "'Logout' button not active");
        });
        screenShotStep();
    }

}
