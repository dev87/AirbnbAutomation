package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[@aria-label='Airbnb homepage']")
    WebElement airbnbLogo;

    @FindBy(xpath = "//span[@data-content='Stays']")
    WebElement stays;

    @FindBy(xpath = "//span[@data-content='Experiences']")
    WebElement experiences;

    @FindBy(xpath = "//label[@for='bigsearch-query-location-input']")
    WebElement whereTextbox;

    @FindBy(xpath = "//div[normalize-space()='Check in']")
    WebElement checkIn;

    @FindBy(xpath = "(//button[normalize-space()='Flexible'])[1]")
    WebElement flexible;

    @FindBy(xpath = "//div[normalize-space()='Who']")
    WebElement addGuest;

    @FindBy(xpath = "(//span[@class='i98ho2o atm_e2_qslrf5 atm_vy_qslrf5 atm_l8_14y27yu dir dir-ltr'])[2]")
    WebElement adultGuest;

    @FindBy(xpath = "(//span[@class='i98ho2o atm_e2_qslrf5 atm_vy_qslrf5 atm_l8_14y27yu dir dir-ltr'])[4]")
    WebElement childrenGuest;

    @FindBy(xpath = "(//span[@class='t1dqvypu atm_9s_1ulexfb atm_vy_1osqo2v atm_e2_1osqo2v atm_jb_uuw12j atm_2w_1egmwxu atm_k4_idpfg4 atm_uc_kn5pbq atm_2g_1mygper atm_k4_kb7nvz_1nos8r atm_uc_yz1f4_csw3t1 atm_k4_idpfg4_csw3t1 atm_tr_kftzq4_csw3t1 dir dir-ltr'])[1]")
    WebElement searchBtn;

    @FindBy(xpath = "(//span[contains(text(),'places in Paris')])[1]")
    WebElement searchResultText;

    @FindBy(xpath = "(//img[contains(@class, 'i1ezuexe')])[2]")
    WebElement firstSearchResult;


    @FindBy(xpath = "(//span[contains(@class, 'tmel3e0') and contains(@class, 'dir-ltr')])[2]")
    WebElement reserveBtn;


    //constructor
    public HomePage(WebDriver lDriver) {
        this.driver = lDriver;
        PageFactory.initElements(driver, this);
    }
    // Verify the menus of Home page
    public void verifyMenus() {

        airbnbLogo.click();

        String actualStaysText = stays.getText();
        String expectedStaysText = "Stays";
        Assert.assertEquals(actualStaysText, expectedStaysText);

        String actualExperincesText = experiences.getText();
        String expectedExperiencesText = "Experiences";
        Assert.assertEquals(actualExperincesText, expectedExperiencesText);

        System.out.println("Airbnb Home page menu test is passed");

    }

    // Verify the searching of Stays
    public void verifySearchStays() {

        String actual;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(whereTextbox));
        whereTextbox.click();
        whereTextbox.sendKeys("Paris");

        checkIn.click();
        flexible.click();
        addGuest.click();
        adultGuest.click();
        childrenGuest.click();
        searchBtn.click();

        actual = searchResultText.getText();
        Assert.assertTrue(actual.contains("places in Paris"));

        System.out.println("Verify Search Stays test is passed");
    }

    // Verify the booking of Stays
    public void verifyBookStays() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        whereTextbox.click();
        whereTextbox.sendKeys("Paris");

        checkIn.click();
        flexible.click();
        addGuest.click();
        adultGuest.click();
        childrenGuest.click();
        searchBtn.click();
        firstSearchResult.click();

        // Store the current window handle
        String originalWindow = driver.getWindowHandle();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Loop through all window handles
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        reserveBtn.click();
        System.out.println("Booked stays successfully");


    }
}
