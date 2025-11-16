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

    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    WebElement cart ;

    @FindBy(id = "checkout")
    WebElement checkout_btn;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
    WebElement errormsg;


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
        backPackCart.click();

    }
    public void click_cart(){
        cart.click();
    }
    public void click_on_checkout_Btn(){
        checkout_btn.click();

    }
    public void enterFirstName(String firstname){
        firstName.sendKeys(firstname);
    }
    public void enterLastName(String lastname){
        lastName.sendKeys(lastname);
    }
    public void enterPostalCode(String postalcode){
        postalCode.sendKeys(postalcode);
    }
    public void clickon_continue(){
        continueBtn.click();
    }
    public WebElement error_msg(){
        return errormsg;
    }
}


