package company.name.positive;

import company.name.DriverManager;
import company.name.pages.OneOffMailPageThroughRequests;
import company.name.positive.steps.RegistrationClientTestPositiveStep;
import org.junit.jupiter.api.Test;

/**
 * Класс теста регистрации клиента
 * @author Akmataliev Almaz
 * @see company.name.pages.RegistrationClient
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

    private RegistrationClientTestPositiveStep step = new RegistrationClientTestPositiveStep();
    private String passwordTest;

    @Test
    public void createTestClient(){
        step.openTestStand();
        step.openPopUpStep();
        step.clickRegistrationStep();
        step.clickRegistrationClientStep();
        step.inputPersonNameStep(name);
        step.inputPositionStep(position);
        step.inputCompanyNameStep(company);
        step.inputEmailStep(emailTest);
        step.inputPhoneStep(phone);
        step.inputSiteStep(siteTest);
        step.clickFinishRegistrationStep();
        step.openPopUpStep();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step.loginFieldStep(emailTest);
        step.passwordFieldStep(passwordTest);
        step.inButtonStep();
        step.logOutStep();
        OneOffMailPageThroughRequests.deleteEmail();
        DriverManager.quit();
    }
}
