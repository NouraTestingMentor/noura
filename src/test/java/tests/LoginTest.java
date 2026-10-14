package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.List;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    @BeforeMethod
    public void createloginPage(){
        loginPage =new LoginPage(driver);
    }

    @Test
    public void validLogin(){
        loginPage.login("Admin", "admin123");
        Assert.assertTrue(loginPage.isRedirected(), "User not redirected to the dashboard ");
    }

    @Test
    public void invalidUsername(){
        loginPage.login("Amin", "admin123");
        Assert.assertEquals(loginPage.getErrorMessage(),"Invalid credentials", "Error message not shown");

    }
    @Test
    public void invalidPassword(){
        loginPage.login("Admin", "admin1");
        Assert.assertEquals(loginPage.getErrorMessage(),"Invalid credentials", "Error message not shown");

    }
    @Test
    public void emptyFieldsLogin(){
        loginPage.clickLoginButton();
        List<String> messages =loginPage.getRequiredMessage();
        for (String message : messages){
            Assert.assertEquals(message, "Required", "Required message not shown");

        }
    }
}
