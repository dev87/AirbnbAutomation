package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    //constructor
    public LoginPage(WebDriver lDriver) {
        this.driver = lDriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(text(),'Continue with email')]")
    WebElement loginEmailLink;

    @FindBy(xpath = "//input[@id='email-login-email']")
    WebElement loginEmailBox;

    @FindBy(css = ".t1dqvypu.dir.dir-ltr")
    WebElement continueBtn;

    @FindBy(xpath = "//input[@id='email-signup-password']")
    WebElement loginPassBox;

    @FindBy(css = ".t1dqvypu.dir.dir-ltr")
    WebElement loginBtn;

    //Login to the Airbnb portal
    public void loginPortal(String username,String password){

        loginEmailLink.click();
        loginEmailBox.sendKeys(username);
        continueBtn.click();
        loginPassBox.sendKeys(password);
        loginBtn.click();

        System.out.println("Login to Airbnb portal test is passed");

    }

}
