package company.name.positive;

import company.name.DriverManager;
import company.name.pages.OneOffMailPageThroughRequests;
import company.name.pages.RegistrationClientPage;
import company.name.pages.RegistrationTesterPage;
import org.testng.annotations.Test;


/**
 * Класс теста регистрации тестера
 * @see RegistrationClientPage
 * @see OneOffMailPageThroughRequests
 */
public class RegistrationTesterTest {
    private String emailTest = OneOffMailPageThroughRequests.getNewEmail();

    private RegistrationTesterPage step = new RegistrationTesterPage();
    private String passwordTest;


    @Test
    public void registrationTesterTest() {
        step.openTestStand();
        step.openPopUp();
        step.clickRegistration();
        step.clickRegistrationTester();
        step.inputEmail(emailTest);
        step.clickFinishRegistration();
        step.openPopUp();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step.inputEmailTester(emailTest);
        step.inputPasswordTester(passwordTest);
        step.logInClick();
        step.logOut();
        OneOffMailPageThroughRequests.deleteEmail();
        DriverManager.quit();
    }
}