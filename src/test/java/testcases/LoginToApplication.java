package testcases;
/*
Author Debarghya
 */

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;
import utility.ConfigDataProvider;

public class LoginToApplication extends BaseTest {
    public ConfigDataProvider config = new ConfigDataProvider();

    //Login to Airbnb portal
    @Test
    void verifyLogin(){
        LoginPage loginPage = new LoginPage(driver);
        String username = config.getUser();
        String password = config.getPass();

        loginPage.loginPortal(username,password);

    }
}
