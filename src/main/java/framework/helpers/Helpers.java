package framework.helpers;

import framework.pages.BasePage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;

public class Helpers {
    @Attachment(value = "{fileName}", type = "image/png")
    public static byte[] makeScreenShot(String fileName) {
        return ((TakesScreenshot) BasePage.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static String rgbToHex(int r, int g, int b) {
        Color color = new Color(r, g, b);
        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
        if (hex.length() < 6) {
            hex = "0" + hex;
        }
        return "#" + hex;
    }
}