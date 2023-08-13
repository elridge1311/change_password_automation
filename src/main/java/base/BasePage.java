package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class BasePage extends ConfigProperties{


    public static WebDriver getDriver() {
        return WebDriverInstance.getDriver();
    }

    public String getUrl() throws IOException {
        return getProperties().getProperty("url");
    }

    public void takeSnapShot(String name) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File destFile = new File(getProperties().getProperty("screenshot_dir")+ "\\" + timestamp() + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }



}
