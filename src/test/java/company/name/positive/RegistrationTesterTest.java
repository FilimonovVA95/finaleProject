package company.name.positive;

import company.name.DriverManager;
import company.name.pages.OneOffMailPageThroughRequests;
import company.name.pages.RegistrationClient;
import company.name.positive.steps.RegistrationTesterTestPositiveStep;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Класс теста регистрации тестера
 * @see RegistrationClient
 * @see OneOffMailPageThroughRequests
 */
public class RegistrationTesterTest {
    private String emailTest = OneOffMailPageThroughRequests.getNewEmail();

    private RegistrationTesterTestPositiveStep step = new RegistrationTesterTestPositiveStep();
    private String passwordTest;


    @Test
    public void registrationTesterTest() {
        step.openTestStandStep();
        step.openPopUpStep();
        step.clickRegistrationStep();
        step.clickRegistrationTesterStep();
        step.inputEmailStep(emailTest);
        step.clickFinishRegistrationStep();
        step.loginButtonClickStep();
        passwordTest = OneOffMailPageThroughRequests.getPassword();
        step.loginFieldStep(emailTest);
        step.passwordFieldStep(passwordTest);
        step.inButtonStep();
        step.logOutStep();
        OneOffMailPageThroughRequests.deleteEmail();
        DriverManager.quit();
    }
}