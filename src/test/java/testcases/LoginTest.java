package testcases;
/*
Author Debarghya
 */

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    //Verify login to Airbnb portal
    @Test
    void verifyLogin(){
        LoginPage loginPage = new LoginPage(driver);
        String username = "hindu.warrior87@gmail.com";
        String password ="20121987@sb";

        loginPage.loginPortal(username,password);

    }
}
