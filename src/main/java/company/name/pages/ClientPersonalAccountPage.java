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
    private WebElement loginButton;             //Кнопка открытия окна входа

    @FindBy(id = "login")
    private WebElement loginFiled;              //Поле для ввода логина при входе

    @FindBy(css = "[type=password]")
    private WebElement passwordField;           //Поле для ввода пароля

    @FindBy(css = "#form_auth button")
    private WebElement submitButton;            //Кнопка для входа

    /**
     * Локаторы поиска для личного кабинета клииента
     */

    @FindBy(id = "logout")
    private WebElement exitButton;             // Кнопка выхода из личного кабинета

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[1]/div[2]/a")
    private WebElement profileSettingsButton;  //Кнопка входа в настройки профиля

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/input")
    private WebElement userNameField;          // Поле логин пользователя yedake3020, пароль HJobXi

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/input")
    private WebElement emailAddressField;      //Поле email пользователя yedake3020@mijumail.com

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[1]/form[2]/div[1]/input")
    private WebElement fioField;               //Поле ФИО пользователя Rost

    public ClientPersonalAccountPage(WebDriver driver) {
        super(driver);
        this.testStand = super.testStand;
        this.driver = driver;
    }
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
     * Открыть окошко для входа
     */
        public void logIn(){
            loginButton.click();
            loginFiled.sendKeys(login);
            passwordField.sendKeys(password);
            submitButton.click();
        }

    /**
     * Открыть настройки профиля клиента
      */
    public void profilInfoIn(){
        profileSettingsButton.click();
    }

    /**
     * Проверка поля логин
     */
    public void checkLogin(){
        userNameField.getText().equals(login);
    }

    /**
     * Проверка поля email
     */
    public void checkEmail(){
        emailAddressField.getText().equals(email);
    }

    /**
     * Проверка поля ФИО
     */
    public void chekFIO(){
        fioField.getText().equals(FIO);
    }
    /**
     * Выйти из личного кабинета клиента
     */
    public void logOut(){
        exitButton.click();
    }

}
