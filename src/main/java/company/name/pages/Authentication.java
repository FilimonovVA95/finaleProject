package company.name.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Authentication {


    @FindBy(id = "header-lk-button")            //кнопка открытия окна авторизации
    private WebElement loginButton;

    @FindBy(id = "login")
    private WebElement loginFiled;              //поле для ввода логина при входе

    @FindBy(css = "[type=password]")
    private WebElement passwordField;           //поле для ввода пароля

    @FindBy(css = "[ng-tr=\"WHE1.WHE4\"]")      // Кнопка войти в аккаунт
    private WebElement clickLogIn;

    @FindBy(id = "logout")                      // Кнопка выйти
    private WebElement clickLogOut;

    /*
    открыть всплывающее окно входа
     */
    public void openPopUp() {
        loginButton.click();
    }
    /*
    ввести email
     */
    public void inputEmail(String email){
        loginFiled.sendKeys(email);
    }
    /*
    ввесьи пароль
     */
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }
    /*
    нажать кнопку войти
     */
    public void clickAuthentication(){
        clickLogIn.click();
    }
    /*
    нажать кнопку выйти
     */
    public void logOut(){
        clickLogOut.click();
    }
}
