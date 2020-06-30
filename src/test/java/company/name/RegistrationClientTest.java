package company.name;

import company.name.pages.OneOffMailPageThroughRequests;
import company.name.pages.RegistrationClient;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author
 */
public class RegistrationClientTest {
    final String newEmailTenMinutes = OneOffMailPageThroughRequests.getNewEmail();
    final String newPassword = OneOffMailPageThroughRequests.getPassword();

    WebDriver driver = DriverManager.getDriver();
    RegistrationClient registrationClient = new RegistrationClient(driver);
}
