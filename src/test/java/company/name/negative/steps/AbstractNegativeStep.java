package company.name.negative.steps;

import company.name.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractNegativeStep {

    /**
     * Метод для получения скриншота и сохранения его в папке screenShots
     */
    @Attachment(value = "Page screenshot", type = "image")
    protected void screenShotStep() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File screen = ts.getScreenshotAs(OutputType.FILE);
        String screenName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        try {
            FileUtils.copyFile(screen, new File("./ScreenShots/"+screenName+"_Screenshot.png"));
        } catch (IOException e) {
            System.out.println("Exception while taking ScreenShot "+e.getMessage());
            e.printStackTrace();
        }
    }

}