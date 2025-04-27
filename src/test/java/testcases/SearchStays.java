package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utility.ConfigDataProvider;

public class SearchStays extends BaseTest {
    HomePage homepage;
    public ConfigDataProvider config = new ConfigDataProvider();


    @BeforeMethod
    public void setUp(){
        LoginPage loginPage = new LoginPage(driver);
        String username = config.getUser();
        String password = config.getPass();
        homepage= loginPage.loginPortal(username,password);
    }


    @Test
    void searchStays()  {

        // Verify the searching of Stays
        homepage.verifySearchStays();

    }
}
