package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties prop;


    @BeforeClass
    public void setup() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/testData/data.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        switch (browserName.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();

                // ✔️ FULL CHROME OPTIONS THAT STOP PASSWORD LEAK POPUP
                ChromeOptions options = new ChromeOptions();

                // Disable Chrome password manager popups
                options.addArguments("--disable-password-manager-reauthentication");
                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--incognito");

                // Disable Chrome security features that trigger the popup
                options.addArguments("--disable-features=PasswordLeakDetection");
                options.addArguments("--disable-features=PasswordManagerOnboarding");
                options.addArguments("--disable-features=EnableAffiliationBasedMatching");
                options.addArguments("--disable-features=ChromeSafetyCheck");
                options.addArguments("--disable-features=SafetyCheck");

                // Disable password manager services
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(options);
                break;


            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser name in properties file!");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.get(prop.getProperty("sauceDemo"));
        System.out.println("Application started → " + driver.getTitle());
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



