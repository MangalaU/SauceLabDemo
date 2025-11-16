import PageObject.successfulLogin;
import Util.Base;
import Util.PropertiesLoader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;


public class SuccessfulLoginPage extends Base {
    WebDriverWait wait;

    @BeforeMethod
    public void initWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void LoginTest() {

        successfulLogin loginPage = new successfulLogin(driver);

        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickLogin();

        System.out.println("Login test executed successfully.");
    }

}
