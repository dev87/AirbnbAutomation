package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[@aria-label='Airbnb homepage']")
    WebElement airbnbLogo;

    @FindBy(xpath = "//span[@data-content='Stays']")
    WebElement stays;

    @FindBy(xpath = "//span[@data-content='Experiences']")
    WebElement experiences;

    //constructor
    public HomePage(WebDriver lDriver) {
        this.driver = lDriver;
        PageFactory.initElements(driver,this);
    }

    public void verifyMenus(){

        airbnbLogo.click();

        String actualStaysText = stays.getText();
        String expectedStaysText = "Stays";
        Assert.assertEquals(actualStaysText,expectedStaysText);

        String actualExperincesText = experiences.getText();
        String expectedExperiencesText = "Experiences";
        Assert.assertEquals(actualExperincesText,expectedExperiencesText);

        System.out.println("Airbnb Home page menu test is passed");

    }

}
