package company.name.positive;

import company.name.DriverManager;
import company.name.pages.OneOffMailPageThroughRequests;
import company.name.pages.RegistrationClientPage;
import org.testng.annotations.Test;


/**
 * Класс теста регистрации клиента
 * @see RegistrationClientPage
 * @see OneOffMailPageThroughRequests
 */
public class RegistrationClientTest {

    /**
     * Поля, используемые при регистрации клиента
     */
    private String name = "Name";
    private String position = "Position";
    private String company = "Company";
    private String phone = "+7 999 435-34-44";
    private String siteTest = "https://test.uxcrowd.ru/";
    private String emailTest = OneOffMailPageThroughRequests.getNewEmail();

    private RegistrationClientPage step = new RegistrationClientPage();
    private String passwordTest;

    @Test
    public void createTestClient(){
        step.openTestStand();
        step.openPopUp();
        step.clickRegistration();
        step.clickRegistrationClient();
        step.inputPersonName(name);
        step.inputPosition(position);
        step.inputCompanyName(company);
        step.inputEmail(emailTest);
        step.inputPhone(phone);
        step.inputSite(siteTest);
        step.clickFinishRegistration();
        step.openPopUp();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step.inputEmailClient(emailTest);
        step.inputPasswordClient(passwordTest);
        step.logInClient();
        step.logOut();
        OneOffMailPageThroughRequests.deleteEmail();
        DriverManager.quit();
    }
}
