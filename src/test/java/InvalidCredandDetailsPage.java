import PageObject.successfulLogin;
import Util.Base;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Step;


import java.time.Duration;

public class InvalidCredandDetailsPage extends Base {
    WebDriverWait wait;

    @BeforeMethod
    public void initWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void InvalidCredential(){
        successfulLogin loginPage = new successfulLogin(driver);

        // Login actions
        loginPage.enterUsername(prop.getProperty("Invalidusername"));
        loginPage.enterPassword(prop.getProperty("Invalidpassword"));
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.error_msg().getText(),
                "Epic sadface: Username and password do not match any user in this service");

        System.out.println("Invalid credential test executed successfully.");

    }

}
