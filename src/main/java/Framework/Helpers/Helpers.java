package Framework.Helpers;

import Framework.Pages.BasePage;
import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Helpers {

    @SneakyThrows
    public static void makeScreenShot() {
        File scrFile = ((TakesScreenshot) BasePage.getWebDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(
                scrFile,
                new File("C:\\Java\\Screenshots"
                        + new Faker().random().hex(10) + ".png")
        );
    }


    @Attachment(value = "{fileName}", type = "image/png")
    public static byte[] makeScreenShot(String fileName) {
        return ((TakesScreenshot) BasePage.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
