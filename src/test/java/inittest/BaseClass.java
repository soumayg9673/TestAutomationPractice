package inittest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;

    private static final ArrayList<String> propertiesFiles = new ArrayList<>(
            List.of(("application.properties"))
    );

    static {
        readProperties();
        createWebDriver();
    }

    private static void readProperties() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        properties = new Properties();
        for (String propertyFile : propertiesFiles) {
            try (InputStream resource = loader.getResourceAsStream(propertyFile)) {
                properties.load(resource);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static void createWebDriver() {
        System.out.println(properties.getProperty("webdriver.browser"));
        switch (properties.getProperty("webdriver.browser")){
            case "chrome":
                System.setProperty("webdriver.chrome.driver",properties.getProperty("webdriver.location"));
                driver = new ChromeDriver();
                break;
            case "msedge" :
                System.setProperty("webdriver.msedge.driver",properties.getProperty("webdriver.location"));
                driver = new EdgeDriver();
                break;
            case "firefox" :
                System.setProperty("webdriver.firefox.driver",properties.getProperty("webdriver.location"));
                driver = new FirefoxDriver();
                break;
            default: throw new WebDriverException("webdriver property is not defined");
        }
    }

}
