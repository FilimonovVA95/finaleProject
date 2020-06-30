package company.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс личного кабинета тестера
 * @author Rostislav Efimov
 */
public class TesterPersonalAccountPage extends AbstractPage {
    /**
     * Локаторы поиска на стартовой странице (testStand)
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
     * Локаторы поиска для личного кабинета тестера
     */
    @FindBy(id = "logout")
    private WebElement exitButton;

    public TesterPersonalAccountPage(WebDriver driver) {
        super(driver);
        this.testStand = super.testStand;
        this.driver = driver;
    }

    private String testStand;
    private WebDriver driver;
    private final String login = "ribeni5999@aqumail.com";
    private final String password = "v3Kiw7";
    /**
     * Открытие тестового стэнда
     */
    public void openTestStand(){
        driver.get(testStand);
    }

    /**
     * Открыть окошко для входа, регистрации и тд.
     */
    public void logIn(){
        loginButton.click();
        loginFiled.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    /**
     * Выйти из личного кабинета тестера
     */
    public void logOut(){
        exitButton.click();
    }

}
