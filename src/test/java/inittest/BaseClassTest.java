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

import com.flipkart.BaseClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;

@Listeners(ListenerTest.class)
public class BaseClassTest {

    public static WebDriver driver;
    public static Properties properties;

    public static  BaseClass baseClass;

    private static final ArrayList<String> propertiesFiles = new ArrayList<>(
            List.of(("application.properties"))
    );

    static {
        readProperties();
        createWebDriver();
        initBaseClass();
        startBrowserSession();
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

    private static void initBaseClass() {
        baseClass = new BaseClass(driver);
    }

    private static  void startBrowserSession() {
        driver.get(properties.getProperty("baseurl"));
    }

}