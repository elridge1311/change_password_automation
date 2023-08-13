package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverInstance extends ConfigProperties{

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static Properties properties;

    static {
        try {
            properties = getProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriverInstance() throws IOException {
    }

    public static WebDriver getDriver()
    {
        if(driver.get() == null)
        {
            try{
                driver.set(createDriver());
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public  static WebDriver createDriver() throws IOException {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome_driver_path"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void cleanUpDriver()
    {
        driver.get().quit();
        driver.remove();
    }

}
