package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//public class LoginTests added extends TestBase!
public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if button ' Logout ' present == click to ' Logout ' for check all tests
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    //    svngdv@gmail.com   A123456789a@      -login and password
    public void loginSuccess() {
        app.getHelperUser().openLoginForm(); //formula  ==   app. --> getHelperUser(). --> openLoginRegistrationForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submitLogin();
        //Asert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        app.getHelperUser().clickOkButton();
        Assert.assertTrue(app.getHelperUser().isLogged());
        app.getHelperUser().logout();

    }

    //@Test



}
