import PageObject.successfulLogin;
import Util.Base;
import Util.PropertiesLoader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

import io.qameta.allure.Description;
import io.qameta.allure.Step;


public class SuccessfulLoginPage extends Base {
    WebDriverWait wait;

    @BeforeMethod
    public void initWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void LoginTest() {

        successfulLogin loginPage = new successfulLogin(driver);

        // Login actions
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickLogin();

        // 🔹 Assert Login Successful → URL changes OR element is visible
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed — inventory page not opened.");
        System.out.println("Login successful: Inventory page loaded.");

        // Add item to cart
        loginPage.sauce_back_backpack_cart();

        // 🔹 Assert Product Name (Backpack) is correct
        Assert.assertEquals(loginPage.backpack().getText(), "Sauce Labs Backpack", "Product name mismatch!");
        System.out.println(" Correct product added: Sauce Labs Backpack");

        // Navigate to cart
        loginPage.click_cart();

        // 🔹 Assert cart page is displayed
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Cart page not opened.");
        System.out.println("Cart page opened.");

        // Click checkout button
        loginPage.click_on_checkout_Btn();

        // 🔹 Assert checkout step one page
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"), "Checkout Step One page not opened.");
        System.out.println("Checkout Step One page loaded.");

        // Enter checkout details
        loginPage.enterFirstName(prop.getProperty("firstName"));
        loginPage.enterLastName(prop.getProperty("LastName"));
        loginPage.enterPostalCode(prop.getProperty("Postal"));

        loginPage.clickon_continue();

        // 🔹 Assert checkout step two page
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"), " Checkout Step Two page not opened.");
        System.out.println("Order Placed Successfully");

    }


}

