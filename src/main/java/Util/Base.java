package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                driver = new ChromeDriver();
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

//    // Utility Screenshot Function
//    public static String takeScreenshot(String testCaseName) {
//
//        try {
//            File src = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
//            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//            String path = System.getProperty("user.dir") + "/Reports/Screenshots/"
//                    + testCaseName + "_" + timestamp + ".png";
//
//            FileUtils.copyFile(src, new File(path));
//            return path;
//
//        } catch (Exception e) {
//            System.out.println("Screenshot failed: " + e.getMessage());
//            return null;
//        }
//    }

}
