package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class successfulLogin {

    public successfulLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement login;

    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
    WebElement backPack;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backPackCart;

    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        login.click();
    }

    public WebElement backpack(){
        return backPack;
    }
    public void sauce_back_backpack_cart(){

    }
}
