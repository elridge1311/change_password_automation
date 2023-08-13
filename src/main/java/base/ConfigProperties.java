package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\config.properties");
        properties.load(data);
        return properties;
    }

}
